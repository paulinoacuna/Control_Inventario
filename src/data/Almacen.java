/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import estructuraDatos.LinkedList;

/**
 *
 * @author juanc
 */
public class Almacen {
    private int codigoAlmacen;
    private String nombreAlmacen;
    //NOTA: EN MYSQL EL TELEFONO ESTA ALMACENADO EN TIPO CADENA DE TEXTO
    private long telefonoAlmacen;
    private String direccion;
    private LinkedList listaProductos=new LinkedList();
    private LinkedList listaPedidos=new LinkedList();
    private LinkedList listaEmpleados=new LinkedList();
    private LinkedList listaProveedores=new LinkedList();

    public Almacen(int codigoAlmacen, String nombreAlmacen, long telefonoAlmacen, String direccion) {
        this.codigoAlmacen = codigoAlmacen;
        this.nombreAlmacen = nombreAlmacen;
        this.telefonoAlmacen = telefonoAlmacen;
        this.direccion = direccion;
    }

    public int getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(int codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public long getTelefonoAlmacen() {
        return telefonoAlmacen;
    }

    public void setTelefonoAlmacen(long telefonoAlmacen) {
        this.telefonoAlmacen = telefonoAlmacen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(LinkedList listaProductos) {
        this.listaProductos = listaProductos;
    }

    public LinkedList getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(LinkedList listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public LinkedList getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(LinkedList listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public LinkedList getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(LinkedList listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    


}
