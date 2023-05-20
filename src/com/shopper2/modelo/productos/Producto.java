package com.shopper2.modelo.productos;

import com.shopper2.modelo.contenedores.IContenedor;
import com.shopper2.modelo.enums.Categoria;

public class Producto implements IProducto {
    private String referencia;
    private int peso;
    private int volumen;
    private IContenedor contenedor;
    private Categoria categoria;

    public Producto(String referencia, int peso, int volumen, Categoria categoria) {
        this.referencia = referencia;
        this.peso = peso;
        this.volumen = volumen;
        this.categoria=categoria;
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public int getPeso() {
        return peso;
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean tengoEspacio(IContenedor contenedor) {
        return contenedor.volumenDisponible() > volumen;
    }

    @Override
    public void meter(IContenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public String toString() {
        return "Producto [categoría=" + getCategoria() + ", referencia=" + referencia + ", peso=" + peso + ", volumen=" + volumen + ", contenedor="
                + contenedor.getReferencia() + "]";
    }
}
