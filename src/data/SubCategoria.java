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
public class SubCategoria  {
    private int codigosubCategoria;
    private String nombresubCategoria;

    public SubCategoria(int codigosubCategoria, String nombresubCategoria) {
        this.codigosubCategoria = codigosubCategoria;
        this.nombresubCategoria = nombresubCategoria;
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
    
    

 
  
    
}
