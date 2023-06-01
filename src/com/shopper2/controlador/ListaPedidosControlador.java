package com.shopper2.controlador;

import com.shopper2.modelo.dao.PedidoDao;
import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.vista.ListaPedidos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Controlador para la lista de pedidos.
 */
public class ListaPedidosControlador {
    private ListaPedidos vista;

    /**
     * Constructor de la clase ListaPedidosControlador.
     */
    public ListaPedidosControlador() {
    }

    /**
     * Abre la vista de la lista de pedidos.
     */
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

    /**
     * Vuelve al menú principal y cierra la vista de la lista de pedidos.
     */
    public void volverMenuPrincipal() {
        MenuPrincipalControlador controlador = new MenuPrincipalControlador();
        controlador.abrirMenuPrincipal();
        vista.dispose();
    }

    /**
     * Abre la vista de edición de un pedido seleccionado en la tabla de pedidos.
     *
     * @param tablaPedidos La tabla de pedidos.
     */
    public void editarPedido(JTable tablaPedidos) {
        DefaultTableModel model = (DefaultTableModel) tablaPedidos.getModel();
        int filaSeleccionada = tablaPedidos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int pedidoId = (int) model.getValueAt(filaSeleccionada, 0);
            EditarPedidoControlador editarPedido = new EditarPedidoControlador(pedidoId);
            editarPedido.abrirEditarPedido();
            vista.dispose();
        }
    }

    /**
     * Elimina un pedido seleccionado de la tabla de pedidos y de la base de datos.
     *
     * @param tablaPedidos La tabla de pedidos.
     */
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

    /**
     * Abre la vista de creación de un nuevo pedido y cierra la vista de la lista de pedidos.
     */
    public void abrirNuevoPedido() {
        NuevoPedidoControlador nuevoPedido = new NuevoPedidoControlador();
        nuevoPedido.abrirNuevoPedido();
        vista.dispose();
    }
}
