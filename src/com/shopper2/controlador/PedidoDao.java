package com.shopper2.controlador;

import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.repartidores.Repartidor;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDao {

    /**
     * Ruta de ubicación de la base de datos
     */
    String url = "file:///C://Users//Angita//IdeaProjects//Shopper2//base_de_datos//basededatos.db";

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
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
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
     * @param pedido a buscar
     * @return pedido encontrado en la base de datos
     */
    public Pedido buscar(Pedido pedido) {
        connect();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * from pedidos where codpe=?");
            sentencia.setInt(1, pedido.getCodpe());
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                pedido.setCodpe(Integer.parseInt(resultado.getString("codpe")));
                pedido.setNomCliente(resultado.getString("nomCliente"));
                pedido.setDireccionCliente(resultado.getString("direccionCliente"));
                pedido.setFecha(resultado.getDate("fecha"));
                pedido.setRepartidor((Repartidor) resultado.getObject("repartidor"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return pedido;
    }
    
     public ArrayList<Pedido> buscarTodos() {
        connect();
        ArrayList<Pedido> pedidos=new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * from pedidos");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Pedido pedido=new Pedido();
                pedido.setCodpe(resultado.getInt("codpe"));
                pedido.setNomCliente(resultado.getString("nomCliente"));
                pedido.setDireccionCliente(resultado.getString("direccionCliente"));
                pedido.setFecha(resultado.getDate("fecha"));
                Repartidor repartidor=new Repartidor();
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
    public Pedido crear(Pedido pedido) {

        connect();

        try {

            PreparedStatement insertarPedidos = conexion.prepareStatement("INSERT into pedidos (nomCliente, direccion, fecha, codr) VALUES (?,?,?,?)");

            insertarPedidos.setString(1, pedido.getNomCliente());
            insertarPedidos.setString(2, pedido.getDireccionCliente());
            insertarPedidos.setDate(3, (Date) pedido.getFecha());//bien casteado? - Hay dos tipos de date, cuál?
            insertarPedidos.setInt(4, pedido.getRepartidor().getCodr());
            insertarPedidos.execute();
            int codpe=2;
            
            PreparedStatement insertarProducto = conexion.prepareStatement("INSERT into tienen (codpe, codpr, cantidad) VALUES (?,?,?)");

            
            
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }

        return pedido;

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
     * @param pedido a eliminar
     * @return pedido eliminado
     */
    public Pedido eliminar(Pedido pedido) {

        connect();

        try {
            PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM pedidos WHERE codpe=?");
            sentencia.setInt(1, pedido.getCodpe());
            sentencia.execute();

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            close();
        }
        return pedido;

    }


}
