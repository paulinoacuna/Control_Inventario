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
public class Empleado extends Persona implements Crud {

    private int codigoEmpleado;
    private Almacen lugarTrabajo;

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Almacen getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(Almacen lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }
    
    
    
     @Override
    public void agregar(Object key) {
        //CASTING TIPO TYPE => Pedido
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object eliminar(Object key) {
        //CASTING TIPO TYPE => Pedido
        return null;

    }

    @Override
    public Object buscar(Object key) {
        
        return null;
    }

 
    @Override
    public void actualizar(Object key) {
        //Empleado no puede actualizar, debe llamar a administrador
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
