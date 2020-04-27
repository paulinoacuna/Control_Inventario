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
public class Categoria {
    private int codigoCategoria;
    private String nombreCategoria;
    private SubCategoria subCategoria;

    public Categoria(int codigoCategoria, String nombreCategoria, SubCategoria subCategoria) {
        this.codigoCategoria = codigoCategoria;
        this.nombreCategoria = nombreCategoria;
        this.subCategoria = subCategoria;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }
    
    
    
}
