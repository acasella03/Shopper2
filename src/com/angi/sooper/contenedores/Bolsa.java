package com.angi.sooper.contenedores;

import com.angi.sooper.enums.TipoContenedor;

/**
 * Tipo de contenedor llamado Bolsa.
 */
public class Bolsa extends Contenedor {
    /**
     * Indica el ancho del contenedor Bolsa.
     */
    private int ancho;

    /**
     * Constructor parametrizado.
     *
     * @param referencia identificador del contenedor Bolsa.
     * @param alto       del contenedor Bolsa.
     * @param ancho      del contenedor Bolsa.
     */
    public Bolsa(String referencia, int alto, int ancho, int resistencia) {
        super(referencia, alto, resistencia);
        this.ancho = ancho;
    }

    /**
     * Obtiene el tipo de contenedor bolsa.
     *
     * @return el tipo de contenedor bolsa.
     */
    @Override
    public TipoContenedor getTipo() {
        return TipoContenedor.BOLSA;
    }

    /**
     * Obtiene la superficie del contenedor bolsa, tomando en cuenta que la bolsa toma la forma de cilindro cuando se llena.
     *
     * @return el valor de la superficie del contenedor bolsa.
     */
    @Override
    public int getSuperficie() {
        int radio = getDiametro() / 2;
        return (int) (Math.PI * radio * radio);
    }

    /**
     * Para calcular el diámetro del contenedor bolsa, tomando en cuenta la forma cilídrica.
     *
     * @return valor del diámetro del contenedor bolsa.
     */
    private int getDiametro() {

        return (int) ((2 * ancho) / Math.PI);
    }
}
