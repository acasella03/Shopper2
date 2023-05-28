package com.shopper2.controlador;

import com.shopper2.modelo.enums.Categoria;
import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.productos.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDao {
    /**
     * Variable auxiliar para Singleton
     */
    private static ProductoDao instance = null;
    
    /**
     * Método estático que retorna una única instancia
     *
     * @return instancia única
     */
    public static ProductoDao getInstance(){
        if(instance==null){
            instance = new ProductoDao();
        }
        return instance;
    }
    /**
     * Constructor privado para ser utilizado únicamente por el Singleton.
     */
    private ProductoDao(){
        
    }
    
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
     * Buscar producto en la base de datos según su código
     *
     * @param codpr a buscar
     * @return producto encontrado en la base de datos
     */
    public Producto buscar(int codpr) {
        connect();
        Producto producto = new Producto();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT * from productos where codpr=?");
            sentencia.setInt(1, codpr);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                producto.setCodpr(resultado.getInt("codpr"));
                producto.setNombreProducto(resultado.getString("nompr"));
                producto.setCategoria(Categoria.fromString(resultado.getString("categoria")));
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            close();
        }
        return producto;
    }

    /**
     * Realiza consultas de una tabla
     *
     * @return la lista con todos los productos
     */
    public ArrayList<Producto> listaProductos() {
        connect();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("select * from productos");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setCodpr(resultado.getInt("codpr"));
                producto.setCategoria((Categoria) (Object) resultado.getString("categoria"));
                Pedido pedido = new Pedido();

                listaProductos.add(producto);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            close();
        }
        return listaProductos;
    }
}
