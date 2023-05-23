package com.shopper2.controlador;

import com.shopper2.modelo.repartidores.Repartidor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RepartidorDao {

    /**
     * Conjunto de resultados de la base de datos
     */
    ResultSet resultado = null;

    /**
     * Conexion a la base de datos
     */
    Connection conexion = null;

    /**
     * Conectarse a la base de datos
     */
    public void connect() {

        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:");//todo poner enlace que conecta a la base de datos
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
     * Buscar repartidor en la base de datos según su código
     *
     * @param repartidor a buscar
     * @return repartidor encontrado en la base de datos
     */
    public Repartidor buscar(Repartidor repartidor) {

        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * from repartidores where codr=?");
            sentencia.setInt(1, repartidor.getCodr());
            resultado = sentencia.executeQuery();

            if (resultado.next()) {
                repartidor.setCodr(Integer.parseInt(resultado.getString("codr")));
                repartidor.setNomr(resultado.getString("nomr"));
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                conexion.close();//cerramos conexion
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return repartidor;

    }

}