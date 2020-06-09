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
    private Categoria categoria;

    private double descuento = 0;

    public Producto(int codigoProducto, String descripcion, int precioVenta, int precioCompra,
            int cantidadUnidades, Categoria categoria) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.cantidadUnidades = cantidadUnidades;
        this.categoria = categoria;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

        //si prev > next retorna 1
        //jmmmm
        //TODO: CAMBIAR METODO DE COMPARACION
        if (this.codigoProducto > other.codigoProducto) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto
                + ", descripcion=" + descripcion + ", precioVenta="
                + precioVenta + ", precioCompra=" + precioCompra
                + ", cantidadUnidades=" + cantidadUnidades + ", categoria="
                + categoria + ", descuento=" + descuento + '}';
    }

}
