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
public class SubCategoria {

    private int codigosubCategoria;
    private String nombresubCategoria;
    private Categoria categoria;

    public SubCategoria(int codigosubCategoria, String nombresubCategoria, Categoria categoria) {
        this.codigosubCategoria = codigosubCategoria;
        this.nombresubCategoria = nombresubCategoria;
        this.categoria = categoria;
    }

    public int getCodigosubCategoria() {
        return codigosubCategoria;
    }

    public void setCodigosubCategoria(int codigosubCategoria) {
        this.codigosubCategoria = codigosubCategoria;
    }

    public String getNombresubCategoria() {
        return nombresubCategoria;
    }

    public void setNombresubCategoria(String nombresubCategoria) {
        this.nombresubCategoria = nombresubCategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nombresubCategoria;
    }

}
