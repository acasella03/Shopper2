package com.shopper2.controlador;

import com.shopper2.vista.MenuPrincipal;

public class MenuPrincipalControlador {

    public MenuPrincipalControlador() {
    }

    public void abrirMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal(this);
        menu.setVisible(true);
    }

    public void abrirNuevoPedido() {
        NuevoPedidoControlador nuevoPedido = new NuevoPedidoControlador();
        nuevoPedido.abrirNuevoPedido();
    }

    public void abrirListaPedidos() {
        ListaPedidosControlador pedidos = new ListaPedidosControlador();
        pedidos.abrirListaPedidos();
    }
}
