package com.shopper2.controlador;

import com.shopper2.modelo.dao.PedidoDao;
import com.shopper2.modelo.dao.ProductoDao;
import com.shopper2.modelo.dao.RepartidorDao;
import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.productos.IAgregarProducto;
import com.shopper2.modelo.productos.Producto;
import com.shopper2.modelo.repartidores.Repartidor;
import com.shopper2.vista.AgregarProductos;
import com.shopper2.vista.NuevoPedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Controlador para la creación de un nuevo pedido.
 */
public class NuevoPedidoControlador implements IAgregarProducto {
    NuevoPedido vista;

    /**
     * Constructor de la clase NuevoPedidoControlador.
     */
    public NuevoPedidoControlador() {
    }

    /**
     * Abre la vista para crear un nuevo pedido.
     */
    public void abrirNuevoPedido() {
        vista = new NuevoPedido(this);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        ArrayList<Repartidor> repartidores = RepartidorDao.getInstance().obtenerRepartidores();
        for (Repartidor repartidor : repartidores) {
            model.addElement(repartidor.getCodr() + " - " + repartidor.getNomr());
        }
        vista.getBoxRepartidores().setModel(model);
        vista.setVisible(true);
    }

    /**
     * Borra un producto de la tabla de productos.
     *
     * @param tablaProductos La tabla de productos.
     */
    public void borrarProducto(JTable tablaProductos) {
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
    }

    /**
     * Guarda el pedido creado por el usuario.
     */
    public void guardarPedido() {
        //Objeto de tipo Pedido para recoger la información introducida por el usuario
        Pedido pedido = new Pedido();
        //Almacenamiento del dato nombre del cliente
        pedido.setNomCliente(vista.gettNombreCliente().getText());
        //Almacenamiento del dato dirección del cliente
        pedido.setDireccionCliente(vista.gettDireccionCliente().getText());
        //Almacenamiento del dato fecha del pedido
        pedido.setFecha(Date.valueOf(vista.gettFechaPedido().getText()));
        //Almacenamiento del dato repartidor
        String selectedItem = (String) vista.getBoxRepartidores().getSelectedItem();
        String[] parts = selectedItem.split(" - ");
        int codr = Integer.parseInt(parts[0]);
        Repartidor repartidor = RepartidorDao.getInstance().buscar(codr);
        pedido.setRepartidor(repartidor);
        //Se obtiene el modelo de la tabla asociada a la tablaProductos
        DefaultTableModel model = (DefaultTableModel) vista.getTablaProductos().getModel();
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
            ListaPedidosControlador pedidos = new ListaPedidosControlador();
            pedidos.abrirListaPedidos();
            vista.dispose();
        }
    }

    /**
     * Cancela la creación del nuevo pedido y vuelve al menú principal.
     */
    public void cancelar() {
        MenuPrincipalControlador menuPrincipal = new MenuPrincipalControlador();
        menuPrincipal.abrirMenuPrincipal();
        vista.dispose();
    }

    /**
     * Implementación del método agregarProducto de la interfaz IAgregarProducto.
     * Agrega un producto a la tabla de productos.
     *
     * @param producto El producto a agregar.
     * @param cantidad La cantidad del producto a agregar.
     */
    @Override
    public void agregarProducto(Producto producto, int cantidad) {
        if (producto != null) {
            DefaultTableModel model = (DefaultTableModel) vista.getTablaProductos().getModel();
            Object[] datos = new Object[4];
            datos[0] = producto.getCodpr();
            datos[1] = producto.getNombreProducto();
            datos[2] = producto.getCategoria();
            datos[3] = cantidad;
            model.addRow(datos);
        }
    }

    /**
     * Abre la vista para agregar productos al pedido.
     */
    public void abrirAgregarProductos() {
        AgregarProductos agregarProductos = new AgregarProductos(this);
        agregarProductos.setVisible(true);
    }
}
