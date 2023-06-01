/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shopper2.vista;

import com.shopper2.modelo.dao.PedidoDao;
import com.shopper2.modelo.pedido.Pedido;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * @author Angita
 */
public class ListaPedidos extends javax.swing.JFrame {

    /**
     * Creates new form ListaPedidos
     */
    public ListaPedidos() {
        initComponents();
        initTabla();
    }

    private void initTabla() {
        ArrayList<Pedido> listaPedidos = PedidoDao.getInstance().buscarTodos();
        DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();
        for (Pedido pedido1 : listaPedidos) {
            Object[] datos = new Object[5];
            datos[0] = pedido1.getCodpe();
            datos[1] = pedido1.getNomCliente();
            datos[2] = pedido1.getDireccionCliente();
            datos[3] = pedido1.getFecha();
            datos[4] = pedido1.getRepartidor().getCodr();

            //añado el modelo a la tabla
            modelo.addRow(datos);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        bVolver = new javax.swing.JButton();
        bNuevoPedido = new javax.swing.JButton();
        bEditarPedido = new javax.swing.JButton();
        bEliminarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTA DE PEDIDOS");

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PEDIDO", "CLIENTE", "DIRECCIÓN", "FECHA", "REPARTIDOR"
            }
        ));
        jScrollPane1.setViewportView(tablaPedidos);

        bVolver.setText("VOLVER");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        bNuevoPedido.setText("CREAR NUEVO PEDIDO");
        bNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoPedidoActionPerformed(evt);
            }
        });

        bEditarPedido.setText("EDITAR PEDIDO");
        bEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarPedidoActionPerformed(evt);
            }
        });

        bEliminarPedido.setText("ELIMINAR PEDIDO");
        bEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(bVolver)
                .addGap(113, 113, 113)
                .addComponent(bNuevoPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bEliminarPedido)
                .addGap(114, 114, 114)
                .addComponent(bEditarPedido)
                .addGap(52, 52, 52))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVolver)
                    .addComponent(bNuevoPedido)
                    .addComponent(bEditarPedido)
                    .addComponent(bEliminarPedido))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        //MenuPrincipal menu = new MenuPrincipal();
        //menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_bVolverActionPerformed

    private void bNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoPedidoActionPerformed
        NuevoPedido nuevoPedido = new NuevoPedido();
        nuevoPedido.setVisible(true);
        dispose();
    }//GEN-LAST:event_bNuevoPedidoActionPerformed

    private void bEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarPedidoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaPedidos.getModel();
        int filaSeleccionada = tablaPedidos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int pedidoId = (int) model.getValueAt(filaSeleccionada, 0);
            EditarPedido editarPedido = new EditarPedido(pedidoId);
            editarPedido.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_bEditarPedidoActionPerformed

    private void bEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarPedidoActionPerformed
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

    }//GEN-LAST:event_bEliminarPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEditarPedido;
    private javax.swing.JButton bEliminarPedido;
    private javax.swing.JButton bNuevoPedido;
    private javax.swing.JButton bVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    public static javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
