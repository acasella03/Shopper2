## DIAGRAMA DE CLASES

```mermaid
classDiagram
    class IPedido{
    +getCodpe()int
    +getNomCliente()String
    +getDireccionCliente()String
    +getFecha()Date
    +getRepartidor()Repartidor
    +getProductos()Map
    }
    class IProducto{
    +getCodpr()int
    +getNombreProducto()String
    +getCategoria()Categoria
    }
    class IRepartidor{
    +getCodr()int
    +getNomr()String
    }
    class Pedido{
    -int: codpe
    -String: nomCliente
    -String: direccionCliente
    -Date: fecha
    -Repartidor: repartidor
    -Map: productos
    +addProducto(Producto, Integer)
    }
    class Producto{
    -int: codpr
    -String: nombreProducto
    -Categoria: categoria
    }
    class Categoria{
    <<enumeration>>
    ALIMENTACION
    DROGUERIA
    HIGIENE
    MASCOTAS
    }
    class Repartidor{
    -int: codr
    -String: nombr
    }
    class PedidoDao{
    +String: url
    +Connection: conexion
    +connect()
    +close()
    +buscar(Pedido)Pedido
    +buscarTodos()ArrayList<Pedidos>
    +crear(Pedido)Pedido
    +modificar(Pedido)Pedido
    +eliminar(Pedido)Pedido
    }
    class ProductoDao{
    +String: url
    +Connection: conexion
    +connect()
    +cloase()
    +buscar(int)Producto
    }
    class RepartidorDao{
    +String: url
    +ResultSet: resultado
    +Connection: conexion
    +connect()
    +close()
    +buscar(Repartidor)Repartidor
    }   
    class ListaPedidos{
    
    }
    class MenuPrincipal{
    
    }
    class NuevoPedido{
    
    }    
    Pedido "1"-- "1" PedidoDao: association
    Repartidor "1"-- "1" RepartidorDao: association
    Producto "1"-- "1" ProductoDao: association 
    Producto <-- Categoria
    IPedido<|--Pedido
    IProducto<|--Producto
    IRepartidor<|--Repartidor
      
```