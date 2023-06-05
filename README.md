![shopper.png](shopper.png)
# Descripción de la aplicación
El proyecto **Shopper** consiste en el desarrollo de una aplicación de **gestión de pedidos** para una ***tienda online***,
que permitirá a los usuarios realizar y administrar pedidos de manera eficiente.<br>
La aplicación también llevará un registro detallado de los **productos disponibles**, así como de los **repartidores**
asociados a cada pedido, brindando así un control completo sobre todo el proceso de entrega.<br>
Con **Shopper**, los clientes podrán disfrutar de una experiencia de compra cómoda y fluida, mientras que los ***administradores 
de la tienda*** podrán gestionar de manera eficaz todos los aspectos relacionados con los pedidos y la logística.

## DIAGRAMA DE CLASES

```mermaid
classDiagram

    class Modelo {
    } 

    class PedidoDao {
    -PedidoDao: instance
    +Connection: conexion
    +getInstance()PedidoDao
    +connect()
    +close()
    +buscar(int)Pedido
    +buscarTodos()ArrayList
    +crear(Pedido)boolean
    +modificar(Pedido)boolean
    +eliminar(int)boolean
    }

    class ProductoDao {
    -ProductoDao: instance
    +Connection: conexion
    +getInstance()ProductoDao
    +connect()
    +close()
    +buscar(int)Producto
    +listaProductos()ArrayList
    +eliminar(int)boolean
    +obtenerProductos()ArrayList
    }

    class RepartidorDao {
    -RepartidorDao: instance
    +Connection: conexion
    +getInstance()RepartidorDao
    +connect()
    +close()
    +buscar(int)Repartidor
    +obtenerRepartidores()ArrayList        
    }

    class Categoria {
    <<enumeration>>
    ALIMENTACION
    DROGUERIA
    HIGIENE
    MASCOTAS
    -String: stringValue
    +getStringValue()String
    +fromString(String)Categoria
    }

    class IPedido {
    +getCodpe()int
    +getNomCliente()String
    +getDireccionCliente()String
    +getFecha()Date
    +getRepartidor()Repartidor
    +getProducto()Map   
    }

    class Pedido {
        <<implementa>>
        IPedido
     -int: codpe
     -String: nomCliente
     -String: direccionCliente
     -Date: data
     -Repartidor: repartidor
     -Map: productos
     +setCodpe(int)
     +setNomCliente(String)
     +setFecha(Date)
     +setRepartidor(Repartidor)
     +getCodpe()int
     +getNomCliente()String
     +getFecha()Date
     +getRepartidor()Repartidor
     +getProductos()Map
     +addProducto(Producto, Integer)
    }
    class IAgregarProducto {
      +agregarProducto(Producto, int)
    }    

    class IProducto {
    -getCodpr()int
    -getNombreProducto()String
    -getCategoria()Categoria
    }

    class Producto {
        <<implementa>>
        IProducto
     -int:codpr
     -String: nombreProducto
     -Categoria: categoria   
     +setCodpr(int)
     +setNombreProducto(String)
     +setCategoria(Categoria)
 
    }

    class IRepartidor {
    +getCodr()int
    +getNomr()String
    }

    class Repartidor {
        <<implementa>>
        IRepartidor
     -int: codr
     -String: nomr
     +setCodr(int)
     +setNombr(String)
    }
     class Vista  {
     Class AgregarProdutos
     Class ListaPedidos
     Class MenuPrincipal
    }   
 
    class EditarPedido {
     -initComponents()
    }

    class NuevoPedido {
   -initComponents()
    }
      class Controlador {
    }
    
    class EditarPedidoControlador{
    -EditarPedido: vista
    -int: codpe
    +abrirEditarPedido()
    +initRepartidores()
    +initPedido()
    +agregarProducto(Producto, int)
    +borrarProducto(JTable)
    +abrirAgregarProductos()
    +abrirListaPedidos()
    +modificarPedido()     
    }
    class ListaPedidosControlador{
    -ListaPedidos: vista
    +abrirListaPedidos()
    +volverMenuPrincipal()
    +editarPedido(JTable)
    +eliminarPedido(JTable)
    +abrirNuevoPedido()
    }
    class MenuPrincipalControlador{
    +abrirMenuPrincipal()
    +abrirNuevoPedido()
    +abrirListaPedidos()
    }
    class NuevoPedidoControlador{
    -NuevoPedido: vista
    +abrirNuevoPedido()
    +borrarProducto(JTable)
    +guardarPedido()
    +cancelar()
    +agregarProducto(Producto, int)
    +abrirAgregarProductos()
    }
    
    Controlador o-- EditarPedidoControlador
    Controlador o-- ListaPedidosControlador
    Controlador o-- MenuPrincipalControlador
    Controlador o-- NuevoPedidoControlador
    
    Producto o-- Categoria
    
    Modelo o-- Producto
    Modelo o-- Pedido    
    Modelo o-- Repartidor

    Modelo o-- PedidoDao
    Modelo o-- ProductoDao
    Modelo o-- RepartidorDao

    Modelo <|-- Controlador
    Vista <|-- Controlador

   
    Vista o-- EditarPedido    
    Vista o-- NuevoPedido
     IAgregarProducto <.. EditarPedido
    IAgregarProducto <.. NuevoPedido
    
    IRepartidor <.. Repartidor
    IPedido <.. Pedido
    IProducto <.. Producto
```
## DIAGRAMA DE CLASES SIMPLIFICADO
![DiagramaClasesSimplificado](DiagramaClasesShopper2.png)

