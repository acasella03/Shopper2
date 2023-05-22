package com.shopper2.controlador;

import com.shopper2.modelo.repartidores.Repartidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RepartidorDao {

    /**
     *Conjunto de resultados de la base de datos
     */
    ResultSet resultado = null;
    /**
     * Conexion a la base de datos
     */
    Connection conexion = null;//
    // todo crear metodo para conectarse

    /**
     * Buscar repartidor en la base de datos según su código
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