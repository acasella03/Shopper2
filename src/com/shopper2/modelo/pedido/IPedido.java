package com.shopper2.modelo.pedido;

import com.shopper2.modelo.productos.IProducto;
import com.shopper2.modelo.repartidores.Repartidor;

import java.util.Date;
import java.util.Map;

/**
 * Datos necesarios para ser implementados en un pedido:
 * Obtener el identificador del pedido.
 * Obtener el nombre del cliente del pedido.
 * Obtener la dirección del cliente del pedido.
 * Obtener la fecha del pedido.
 * Obtener el repartidor del pedido.
 * Obtener el producto que incluye el pedido.
 */

public interface IPedido {
    int getCodpe();

    String getNomCliente();

    String getDireccionCliente();

    Date getFecha();

    Repartidor getRepartidor();

    Map<IProducto, Integer> getProductos();
}
