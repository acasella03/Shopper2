package com.shopper2.controlador;

import com.shopper2.vista.ListaPedidos;
import com.shopper2.vista.MenuPrincipal;
import com.shopper2.vista.NuevoPedido;

public class MenuPrincipalControlador {

    public MenuPrincipalControlador() {
    }

    public void abrirMenuPrincipal() {
        MenuPrincipal menu = new MenuPrincipal(this);
        menu.setVisible(true);
    }

    public void abrirNuevoPedido() {
        NuevoPedido nuevoPedido = new NuevoPedido();
        nuevoPedido.setVisible(true);
    }

    public void abrirListaPedidos() {
        ListaPedidosControlador pedidos = new ListaPedidosControlador();
        pedidos.abrirListaPedidos();
    }
}
