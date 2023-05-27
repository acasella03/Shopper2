/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shopper2.vista;

import com.shopper2.controlador.PedidoDao;
import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.repartidores.Repartidor;
import java.sql.Date;

/**
 * @author Angita
 */
public class NuevoPedido extends javax.swing.JFrame {

    /**
     * Creates new form NuevoPedido
     */
    public NuevoPedido() {
        initComponents();
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
        eCliente = new javax.swing.JLabel();
        tNombreCliente = new javax.swing.JTextField();
        eDireccionCliente = new javax.swing.JLabel();
        tDireccionCliente = new javax.swing.JTextField();
        eFechaPedido = new javax.swing.JLabel();
        tFechaPedido = new javax.swing.JTextField();
        eCodRepartidor = new javax.swing.JLabel();
        tCodRepartidor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        bAddProducto = new javax.swing.JButton();
        bDelProducto = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NUEVO PEDIDO");

        panel.setName("NUEVO PEDIDO"); // NOI18N

        eCliente.setText("NOMBRE CLIENTE");

        tNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNombreClienteActionPerformed(evt);
            }
        });

        eDireccionCliente.setText("DIRECCIÓN CLIENTE");

        tDireccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDireccionClienteActionPerformed(evt);
            }
        });

        eFechaPedido.setText("FECHA PEDIDO");

        tFechaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFechaPedidoActionPerformed(evt);
            }
        });

        eCodRepartidor.setText("ID REPARTIDOR");

        tCodRepartidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCodRepartidorActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PRODUCTO", "CATEGORIA", "CANTIDAD"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        bAddProducto.setText("AGREGAR");
        bAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddProductoActionPerformed(evt);
            }
        });

        bDelProducto.setText("BORRAR");
        bDelProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelProductoActionPerformed(evt);
            }
        });

        bGuardar.setText("GUARDAR");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bCancelar.setText("CANCELAR");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(eCodRepartidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eFechaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                        .addComponent(tDireccionCliente)
                                        .addComponent(tFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tCodRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bAddProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bDelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(bGuardar)
                        .addGap(157, 157, 157)
                        .addComponent(bCancelar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCliente))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eDireccionCliente))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eFechaPedido))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eCodRepartidor)
                    .addComponent(tCodRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(bAddProducto)
                        .addGap(92, 92, 92)
                        .addComponent(bDelProducto)))
                .addGap(34, 34, 34)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar)
                    .addComponent(bCancelar))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNombreClienteActionPerformed

    private void tDireccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDireccionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tDireccionClienteActionPerformed

    private void tFechaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFechaPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tFechaPedidoActionPerformed

    private void tCodRepartidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCodRepartidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCodRepartidorActionPerformed

    private void bAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bAddProductoActionPerformed

    private void bDelProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bDelProductoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed

        Pedido pedido = new Pedido();
        pedido.setNomCliente(tNombreCliente.getText());
        pedido.setDireccionCliente(tDireccionCliente.getText());
        pedido.setFecha(Date.valueOf(tFechaPedido.getText()));
        Repartidor repartidor = new Repartidor();
        repartidor.setCodr(Integer.parseInt(tCodRepartidor.getText()));
        pedido.setRepartidor(repartidor);

        if (PedidoDao.getInstance().crear(pedido)) {
            ListaPedidos pedidos = new ListaPedidos();
            pedidos.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddProducto;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bDelProducto;
    private javax.swing.JButton bGuardar;
    private javax.swing.JLabel eCliente;
    private javax.swing.JLabel eCodRepartidor;
    private javax.swing.JLabel eDireccionCliente;
    private javax.swing.JLabel eFechaPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tCodRepartidor;
    private javax.swing.JTextField tDireccionCliente;
    private javax.swing.JTextField tFechaPedido;
    private javax.swing.JTextField tNombreCliente;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
