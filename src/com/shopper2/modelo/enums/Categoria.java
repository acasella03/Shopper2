package com.shopper2.modelo.enums;

/**
 * Clasificación de las categorías de los productos.
 */
public enum Categoria {

    ALIMENTACION("alimentacion"), DROGUERIA("drogueria"), 
    HIGIENE("higiene"), MASCOTAS("mascotas");

    private final String stringValue;

    /**
     * Constructor de la enumeración Categoria.
     *
     * @param stringValue el valor de la categoría como cadena de texto.
     */
    private Categoria(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * Obtiene el valor de la categoría como cadena de texto.
     *
     * @return el valor de la categoría.
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * Convierte una cadena de texto en una instancia de Categoria.
     *
     * @param stringValue la cadena de texto a convertir.
     * @return la instancia de Categoria correspondiente a la cadena de texto.
     * @throws IllegalArgumentException si no se encuentra ninguna categoría con
     * el valor especificado.
     */
    public static Categoria fromString(String stringValue) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getStringValue().equals(stringValue)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("No Such Value");

    }
}
