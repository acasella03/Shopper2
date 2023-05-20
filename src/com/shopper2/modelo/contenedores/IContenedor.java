package com.shopper2.modelo.contenedores;

import com.shopper2.modelo.productos.IProducto;
import com.shopper2.modelo.enums.TipoContenedor;

import java.util.Set;

/**
 * Datos necesarios para ser implementados en un contenedor:
 * Obtener la referencia del contenedor.
 * Obtener el volumen del contenedor.
 * Obtener el volumen restante del contenedor, teniendo en cuenta los productos que contiene.
 * Obtener la resistencia del contenedor.
 * Obtener los productos existentes en un contenedor.
 * Obtener el tipo de contenedor.
 * Comprobar si un producto cabe o no en el contenedor y lo agrega o no.
 * Comprobar la resistencia del contenedor ante un producto.
 * Obtener la superficie del contenedor.
 */

public interface IContenedor {
    String getReferencia();
    int getVolumen();
    int volumenDisponible();
    int getResistencia();
    Set<IProducto> getProductos();
    TipoContenedor getTipo();
    boolean meter(IProducto producto);
    boolean resiste(IProducto producto);
    int getSuperficie();
}
