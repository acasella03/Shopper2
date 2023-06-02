package com.shopper2.modelo.repartidores;

/**
 * Describe los datos necesarios de un repartidor.
 */
public class Repartidor implements IRepartidor {

    /**
     * Identificador de un repartidor.
     */
    private int codr;
    /**
     * Nombre de un repartidor.
     */
    private String nomr;

    /**
     * Constructor parametrizado.
     *
     * @param codr identificador del repartidor.
     * @param nomr nombre del repartidor.
     */
    public Repartidor(int codr, String nomr) {
        this.codr = codr;
        this.nomr = nomr;
    }

    /**
     * Constructor vacío.
     */
    public Repartidor() {

    }

    /**
     * Asigna un identificador al repartidor.
     *
     * @param codr codigo del repartidor.
     */
    public void setCodr(int codr) {
        this.codr = codr;
    }

    /**
     * Asigna un nombre al repartidor.
     *
     * @param nomr nombre del repartidor.
     */
    public void setNomr(String nomr) {
        this.nomr = nomr;
    }

    /**
     * Obtiene el identificador del repartidor.
     *
     * @return identificador del repartidor.
     */
    @Override
    public int getCodr() {
        return codr;
    }

    /**
     * Obtiene el nombre del repartidor.
     *
     * @return nombre del repartidor.
     */
    @Override
    public String getNomr() {
        return nomr;
    }
}
