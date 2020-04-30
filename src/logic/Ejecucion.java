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

            int counter = 1;
            int counter2 = 1;

            //registros de entrada seteados, por defecto entran 100.000
            while (rs.next() && counter <= 10000) {
                //System.out.println(rs.getInt("total"));

                Proveedor provedorA = new Proveedor(rs.getInt("llave"), rs.getString("nombre"));

                Controlador.ProvedoresTotales.agregarDelante(provedorA);

                counter++;
            }
            //multiplicador de data en tiempo de ejecucion
            //seteado a 400.000 registros más
            while (counter > 100000 && counter2 <= 1) {

                Proveedor provedorB = new Proveedor(rs.getInt("llave") + counter2, rs.getString("nombre"));
                Controlador.ProvedoresTotales.agregarDelante(provedorB);
                counter2++;

            }

            con.conex.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("No se ha logrado conectar con MySQL. Esto "
                    + "no afecta el funcionamiento del programa");
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
