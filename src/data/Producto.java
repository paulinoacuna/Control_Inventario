/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author juanc
 */
public class Producto implements Comparable {

    private int codigoProducto;
    private String descripcion;
    private int precioVenta;
    private int precioCompra;
    private int cantidadUnidades;
    private SubCategoria subCategoria;
    public static boolean compararPorCantidad = false;

    private double descuento = 0;

    public Producto(int codigoProducto, String descripcion, int precioVenta, int precioCompra,
            int cantidadUnidades, SubCategoria subCategoria) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.cantidadUnidades = cantidadUnidades;
        this.subCategoria = subCategoria;

    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void aumentarStock(Producto producto) {

        this.cantidadUnidades += producto.cantidadUnidades;

    }

    public void reducirStock(Producto producto) {
        if (this.cantidadUnidades > 0) {
            this.cantidadUnidades -= producto.cantidadUnidades;
        } else {
            System.out.println("Producto Agotado");
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        Producto other = (Producto) o;

        if (this.codigoProducto == other.codigoProducto) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int compareTo(Object o) {
        Producto other = (Producto) o;
        if (!compararPorCantidad) {

            if (this.codigoProducto > other.codigoProducto) {
                return 1;
            } else if (this.codigoProducto < other.codigoProducto) {
                return -1;

            }
            return 0;

        } else {

            if (this.cantidadUnidades >= other.cantidadUnidades) {
                return 1;
            } else if (this.cantidadUnidades < other.cantidadUnidades) {
                return -1;

            }
            return 0;

        }

    }

    @Override
    public String toString() {
        return codigoProducto
                + "| |" + descripcion + "| |"
                + precioVenta + "| |" + precioCompra
                + "| |" + cantidadUnidades + "| |"
                + subCategoria + "| |" + descuento;
    }

}
