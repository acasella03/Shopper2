package com.shopper2.controlador;

import com.shopper2.modelo.repartidores.Repartidor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepartidorDao {

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
     * Buscar repartidor en la base de datos según su código
     *
     * @param codr a buscar
     * @return repartidor encontrado en la base de datos
     */
    public Repartidor buscar(int codr) {
        connect();
        Repartidor repartidor = new Repartidor();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * from repartidores where codr=?");
            sentencia.setInt(1, codr);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                repartidor.setCodr(resultado.getInt("codr"));
                repartidor.setNomr(resultado.getString("nomr"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return repartidor;
    }
}
