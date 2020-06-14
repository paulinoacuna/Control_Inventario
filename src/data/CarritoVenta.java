/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Thesiz
 */
public class CarritoVenta implements Comparable {
    //codigo copiado de Pedido, TODO: crear herencia abstracta

    private int codigoVenta;
    private static int count = 0;
    private ArrayList<Producto> listaProductos;

    public CarritoVenta(ArrayList<Producto> listaProductos) {
        this.codigoVenta = ++count;
        this.listaProductos = listaProductos;
    }

    public CarritoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;

    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "codigoVenta: " + codigoVenta + "| listaProductos: " + listaProductos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        CarritoVenta other = (CarritoVenta) obj;

        if (this.codigoVenta == other.codigoVenta) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        CarritoVenta other = (CarritoVenta) o;

        //si prev > next retorna 1
        //jmmmm
        //TODO: CAMBIAR METODO DE COMPARACION
        if (this.codigoVenta > other.codigoVenta) {
            return 1;
        } else if (this.codigoVenta < other.codigoVenta) {
            return -1;

        }
        return 0;

    }

}
