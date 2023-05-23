package com.shopper2.controlador;

import com.shopper2.modelo.enums.Categoria;
import com.shopper2.modelo.productos.Producto;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDao {

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
     * Buscar producto en la base de datos según su código
     *
     * @param producto a buscar
     * @return producto encontrado en la base de datos
     */
    public Producto buscar(Producto producto) {

        connect();

        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * from productos where codpr=?");
            sentencia.setInt(1, producto.getCodpr());
            resultado = sentencia.executeQuery();

            if (resultado.next()) {
                producto.setCodpr(Integer.parseInt(resultado.getString("codpr")));
                producto.setNombreProducto(resultado.getString("nombreProducto"));
                producto.setCategoria(Categoria.valueOf(resultado.getString("categoria")));
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
           close();
        }

        return producto;

    }






}
