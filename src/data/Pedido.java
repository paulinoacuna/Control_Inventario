/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class Pedido implements Comparable {

    private int codigoPedido;
    private static int count = 0;
    private ArrayList<Producto> listaProductos;

    public Pedido(ArrayList<Producto> listaProductos) {
        this.codigoPedido = ++count;
        this.listaProductos = listaProductos;
    }

    public Pedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;

    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "codigoPedido: " + codigoPedido + "| listaProductos: " + listaProductos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        Pedido other = (Pedido) obj;

        if (this.codigoPedido == other.codigoPedido) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        Pedido other = (Pedido) o;

        //si prev > next retorna 1
        //jmmmm
        //TODO: CAMBIAR METODO DE COMPARACION
        if (this.codigoPedido > other.codigoPedido) {
            return 1;
        } else if (this.codigoPedido < other.codigoPedido) {
            return -1;

        }
        return 0;

    }

}
