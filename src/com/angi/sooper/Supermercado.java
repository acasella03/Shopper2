package com.angi.sooper;

import com.angi.sooper.contenedores.Bolsa;
import com.angi.sooper.contenedores.Caja;
import com.angi.sooper.productos.Congelado;
import com.angi.sooper.productos.Fresco;
import com.angi.sooper.productos.Higiene;

public class Supermercado {
    public static void main(String[] args) {
        IPedido miPedido = new Pedido("pedido001");

        IContenedor bolsa1 = new Bolsa("B111", 40, 25,900);
        IContenedor caja1 = new Caja("C222", 30, 50, 75);
        miPedido.addContenedor(bolsa1);
        miPedido.addContenedor(caja1);
        System.out.println("Bolsa: "+bolsa1);
        System.out.println("Caja: "+caja1);
        System.out.println("Mi pedido con contenedores: "+miPedido);

        IProducto manzanas = new Fresco("MNZ", 1000, 1500);
        IProducto helado = new Congelado("HLD", 800, 1000);
        IProducto papelWC = new Higiene("PWC", 500, 2500);
        IProducto peras = new Fresco("PER", 800, 1200);

        IContenedor contManzanas = miPedido.addProducto(manzanas);
        IContenedor contHelado = miPedido.addProducto(helado);
        IContenedor contPapel = miPedido.addProducto(papelWC);
        IContenedor contPeras = miPedido.addProducto(peras);
        System.out.println("Mi pedido con productos: "+miPedido);

    }
}