package com.shopper2.modelo.pedido;

import com.shopper2.modelo.productos.IProducto;
import com.shopper2.modelo.productos.Producto;
import com.shopper2.modelo.repartidores.Repartidor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Datos del pedido.
 */
public class Pedido implements IPedido {

    /**
     * Identificador del pedido.
     */
    private int codpe;
    /**
     * Nombre del cliente del pedido.
     */
    private String nomCliente;
    /**
     * Dirección del cliente del pedido.
     */
    private String direccionCliente;
    /**
     * Fecha del pedido.
     */
    private Date fecha;
    /**
     * Repartidor del pedido
     */
    private Repartidor repartidor;
    /**
     * Lista del productos del pedido.
     */
    private final Map<IProducto, Integer> productos = new HashMap<>();

    /**
     * Constructor parametrizado con ID del pedido.
     *
     * @param codpe identificador del pedido.
     * @param nomCliente nombre del cliente del pedido.
     * @param direccionCliente del pedido.
     * @param fecha del pedido
     */
    public Pedido(int codpe, String nomCliente, String direccionCliente, Date fecha) {
        this.codpe = codpe;
        this.nomCliente = nomCliente;
        this.direccionCliente = direccionCliente;
        this.fecha = fecha;
    }

    /**
     * Constructor vacío
     */
    public Pedido() {
    }

    /**
     * Constructor parametrizado sin ID del pedido.
     *
     * @param nomCliente nombre del cliente del pedido.
     * @param direccionCliente del pedido.
     * @param fecha del pedido.
     * @param repartidor del pedido.
     */
    public Pedido(String nomCliente, String direccionCliente, Date fecha, Repartidor repartidor) {
        this.nomCliente = nomCliente;
        this.direccionCliente = direccionCliente;
        this.fecha = fecha;
        this.repartidor = repartidor;
    }

    /**
     * Asigna el identificador del pedido.
     *
     * @param codpe codigo del pedido.
     */
    public void setCodpe(int codpe) {
        this.codpe = codpe;
    }

    /**
     * Asigna el nombre del cliente del pedido.
     *
     * @param nomCliente nombre del cliente.
     */
    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    /**
     * Asigna la dirección del cliente del pedido.
     *
     * @param direccionCliente
     */
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    /**
     * Asigna la fecha del pedido.
     *
     * @param fecha del pedido.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Asigna el repartidor del pedido.
     *
     * @param repartidor asignado al pedido.
     */
    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    /**
     * Obtiene el identificador del pedido.
     *
     * @return identificador del pedido.
     */
    @Override
    public int getCodpe() {
        return codpe;
    }

    /**
     * Obtiene el nombre del cliente del pedido.
     *
     * @return nombre del cliente del pedido.
     */
    @Override
    public String getNomCliente() {
        return nomCliente;
    }

    /**
     * Obtiene la dirección del cliente del pedido.
     *
     * @return dirección del cliente del pedido
     */
    @Override
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * Obtiene la fecha del pedido.
     *
     * @return fecha del pedido.
     */
    @Override
    public Date getFecha() {
        return fecha;
    }

    /**
     * Obtiene el repartidor del pedido
     *
     * @return repartidor del pedido
     */
    @Override
    public Repartidor getRepartidor() {
        return repartidor;
    }

    /**
     * Obtiene productos del pedido.
     *
     * @return productos del pedido.
     */
    @Override
    public Map<IProducto, Integer> getProductos() {
        return productos;
    }

    /**
     * Agrega productos al pedido.
     *
     * @param producto para agregar.
     * @param cantidad para agregar.
     */
    public void addProducto(Producto producto, Integer cantidad) {
        if (productos.containsKey(producto)) {
            Integer cantidadActual = productos.get(producto);
            productos.put(producto, cantidad + cantidadActual);
        } else {
            productos.put(producto, cantidad);
        }
    }
}
