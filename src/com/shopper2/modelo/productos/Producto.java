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
    private String nombreProducto;
    /**
     * Categoría de un producto.
     */
    private Categoria categoria;

    /**
     * Constructor parametrizado.
     *
     * @param codpr          código del producto.
     * @param nombreProducto del producto.
     * @param categoria      del producto.
     */
    public Producto(int codpr, String nombreProducto, Categoria categoria) {
        this.codpr = codpr;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
    }

    /**
     * Constructor parametrizado.
     *
     * @param codpr          código del producto.
     * @param nombreProducto
     */
    public Producto(int codpr, String nombreProducto) {
        this.codpr = codpr;
        this.nombreProducto = nombreProducto;
    }

    /**
     * Constructor vacio.
     */
    public Producto() {
    }

    /**
     * Asigna un identificador al producto.
     *
     * @param codpr código del producto.
     */
    public void setCodpr(int codpr) {
        this.codpr = codpr;
    }

    /**
     * Asigna un nombre al producto.
     *
     * @param nombreProducto del producto.
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Asigna una categoria al producto.
     *
     * @param categoria del producto.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return identificador del producto.
     */
    @Override
    public int getCodpr() {
        return codpr;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre del producto.
     */
    @Override
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return categoría del producto.
     */
    @Override
    public Categoria getCategoria() {
        return categoria;
    }

}
