package com.shopper2.controlador;

import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.productos.IProducto;
import com.shopper2.modelo.productos.Producto;
import com.shopper2.modelo.repartidores.Repartidor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDao {

    /**
     * Variable auxiliar para Singleton
     */
    private static PedidoDao instance = null;

    /**
     * Método estático que retorna una única instancia
     *
     * @return instancia única
     */
    public static PedidoDao getInstance() {
        if (instance == null) {
            instance = new PedidoDao();
        }
        return instance;
    }

    /**
     * Constructor privado para ser utilizado únicamente por el Singleton.
     */
    private PedidoDao() {
    }

    /**
     * Conexion a la base de datos
     */
    Connection conexion = null;

    /**
     * Realiza la conexión a la base de datos
     */
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:base_de_datos/basededatos.db");
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());

        } catch (ClassNotFoundException e) {
            Logger.getLogger(RepartidorDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Realiza la desconexión de la base de datos
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            Logger.getLogger(RepartidorDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Buscar pedido en la base de datos según su código
     *
     * @param codpe a buscar
     * @return pedido encontrado en la base de datos
     */
    public Pedido buscar(int codpe) {
        connect();
        Pedido pedido = new Pedido();
        try {
            PreparedStatement buscarPedido = conexion.prepareStatement("SELECT * from pedidos where codpe=?");
            buscarPedido.setInt(1, codpe);
            ResultSet resultadoPedido = buscarPedido.executeQuery();
            if (resultadoPedido.next()) {
                pedido.setCodpe(resultadoPedido.getInt("codpe"));
                pedido.setNomCliente(resultadoPedido.getString("nomCliente"));
                pedido.setDireccionCliente(resultadoPedido.getString("direccion"));
                pedido.setFecha(resultadoPedido.getDate("fecha"));
                Repartidor repartidor = new Repartidor();
                repartidor.setCodr(resultadoPedido.getInt("codr"));
                pedido.setRepartidor(repartidor);

                PreparedStatement buscarProducto = conexion.prepareStatement("SELECT * from tienen where codpe=?");
                buscarProducto.setInt(1, codpe);
                ResultSet resultadoProducto = buscarProducto.executeQuery();
                close();
                while (resultadoProducto.next()) {
                    int cantidad = resultadoProducto.getInt("cantidad");
                    int codpr = resultadoProducto.getInt("codpr");
                    Producto producto = ProductoDao.getInstance().buscar(codpr);
                    pedido.addProducto(producto,cantidad);
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return pedido;
    }

    /**
     * Metodo que nos devuelve todos los pedidos
     *
     * @return todos los pedidos
     */
    public ArrayList<Pedido> buscarTodos() {
        connect();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * from pedidos");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Pedido pedido = new Pedido();
                pedido.setCodpe(resultado.getInt("codpe"));
                pedido.setNomCliente(resultado.getString("nomCliente"));
                pedido.setDireccionCliente(resultado.getString("direccion"));
                pedido.setFecha(resultado.getDate("fecha"));
                Repartidor repartidor = new Repartidor();
                repartidor.setCodr(resultado.getInt("codr"));
                pedido.setRepartidor(repartidor);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return pedidos;
    }

    /**
     * Registrar pedido en la base de datos
     *
     * @param pedido que queremos registrar
     * @return pedido registrado
     */
    public boolean crear(Pedido pedido) { //botón GUARDAR
        connect();
        try {
            PreparedStatement insertarPedidos = conexion.prepareStatement("INSERT into pedidos (nomCliente, direccion, fecha, codr) VALUES (?,?,?,?)");
            insertarPedidos.setString(1, pedido.getNomCliente().toLowerCase());
            insertarPedidos.setString(2, pedido.getDireccionCliente().toLowerCase());
            insertarPedidos.setDate(3, (Date) pedido.getFecha());//bien casteado? - Hay dos tipos de date, cuál?
            insertarPedidos.setInt(4, pedido.getRepartidor().getCodr());
            insertarPedidos.executeUpdate();

            PreparedStatement obtenerCodpe = conexion.prepareStatement("SELECT last_insert_rowid() AS codpe");
            ResultSet resultado = obtenerCodpe.executeQuery();
            int codpe = resultado.getInt("codpe");
            System.out.println(codpe);

            if (pedido.getProductos() != null) {
                PreparedStatement insertarProducto = conexion.prepareStatement("INSERT into tienen (codpe, codpr, cantidad) VALUES (?,?,?)");
                for (Map.Entry<IProducto, Integer> entrada : pedido.getProductos().entrySet()) {
                    IProducto producto = entrada.getKey();
                    Integer cantidad = entrada.getValue();
                    insertarProducto.setInt(1, codpe);
                    insertarProducto.setInt(2, producto.getCodpr());
                    insertarProducto.setInt(3, cantidad);
                    insertarProducto.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            close();
        }
        return true;
    }

    /**
     * Modificar elementos de un pedido
     *
     * @param pedido que queremos modificar
     * @return pedido modificado
     */
    public Pedido modificar(Pedido pedido) {
        connect();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("UPDATE pedidos SET codpe=?, nomCliente=?, direccionCliente=?, fecha=?, codr=? WHERE codpe=?");
            sentencia.setInt(1, pedido.getCodpe());
            sentencia.setString(2, pedido.getNomCliente());
            sentencia.setString(3, pedido.getDireccionCliente());
            sentencia.setDate(4, (Date) pedido.getFecha());//bien casteado? - Hay dos tipos de date
            sentencia.setString(5, String.valueOf(pedido.getRepartidor()));//bien casteado?
            sentencia.setInt(6, pedido.getCodpe());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return pedido;
    }

    /**
     * Eliminar pedido de la base de datos según su código
     *
     * @param codpe pedido a eliminar
     * @return pedido eliminado
     */
    public boolean eliminar(int codpe) {
        connect();
        try {
            PreparedStatement eliminarTienen = conexion.prepareStatement("DELETE FROM tienen WHERE codpe=?");
            eliminarTienen.setInt(1, codpe);
            eliminarTienen.execute();

            PreparedStatement eliminarPedido = conexion.prepareStatement("DELETE FROM pedidos WHERE codpe=?");
            eliminarPedido.setInt(1, codpe);
            eliminarPedido.execute();

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            close();
        }
        return true;
    }

    public int consultarCantidad(int codpe, int codpr) {
        connect();
        int cantidad = 0;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT cantidad FROM tienen WHERE codpe=? AND codpr=?");
            consulta.setInt(1, codpe);
            consulta.setInt(2, codpr);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                cantidad = resultado.getInt("cantidad");
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return cantidad;
    }

}
