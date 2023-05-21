package com.shopper2.modelo.productos;

import com.shopper2.modelo.enums.Categoria;

/**
 * Describe los datos necesarios de un producto.
 */
public class Producto implements IProducto {
    /**
     * Identificador de un producto.
     */
    private int codpr;
    /**
     * Nombre de un producto.
     */
    private String nombre;
    /**
     * Categoría de un producto.
     */
    private Categoria categoria;

    /**
     * Constructor parametrizado.
     *
     * @param codpr     código del producto.
     * @param nombre    del producto.
     * @param categoria del producto.
     */
    public Producto(int codpr, String nombre, Categoria categoria) {
        this.codpr = codpr;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    /**
     * Obtener el identificador del producto.
     *
     * @return identificador del producto.
     */
    @Override
    public int getCodpr() {
        return codpr;
    }

    /**
     * Obtener el nombre del producto.
     *
     * @return nombre del producto.
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtener la categoría del producto.
     *
     * @return categoría del producto.
     */
    @Override
    public Categoria getCategoria() {
        return categoria;
    }

}
