/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shopper2.vista;

import com.angi.datos.PedirDatos;
import com.shopper2.controlador.PedidoDao;
import com.shopper2.controlador.ProductoDao;
import com.shopper2.controlador.RepartidorDao;
import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.productos.Producto;
import com.shopper2.modelo.repartidores.Repartidor;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

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
        eDireccionCliente = new javax.swing.JLabel();
        eFechaPedido = new javax.swing.JLabel();
        eCodRepartidor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        bAddProducto = new javax.swing.JButton();
        bDelProducto = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        tNombreCliente = new javax.swing.JTextField();
        tDireccionCliente = new javax.swing.JTextField();
        tFechaPedido = new javax.swing.JTextField();
        tCodRepartidor = new javax.swing.JTextField();
        boxRepartidores = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NUEVO PEDIDO");

        panel.setName("NUEVO PEDIDO"); // NOI18N

        eCliente.setText("NOMBRE CLIENTE");

        eDireccionCliente.setText("DIRECCIÓN CLIENTE");

        eFechaPedido.setText("FECHA PEDIDO");

        eCodRepartidor.setText("ID REPARTIDOR");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "CATEGORIA", "CANTIDAD"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        bAddProducto.setText("AGREGAR PRODUCTO");
        bAddProducto.setToolTipText("");
        bAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddProductoActionPerformed(evt);
            }
        });

        bDelProducto.setText("BORRAR PRODUCTO");
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

        tFechaPedido.setText("AAAA-MM-DD");
        tFechaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tFechaPedidoMouseClicked(evt);
            }
        });

        boxRepartidores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-manuel", "2-ricardo", "3-sara" }));
        boxRepartidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxRepartidoresActionPerformed(evt);
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
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(eCodRepartidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eFechaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(eDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNombreCliente)
                                    .addComponent(tDireccionCliente)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(tCodRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(74, 74, 74)
                                                .addComponent(boxRepartidores, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bAddProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bDelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(bGuardar)
                        .addGap(157, 157, 157)
                        .addComponent(bCancelar)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eCliente)
                    .addComponent(tNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eDireccionCliente)
                    .addComponent(tDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eFechaPedido)
                    .addComponent(tFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eCodRepartidor)
                        .addComponent(tCodRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boxRepartidores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void bAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddProductoActionPerformed
        int codpr = PedirDatos.pedirEntero("Introduce el ID del producto:");
        int cantidad = PedirDatos.pedirEntero("Indica las unidades del producto:");
        Producto producto = ProductoDao.getInstance().buscar(codpr);
        if (producto != null) {
            DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
            Object[] datos = new Object[4];
            datos[0] = producto.getCodpr();
            datos[1] = producto.getNombreProducto();
            datos[2] = producto.getCategoria();
            datos[3] = cantidad;
            model.addRow(datos);
        }
    }//GEN-LAST:event_bAddProductoActionPerformed

    private void bDelProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelProductoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        int filaSeleccionada = tablaProductos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la columna 0 (suponiendo que sea la columna primaria)
            int productoId = (int) model.getValueAt(filaSeleccionada, 0);

            // Eliminar la fila seleccionada del modelo de tabla
            model.removeRow(filaSeleccionada);

            // Eliminar el producto de la base de datos utilizando el ID
            ProductoDao.getInstance().eliminar(productoId);
        }
    }//GEN-LAST:event_bDelProductoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        //Objeto de tipo Pedido para recoger la información introducida por el usuario
        Pedido pedido = new Pedido();
        //Almacenamiento del dato nombre del cliente
        pedido.setNomCliente(tNombreCliente.getText());
        //Almacenamiento del dato dirección del cliente
        pedido.setDireccionCliente(tDireccionCliente.getText());
        //Almacenamiento del dato fecha del pedido
        pedido.setFecha(Date.valueOf(tFechaPedido.getText()));
        //Almacenamiento del dato repartidor
        String selectedItem = (String) boxRepartidores.getSelectedItem();
        String[] parts = selectedItem.split(" - ");
        int codr = Integer.parseInt(parts[0]);
        Repartidor repartidor = RepartidorDao.getInstance().buscar(codr);
        pedido.setRepartidor(repartidor);
        /*Repartidor repartidor = new Repartidor();
        repartidor.setCodr(Integer.parseInt(tCodRepartidor.getText()));
        pedido.setRepartidor(repartidor);*/
        //Se obtiene el modelo de la tabla asociada a la tablaProductos
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        //Se obtiene la cantidad de filas que tiene la tabla
        int cantidadDeFilas = model.getRowCount();
        //Se inicia el bucle que recorre cada fila de la tablaProductos
        for (int fila = 0; fila < cantidadDeFilas; fila++) {
            //Se extrae el valor de la columna 0 de cada fila y se guarda en la variable codpr
            int codpr = (Integer) (model.getValueAt(fila, 0));
            //Se extrae el valor de la columna 3 de cada fila y se guarda en la variable cantidad
            int cantidad = (Integer) (model.getValueAt(fila, 3));
            //se crea un nuevo objeto Producto y se establece su código (codpr). 
            //Finalmente, se agrega el producto y la cantidad al objeto Pedido 
            //utilizando el método addProducto().
            Producto producto = new Producto();
            producto.setCodpr(codpr);
            pedido.addProducto(producto, cantidad);
        }
        //Finalmente, se llama al método crear() del PedidoDao para intentar crear el pedido en la base de datos. 
        //Si el pedido se crea con éxito (la llamada al método retorna true), se crea una instancia de ListaPedidos
        //y se muestra en pantalla. Luego, se cierra la ventana actual (dispose()).
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

    private void tFechaPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tFechaPedidoMouseClicked
        tFechaPedido.setText(null);
    }//GEN-LAST:event_tFechaPedidoMouseClicked

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        tablaProductos.getSelectedRow();
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void boxRepartidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxRepartidoresActionPerformed
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        ArrayList<Repartidor> repartidores = RepartidorDao.getInstance().obtenerRepartidores();
        for (Repartidor repartidor : repartidores) {
            model.addElement(repartidor.getCodr() + " - " + repartidor.getNomr());
        }
        boxRepartidores.setModel(model);

        // Obtener el índice de la opción seleccionada actualmente (si lo deseas)
        int selectedIndex = boxRepartidores.getSelectedIndex();

        // Asegurarse de que haya elementos en el JComboBox
        if (selectedIndex >= 0 && selectedIndex < boxRepartidores.getItemCount()) {
            // Establecer la opción seleccionada para que quede visible
            boxRepartidores.setSelectedIndex(selectedIndex);
        }
    }//GEN-LAST:event_boxRepartidoresActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddProducto;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bDelProducto;
    private javax.swing.JButton bGuardar;
    private javax.swing.JComboBox<String> boxRepartidores;
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
