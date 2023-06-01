package com.shopper2.modelo.dao;

import com.shopper2.modelo.repartidores.Repartidor;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase DAO (Data Access Object) para la gestión de repartidores en la base de datos.
 */
public class RepartidorDao {

    /**
     * Variable auxiliar para Singleton.
     */
    private static RepartidorDao instance = null;

    /**
     * Método estático que retorna una única instancia.
     *
     * @return instancia única.
     */
    public static RepartidorDao getInstance() {
        if (instance == null) {
            instance = new RepartidorDao();
        }
        return instance;
    }

    /**
     * Constructor privado para ser utilizado únicamente por el Singleton.
     */
    private RepartidorDao() {

    }

    /**
     * Conexion a la base de datos.
     */
    Connection conexion = null;

    /**
     * Realiza la conexión a la base de datos.
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
     * Realiza la desconexión de la base de datos.
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            Logger.getLogger(RepartidorDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Busca un repartidor en la base de datos según su código.
     *
     * @param codr cógido del repartidor a buscar.
     * @return repartidor encontrado en la base de datos.
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

    /**
     * Consulta los datos de los reparrtidores en la base de datos.
     *
     * @return los datos de los repartidores.
     */
    public ArrayList<Repartidor> obtenerRepartidores() {
        ArrayList<Repartidor> repartidores = new ArrayList<>();
        // Realizar la consulta a la base de datos y obtener los datos de los repartidores
        try {
            connect();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT codr, nomr FROM repartidores");
            while (resultSet.next()) {
                int codr = resultSet.getInt("codr");
                String nomr = resultSet.getString("nomr");
                Repartidor repartidor = new Repartidor(codr, nomr);
                repartidores.add(repartidor);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            close();
        }
        return repartidores;
    }
}