## ENTIDAD RELACIÓN DE LA BASE DE DATOS
```mermaid
classDiagram
direction BT
class pedidos {
   text nomCliente
   text direccion
   date fecha
   integer codr
   integer codpe
}
class productos {
   text nompr
   text categoria
   integer codpr
}
class repartidores {
   text nomr
   integer codr
}
class tienen {
   integer cantidad
   integer codpe
   integer codpr
}

pedidos  -->  repartidores : codr
tienen  -->  pedidos : codpe
tienen  -->  productos : codpr
```

## PATRON MVC (MODELO-VISTA-CONTROLADOR)
![PatronMVC](Shopper2DiagramaFuncionamientoMVC.drawio.png)

## DIAGRAMA DE SECUENCIA
Dado que el proyecto implica el desarrollo de una aplicación de **gestión de pedidos**, 
es apropiado representar el **diagrama de secuencias** que describe la interacción de la aplicación en general.<br> 
Para lograr esto, se aplica el **Patrón de Diseño MVC (Modelo-Vista-Controlador)**, 
que ayuda a organizar y separar las responsabilidades de la aplicación de manera eficiente.
```mermaid
sequenceDiagram
    participant Usuario
    participant Vista
    participant Controlador
    participant Modelo

    Usuario ->> Vista: Crea un pedido
    Vista ->> Controlador: Crea un pedido
    Controlador ->> Modelo: Procesa la creación del pedido
    Modelo ->> Modelo: Dale valores al pedido
    Modelo -->> Controlador: Datos del pedido creado
    Controlador ->> Vista: Actualizar vista
    Vista ->> Usuario: Mostrar resultados
```
## DIAGRAMA DE SECUENCIA DEL METODO GUARDAR PEDIDO
```ruby
public void guardarPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomCliente(vista.gettNombreCliente().getText());
        pedido.setDireccionCliente(vista.gettDireccionCliente().getText());
        pedido.setFecha(Date.valueOf(vista.gettFechaPedido().getText()));
        String selectedItem = (String) vista.getBoxRepartidores().getSelectedItem();
        String[] parts = selectedItem.split(" - ");
        int codr = Integer.parseInt(parts[0]);
        Repartidor repartidor = RepartidorDao.getInstance().buscar(codr);
        pedido.setRepartidor(repartidor);
        DefaultTableModel model = (DefaultTableModel) vista.getTablaProductos().getModel();
        int cantidadDeFilas = model.getRowCount();
        for (int fila = 0; fila < cantidadDeFilas; fila++) {
            int codpr = (Integer) (model.getValueAt(fila, 0));
            int cantidad = (Integer) (model.getValueAt(fila, 3));
            Producto producto = new Producto();
            producto.setCodpr(codpr);
            pedido.addProducto(producto, cantidad);
        }
        if (PedidoDao.getInstance().crear(pedido)) {
            ListaPedidosControlador pedidos = new ListaPedidosControlador();
            pedidos.abrirListaPedidos();
            vista.dispose();
        }
    }
```
En este flujo de eventos representado en el diagrama, el **usuario** (U) realiza una solicitud al **controlador** (C) para guardar un pedido. 
El controlador se encarga de recopilar los datos ingresados en el formulario desde la **vista** (V) y crea una instancia del **Modelo de Pedido** (M). 
A continuación, el controlador recorre las filas de la tabla de productos, creando instancias de **Producto** en el modelo en base a los datos proporcionados.

Una vez completada la recopilación de información, el controlador intenta crear el pedido en la **base de datos** utilizando el modelo. 
Si el proceso de creación es exitoso, se crea una instancia de **ListaPedidos** y se muestra en la vista, brindando al usuario una visualización actualizada 
de los pedidos. Sin embargo, si la creación del pedido no tiene éxito, se muestra un mensaje de error en la vista para informar al usuario sobre el problema encontrado.

Este flujo de acciones ilustra cómo el controlador actúa como intermediario entre el usuario, la vista y el modelo, garantizando la coordinación adecuada 
entre ellos en el contexto del patrón de diseño **MVC (Modelo-Vista-Controlador)**.
```mermaid
sequenceDiagram
    participant Usuario
    participant Vista
    participant Controlador
    participant Modelo

    Usuario ->> Controlador: Solicitar guardar pedido
    Controlador ->> Vista: Obtener datos del formulario
    Vista ->> Controlador: Enviar datos del formulario
    Controlador ->> Modelo: Crear instancia de Pedido
    Modelo ->> Modelo: Almacenar información del pedido
    Modelo -->> Controlador: Devolver resultado de creación
    Controlador -->> Vista: Recibir resultado de creación
    Vista ->> Controlador: Obtener modelo de la tabla de productos
    Controlador ->> Vista: Obtener cantidad de filas
    loop Recorrer filas de la tablaProductos
        Controlador ->> Vista: Obtener valores de cada fila
        Controlador ->> Modelo: Crear instancia de Producto
        Modelo ->> Modelo: Almacenar información del producto
        Modelo ->> Modelo: Agregar producto al pedido
    end
    Controlador ->> Modelo: Intentar crear el pedido en la base de datos
    Modelo -->> Controlador: Devolver resultado de creación del pedido
    alt Pedido creado exitosamente
        Controlador ->> Vista: Crear instancia de ListaPedidos
        Vista ->> Controlador: Mostrar lista de pedidos
        Vista ->> Controlador: Cerrar ventana actual
    else Pedido no creado
        Vista ->> Controlador: Mostrar mensaje de error
    end
```
## MENÚ PRINCIPAL
![MenúPrincipal](MenuPrincipal.png)

## NUEVO PEDIDO
![NuevoPedido](NuevoPedido.png)

## AGREGAR PRODUCTOS
![AgregarProductos](AgregarProductos.png)
![AgregarProductos1](AgregarProductos1.png)

## LISTA DE PEDIDOS
![ListaPedidos](ListaPedidos.png)

## EDITAR PEDIDO
![EditarPedido](EditarPedido.png)

