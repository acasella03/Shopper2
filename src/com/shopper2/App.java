package com.shopper2;

import com.shopper2.controlador.MenuPrincipalControlador;

/**
 * Clase principal de la aplicación.
 */
public class App {
    /**
     * Método principal que inicia la aplicación.
     *
     * @param args argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        MenuPrincipalControlador controlador = new MenuPrincipalControlador();
        controlador.abrirMenuPrincipal();
    }
}
