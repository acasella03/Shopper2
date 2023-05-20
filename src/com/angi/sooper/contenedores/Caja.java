package com.angi.sooper.contenedores;

import com.angi.sooper.IProducto;
import com.angi.sooper.enums.TipoContenedor;

/**
 * Tipo de contenedor llamado Caja.
 */

public class Caja extends Contenedor {
    /**
     * Indica el ancho del contenedor caja.
     */
    private int ancho;
    /**
     * Indica el largo del contenedor caja.
     */
    private int largo;

    /**
     * Obtiene el tipo de contenedor caja.
     *
     * @return el tipo de contenedor caja.
     */
    @Override
    public TipoContenedor getTipo() {
        return TipoContenedor.CAJA;
    }

    /**
     * Obtiene la superficie del contenedor caja, tomando en cuenta que la forma es un rectángulo.
     *
     * @return el valor de la superficie del contenedor caja.
     */
    @Override
    public int getSuperficie() {
        return ancho * largo;
    }

    /**
     * Constructor parametrizado.
     *
     * @param referencia identificador del contenedor caja.
     * @param alto       del contenedor caja.
     * @param ancho      del contenedor caja.
     * @param largo      del contenedor caja.
     */
    public Caja(String referencia, int alto, int ancho, int largo) {
        super(referencia, alto,0);
        this.ancho = ancho;
        this.largo = largo;
    }

    /**
     * Comprueba la resistencia del contenedor ante un producto.
     *
     * @param producto a soportar por el contenedor.
     * @return si lo soporta o no.
     */
    @Override
    public boolean resiste(IProducto producto) {
        return true;
    }
}
