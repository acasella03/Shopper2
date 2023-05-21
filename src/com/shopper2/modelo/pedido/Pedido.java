package com.shopper2.modelo.pedido;

import com.shopper2.modelo.productos.IProducto;
import com.shopper2.modelo.productos.Producto;
import com.shopper2.modelo.repartidores.Repartidor;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    private Repartidor repartidor;
    /**
     * Lista del productos del pedido.
     */
    private Map<IProducto, Integer> productos;

    /**
     * Constructor parametrizado con ID del pedido.
     *
     * @param codpe            identificador del pedido.
     * @param nomCliente       nombre del cliente del pedido.
     * @param direccionCliente del pedido.
     * @param fecha            del pedido
     * @param productos        contenidos en el pedido.
     */
    public Pedido(int codpe, String nomCliente, String direccionCliente, Date fecha, Map<IProducto, Integer> productos) {
        this.codpe = codpe;
        this.nomCliente = nomCliente;
        this.direccionCliente = direccionCliente;
        this.fecha = fecha;
        this.productos = productos;
    }

    /**
     * Constructor parametrizado sin ID del pedido.
     *
     * @param nomCliente       nombre del cliente del pedido.
     * @param direccionCliente del pedido.
     * @param fecha            del pedido
     * @param productos        contenidos en el pedido.
     */
    public Pedido(String nomCliente, String direccionCliente, Date fecha, Repartidor repartidor, Map<IProducto, Integer> productos) {
        this.nomCliente = nomCliente;
        this.direccionCliente = direccionCliente;
        this.fecha = fecha;
        this.repartidor = repartidor;
        this.productos = productos;
    }

    /**
     * Obtiene el identificador del pedido.
     *
     * @return identificador del pedido.
     */
    public int getCodpe() {
        return codpe;
    }

    /**
     * Obtener el nombre del cliente del pedido.
     *
     * @return nombre del cliente del pedido.
     */
    @Override
    public String getNomCliente() {
        return nomCliente;
    }

    /**
     * Obtener la dirección del cliente del pedido.
     *
     * @return dirección del cliente del pedido
     */
    @Override
    public String getDireccionCliente() {
        return direccionCliente;
    }

    /**
     * Obtener la fecha del pedido.
     *
     * @return fecha del pedido.
     */
    public Date getFecha() {
        return fecha;
    }

    @Override
    public Repartidor getRepartidor() {
        return repartidor;
    }

    /**
     * Obtiene el producto del pedido.
     *
     * @return producto del pedido.
     */
    @Override
    public Map<IProducto, Integer> getProductos() {
        return productos;
    }

    /**
     * Agregar producto al pedido.
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
