/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import baseDatos.*;
import data.*;
import estructuraDatos.LinkedList;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Ejecucion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion con = new Conexion();

        Statement st;
        ResultSet rs;
        try {
            st = con.conex.createStatement();

            rs = st.executeQuery("select * from proveedor");

            while (rs.next()) {
                //System.out.println(rs.getInt("total"));

                Proveedor provedor = new Proveedor(rs.getInt("llave"), rs.getString("nombre"));

                Controlador.ProvedoresTotales.agregarDelante(provedor);

            }
            con.conex.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        Controlador.bienvenida();
        
        /* //CALCULARA DE TIEMPO EJECUCION
                    long TInicio, TFin,tiempo;
                    TInicio = System.currentTimeMillis();
                    //inicio algoritmo
                    ProvedoresTotales.buscar(proveedorB);
                    //fin algoritmo
                    TFin = System.currentTimeMillis();
                    tiempo = TFin - TInicio;
                    System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
                    //FIN DE LA CALCULADORA

         */
    }

}
