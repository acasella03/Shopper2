package com.angi.sooper.productos;

import com.angi.sooper.IProducto;
import com.angi.sooper.enums.Categoria;
import com.angi.sooper.productos.Producto;

public class Alimentacion extends Producto {

    public Alimentacion(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.ALIMENTACION;
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return Categoria.ALIMENTACION.equals(p.getCategoria());
    }
}
