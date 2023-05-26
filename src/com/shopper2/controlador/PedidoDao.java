package com.shopper2.controlador;

import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.repartidores.Repartidor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDao {

    /**
     * Ruta de ubicación de la base de datos
     */
    String url = "file:///C://Users//Angita//IdeaProjects//Shopper2//base_de_datos//basededatos.db";

    /**
     * Conjunto de resultados de la base de datos
     */
    ResultSet resultado = null;

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
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                pedido.setCodpe(Integer.parseInt(resultado.getString("codpe")));
                pedido.setNomCliente(resultado.getString("nomCliente"));
                pedido.setDireccionCliente(resultado.getString("direccionCliente"));
                pedido.setFecha(resultado.getDate("fecha"));//comprobar
                pedido.setRepartidor((Repartidor) resultado.getObject("repartidor"));//comprobar
                //falta algo?

            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return pedido;
    }

    /**
     * Registrar pedido en la base de datos
     *
     * @param pedido que queremos registrar
     * @return pedido registrado
     */
    public Pedido registrar(Pedido pedido) {

        connect();

        try {

            //direccionCliente es direccion en el Script, hay qué cambiarlo?
            PreparedStatement sentencia = conexion.prepareStatement("INSERT into pedidos (codpe, nomCliente, direccionCliente, fecha, codr) VALUES (?,?,?,?,?)");

            sentencia.setInt(1, pedido.getCodpe());
            sentencia.setString(2, pedido.getNomCliente());
            sentencia.setString(3, pedido.getDireccionCliente());
            sentencia.setDate(4, (Date) pedido.getFecha());//bien casteado? - Hay dos tipos de date, cuál?
            sentencia.setString(5, String.valueOf(pedido.getRepartidor()));//bien casteado?
            sentencia.execute();



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
