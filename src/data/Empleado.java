/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author juanc
 */
public class Empleado implements Comparable {

    private int codigoEmpleado;
    private Almacen lugarTrabajo;
    private String estado= "habilitado";
    private long documento;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String telefono;
    private String contrasena;
    private String rol;

    public Empleado(int codigoEmpleado, Almacen lugarTrabajo, long documento, String nombre, String apellido, String fechaNacimiento, String telefono, String contrasena, String rol) {
        this.codigoEmpleado = codigoEmpleado;
        this.lugarTrabajo = lugarTrabajo;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.rol = rol;
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

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

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int compareTo(Object o) {

        Empleado other = (Empleado) o;

        if (this.codigoEmpleado > other.codigoEmpleado) {
            return 1;
        } else if (this.codigoEmpleado < other.codigoEmpleado) {
            return -1;

        }
        return 0;

    }

    @Override
    public boolean equals(Object o) {
        Empleado other = (Empleado) o;

        if (this.codigoEmpleado == other.codigoEmpleado) {
            return true;
        } else {
            return false;
        }

    }

}
