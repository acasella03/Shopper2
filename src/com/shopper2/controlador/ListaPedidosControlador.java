package com.shopper2.controlador;

import com.shopper2.modelo.dao.PedidoDao;
import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.vista.EditarPedido;
import com.shopper2.vista.ListaPedidos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ListaPedidosControlador {
    private ListaPedidos vista;

    public ListaPedidosControlador() {
    }

    public void abrirListaPedidos() {
        ArrayList<Pedido> listaPedidos = PedidoDao.getInstance().buscarTodos();
        vista = new ListaPedidos(this);
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaPedidos().getModel();
        for (Pedido pedido : listaPedidos) {
            Object[] datos = new Object[5];
            datos[0] = pedido.getCodpe();
            datos[1] = pedido.getNomCliente();
            datos[2] = pedido.getDireccionCliente();
            datos[3] = pedido.getFecha();
            datos[4] = pedido.getRepartidor().getCodr();

            //añado el modelo a la tabla
            modelo.addRow(datos);
        }
        vista.setVisible(true);
    }

    public void volverMenuPrincipal() {
        MenuPrincipalControlador controlador = new MenuPrincipalControlador();
        controlador.abrirMenuPrincipal();
        vista.dispose();
    }

    public void editarPedido(JTable tablaPedidos) {
        DefaultTableModel model = (DefaultTableModel) tablaPedidos.getModel();
        int filaSeleccionada = tablaPedidos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int pedidoId = (int) model.getValueAt(filaSeleccionada, 0);
            EditarPedido editarPedido = new EditarPedido(pedidoId);
            editarPedido.setVisible(true);
            vista.dispose();
        }
    }

    public void eliminarPedido(JTable tablaPedidos) {
        DefaultTableModel model = (DefaultTableModel) tablaPedidos.getModel();
        int filaSeleccionada = tablaPedidos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la columna 0 (suponiendo que sea la columna primaria)
            int pedidoId = (int) model.getValueAt(filaSeleccionada, 0);

            // Eliminar la fila seleccionada del modelo de tabla
            model.removeRow(filaSeleccionada);

            // Eliminar el producto de la base de datos utilizando el ID
            PedidoDao.getInstance().eliminar(pedidoId);
        }
    }
}
