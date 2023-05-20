package com.shopper2.modelo.pedido;

import com.shopper2.modelo.contenedores.IContenedor;
import com.shopper2.modelo.productos.IProducto;

import java.util.Set;

/**
 * Datos necesarios para ser implementados en un pedido:
 * Obtener la referencia del pedido.
 * Obtener el producto que incluye el pedido.
 * Obtener el contenedor que usa el pedido.
 * Agregar tipo de contenedor del pedido.
 * Agregar producto de acuerdo al tipo de contenedor del pedido.
 */

public interface IPedido {
    String getReferencia();
    Set<IProducto> getProductos();
    Set<IContenedor> getContenedores();
    void addContenedor(IContenedor contenedor);
    IContenedor addProducto(IProducto producto);
}
