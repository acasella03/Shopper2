package com.shopper2.controlador;

import com.shopper2.vista.MenuPrincipal;

/**
 * Controlador para el menú principal.
 */
public class MenuPrincipalControlador {
    /**
     * Constructor de la clase MenuPrincipalControlador.
     */
    public MenuPrincipalControlador() {
    }

    /**
     * Abre la vista del menú principal.
     */
    public void abrirMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal(this);
        menu.setVisible(true);
    }

    /**
     * Abre la vista de creación de un nuevo pedido.
     */
    public void abrirNuevoPedido() {
        NuevoPedidoControlador nuevoPedido = new NuevoPedidoControlador();
        nuevoPedido.abrirNuevoPedido();
    }

    /**
     * Abre la vista de la lista de pedidos.
     */
    public void abrirListaPedidos() {
        ListaPedidosControlador pedidos = new ListaPedidosControlador();
        pedidos.abrirListaPedidos();
    }
}
