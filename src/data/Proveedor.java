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
public class Proveedor implements Comparable {

    private int codigoProveedor;
    private String nombreComercial;

    public Proveedor(int codigoProveedor, String nombreComercial) {
        this.codigoProveedor = codigoProveedor;
        this.nombreComercial = nombreComercial;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    @Override
    public String toString() {
        return nombreComercial + " "+ codigoProveedor ;
    }

    @Override
    public boolean equals(Object o) {
        Proveedor other = (Proveedor) o;

        if (this.codigoProveedor == other.codigoProveedor) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int compareTo(Object o) {
        Proveedor other = (Proveedor) o;

        //si prev > next retorna 1
        if (this.codigoProveedor > other.codigoProveedor) {
            return 1;
        }
        return 0;
    }


}
