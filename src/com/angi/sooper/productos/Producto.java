package com.angi.sooper.productos;

import com.angi.sooper.IContenedor;
import com.angi.sooper.IProducto;
import com.angi.sooper.enums.Categoria;

public abstract class Producto implements IProducto {
    private String referencia;
    private int peso;
    private int volumen;
    private IContenedor contenedor;

    public Producto(String referencia, int peso, int volumen) {
        this.referencia = referencia;
        this.peso = peso;
        this.volumen = volumen;
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
