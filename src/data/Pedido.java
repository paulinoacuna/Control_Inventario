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
public class Pedido {
    private int codigoProducto;
    private ArrayList<Producto>  listaProductos;

    public Pedido(int codigoProducto, ArrayList<Producto> listaProductos) {
        this.codigoProducto = codigoProducto;
        this.listaProductos = listaProductos;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
}
