package com.shopper2.modelo.contenedores;

import com.shopper2.modelo.productos.IProducto;

import java.util.HashSet;
import java.util.Set;

/**
 * Describe los datos necesarios de un contenedor.
 */
public abstract class Contenedor implements IContenedor {
    /**
     * Identificador de un contenedor.
     */
    private String referencia;
    /**
     * Indica la altura de un contenedor.
     */
    private int alto;
    /**
     * Indica la capacidad de resistencia de un contenedor.
     */
    private int resistencia;
    /**
     * Producto en un contenedor.
     */
    private Set<IProducto> producto;

    private Set<IProducto> productos;

    /**
     * Constructor parametrizado.
     *
     * @param referencia del contenedor.
     * @param alto       del contenedor.
     */
    public Contenedor(String referencia, int alto, int resistencia) {
        this.referencia = referencia;
        this.alto = alto;
        this.resistencia = resistencia;
        productos = new HashSet<IProducto>();
    }

    /**
     * Obtiene la referencia del contenedor.
     *
     * @return la referencia del contenedor.
     */
    @Override
    public String getReferencia() {
        return referencia;
    }

    /**
     * Obtiene el volumen del contenedor.
     *
     * @return el valor del volumen del contenedor.
     */
    @Override
    public int getVolumen() {
        return alto * getSuperficie();
    }

    /**
     * Obtiene el volumen restante una vez agregados productos.
     *
     * @return el valor del volumen disponible.
     */
    @Override
    public int volumenDisponible() {

        return getVolumen() - volumenOcupado();
    }

    /**
     * Realiza la suma el volumen de cada uno de los productos del contenedor.
     *
     * @return suma del volumen total de productos del contenedor.
     */
    private int volumenOcupado() {
        int res = 0;
        for (IProducto p : productos) {
            res += p.getVolumen();
        }
        return res;
    }

    /**
     * Obtiene la resistencia soportada por el contenedor.
     *
     * @return su resistencia.
     */
    @Override
    public int getResistencia() {
        return resistencia;
    }

    /**
     * Obtiene los productos existentes en un contenedor.
     *
     * @return producto.
     */
    @Override
    public Set<IProducto> getProductos() {
        return producto;
    }

    /**
     * Comprueba si un producto cabe o no en el contenedor y lo agrega o no.
     *
     * @param producto para agregar.
     * @return si cabe o no.
     */
    @Override
    public boolean meter(IProducto producto) {
        boolean resistenciaOK = resiste(producto);
        boolean volumenOK = producto.tengoEspacio(this);


        boolean acepta = resistenciaOK && volumenOK;
        if (acepta) {
            productos.add(producto);
            producto.meter(this);
        }
        return acepta;
    }

    /**
     * Comprueba la resistencia del contenedor ante un producto.
     *
     * @param producto a soportar por el contenedor.
     * @return si lo soporta o no.
     */
    @Override
    public boolean resiste(IProducto producto) {
        return resistencia > producto.getPeso();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contenedor " + referencia + " [" + getTipo() + "] (sup " + getSuperficie() + "cm2 - vol " + getVolumen() +
                "cm3 - resistencia " + getResistencia() + " g).\n");
        if (productos.isEmpty()) {
            sb.append("\t\tvacío\n");
        }
        for (IProducto p : productos) {
            sb.append("\t\t" + p + "\n");
        }
        sb.append("\t\t>> Disponible vol " + volumenDisponible() + "cm3");
        return sb.toString();
    }
}
