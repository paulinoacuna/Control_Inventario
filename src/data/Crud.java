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
public interface Crud {
    public void agregar(Object key);
    public void actualizar(Object key);
    public Object eliminar(Object key); 
    public Object buscar(Object key);
}
