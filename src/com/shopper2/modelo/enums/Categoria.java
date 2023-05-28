package com.shopper2.modelo.enums;

/**
 * Clasificación de las categorías de los productos.
 */
public enum Categoria {

    ALIMENTACION("alimentacion"), DROGUERIA("drogueria"), HIGIENE("higiene"), MASCOTAS("mascotas");

    private final String stringValue;

    private Categoria(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static Categoria fromString(String stringValue) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getStringValue().equals(stringValue)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("No Such Value");

    }
}
