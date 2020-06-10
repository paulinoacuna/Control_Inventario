/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Rama 2 creada Version 2.0
package logic;

import baseDatos.*;
import data.*;
import estructuraDatos.*;
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

        int counter = 1;
        int counter2 = 1;

        Categoria categoria = new Categoria(1, "Lacteos");
        SubCategoria subCategoria = new SubCategoria(1, "yogures", categoria);
        Producto producto = new Producto(1, "boyourt oreo 250g", 2800, 2000, 14, subCategoria);
        Producto productoW = new Producto(45, "boyourt oreo 250g", 2800, 2000, 14, subCategoria);

        LinkedAVL<Producto> arbol = new LinkedAVL<>(producto);
        try {

            st = con.conex.createStatement();

            rs = st.executeQuery("select * from producto");

            //registros de entrada seteados, por defecto entran 100.000
            while (rs.next() && counter <= 3) {
                //System.out.println(rs.getInt("total"));

                //Proveedor provedorA = new Proveedor(rs.getInt("llave"), rs.getString("nombre"));
                Producto productoA
                        = new Producto(rs.getInt("codigoProducto"),
                                rs.getString("descripcion"),
                                rs.getInt("precioVenta"),
                                rs.getInt("precioCompra"),
                                rs.getInt("cantidadUnidades"),
                                subCategoria);

                //Controlador.ProvedoresTotales.agregarDelante(provedorA);
                arbol.insert(arbol.getRoot(), productoA);

                counter++;
            }
            //multiplicador de data en tiempo de ejecucion
            //seteado a 400.000 registros más
            while (counter2 <= 4000000) {

                //Proveedor provedorB = new Proveedor(rs.getInt("llave") + counter2, rs.getString("nombre"));
                Producto productoB
                        = new Producto(rs.getInt("codigoProducto") + counter2,
                                rs.getString("descripcion"),
                                rs.getInt("precioVenta"),
                                rs.getInt("precioCompra"),
                                rs.getInt("cantidadUnidades"),
                                subCategoria);

                //Controlador.ProvedoresTotales.agregarDelante(provedorB);
                arbol.insert(arbol.getRoot(), productoB);
                counter2++;

            }

            con.conex.close();
            System.out.println("MySQL conection successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.out.println("No se ha logrado conectar con MySQL. Esto "
                    + "no afecta el funcionamiento del programa");
        }

       // arbol.inOrder(arbol.getRoot());

        //CALCULARA DE TIEMPO EJECUCION
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        //inicio algoritmo
        NodoAVL element = arbol.find(arbol.getRoot(), productoW);
        System.out.println(element.getKey());
        //fin algoritmo
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        //FIN DE LA CALCULADORA

        //Controlador.bienvenida();
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
