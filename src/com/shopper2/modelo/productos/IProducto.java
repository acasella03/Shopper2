package com.shopper2.modelo.productos;

import com.shopper2.modelo.enums.Categoria;

/**
 * Datos necesarios para ser implementados en producto:
 * Obtener el identificador del producto.
 * Obtener el nombre del producto.
 * Obtener la categoría del producto.
 */

public interface IProducto {
    int getCodpr();

    String getNombre();

    Categoria getCategoria();
}
