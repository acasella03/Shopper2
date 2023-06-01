package com.shopper2.controlador;

import com.shopper2.modelo.dao.PedidoDao;
import com.shopper2.modelo.dao.ProductoDao;
import com.shopper2.modelo.dao.RepartidorDao;
import com.shopper2.modelo.pedido.Pedido;
import com.shopper2.modelo.productos.IAgregarProducto;
import com.shopper2.modelo.productos.IProducto;
import com.shopper2.modelo.productos.Producto;
import com.shopper2.modelo.repartidores.Repartidor;
import com.shopper2.vista.AgregarProductos;
import com.shopper2.vista.EditarPedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

/**
 * Controlador para la edición de pedidos que implementa la interfaz IAgregarProducto.
 */
public class EditarPedidoControlador implements IAgregarProducto {
    EditarPedido vista;
    private final int codpe;

    /**
     * Constructor de la clase EditarPedidoControlador.
     *
     * @param codpe El código del pedido a editar.
     */
    public EditarPedidoControlador(int codpe) {
        this.codpe = codpe;
    }

    /**
     * Abre la vista de edición de pedido.
     */
    public void abrirEditarPedido() {
        vista = new EditarPedido(this);
        initRepartidores();
        initPedido();
        vista.setVisible(true);
    }

    /**
     * Inicializa el ComboBox de repartidores con los datos obtenidos de la base de datos.
     */
    private void initRepartidores() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        ArrayList<Repartidor> repartidores = RepartidorDao.getInstance().obtenerRepartidores();
        for (Repartidor repartidor : repartidores) {
            model.addElement(repartidor.getCodr() + " - " + repartidor.getNomr());
        }
        vista.getBoxRepartidores().setModel(model);
    }

    /**
     * Inicializa los datos del pedido en la vista de edición.
     */
    public void initPedido() {
        Pedido pedido = PedidoDao.getInstance().buscar(codpe);
        vista.gettNombreCliente().setText(pedido.getNomCliente());
        vista.gettDireccionCliente().setText(pedido.getDireccionCliente());
        vista.gettFechaPedido().setText(String.valueOf(pedido.getFecha()));
        int elementosBox = vista.getBoxRepartidores().getItemCount();
        for (int i = 0; i < elementosBox; i++) {
            String elemento = vista.getBoxRepartidores().getItemAt(i);
            String[] parts = elemento.split(" - ");
            int codr = Integer.parseInt(parts[0]);
            if (codr == pedido.getRepartidor().getCodr()) {
                vista.getBoxRepartidores().setSelectedIndex(i);
                break;
            }
        }

        for (Map.Entry<IProducto, Integer> entrada : pedido.getProductos().entrySet()) {
            DefaultTableModel model = (DefaultTableModel) vista.getTablaProductos().getModel();
            Object[] datos = new Object[4];
            datos[0] = entrada.getKey().getCodpr();
            datos[1] = entrada.getKey().getNombreProducto();
            datos[2] = entrada.getKey().getCategoria();
            datos[3] = entrada.getValue();
            model.addRow(datos);
        }
    }

    /**
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
     * Borra un producto de la tabla de productos y también de la base de datos.
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
     * Abre la vista de agregar productos.
     */
    public void abrirAgregarProductos() {
        AgregarProductos agregarProductos = new AgregarProductos(this);
        agregarProductos.setVisible(true);
    }

    /**
     * Abre la lista de pedidos y cierra la vista de edición.
     */
    public void abrirListaPedidos() {
        ListaPedidosControlador listaPedidos = new ListaPedidosControlador();
        listaPedidos.abrirListaPedidos();
        vista.dispose();
    }

    /**
     * Modifica el pedido con los datos ingresados por el usuario.
     */
    public void modificarPedido() {
        //Objeto de tipo Pedido para recoger la información introducida por el usuario
        Pedido pedido = new Pedido();
        pedido.setCodpe(codpe);
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


        if (PedidoDao.getInstance().modificar(pedido)) {
            abrirListaPedidos();
        }
    }
}
