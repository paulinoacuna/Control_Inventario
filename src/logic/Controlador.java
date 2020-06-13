/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import baseDatos.Conexion;
import data.*;
import estructuraDatos.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static logic.Paginador.*;

/**
 *
 * @author Thesiz
 */
public class Controlador {

    public static Categoria categoria = new Categoria(1, "Lacteos");
    public static SubCategoria subCategoria = new SubCategoria(1, "yogures", categoria);
    private static Producto producto = new Producto(1, "boyourt oreo 250g", 2800, 2000, 14, subCategoria);
    public static LinkedAVL<Producto> ArbolProductosTotales = new LinkedAVL<>(producto);

    //testing con la clase Proveedor
    public static LinkedList<Proveedor> ProvedoresTotales = new LinkedList();
    //public static LinkedList<Producto> ProductosTotales = new LinkedList();
    //public static LinkedList<Pedido> PedidosTotales = new LinkedList();
    //public static LinkedList<Empleado> EmpleadosTotales = new LinkedList();
    //public static LinkedList<Almacen> AlmacenesTotales = new LinkedList();
    //public static LinkedList<Categoria> CategoriasTotales = new LinkedList();
    //public static LinkedList<SubCategoria> SubCategoriasTotales = new LinkedList();

    public static void iniciarSesion() {

    }

    public static void registrarse() {

    }

    public static void bienvenida() {
        boolean play = true;

        Scanner input = new Scanner(System.in);
        System.out.println("*** BIENVENIDO AL SISTEMA CONTROL DE INVENTARIOS ***");
        System.out.println("este proyecto aún se encuentra en etapa de desarrollo por lo "
                + "que las opciones Registrarse \ne Inicar Sesión estan desabilidatas. \n");

        while (play) {
            System.out.println("Seleccione una opción:"
                    + "\n1. Agregar proveedor"
                    + "\n2. Eliminar proveedor"
                    + "\n3. Buscar un proveedor"
                    + "\n4. Consultar todos los provedores"
                    + "\n5. Actualizar informacion de proveedor"
                    + "\n6. Ordenar lista de proveedores (A-Z)"
                    + "\n7. Salir");

            int opcion = input.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("AGREGAR PROVEEDOR:");
                    System.out.println("Digite el codigo del proveedor");
                    int inputCodigoProvedor = input.nextInt();
                    input.skip("\n");
                    System.out.println("Digite nombre del proveedor");
                    String inputNombreProvedor = input.nextLine();

                    Proveedor proveedorA = new Proveedor(inputCodigoProvedor, inputNombreProvedor);

                    //CALCULARA DE TIEMPO EJECUCION
                    long TInicio4,
                     TFin4,
                     tiempo4;
                    TInicio4 = System.currentTimeMillis();
                    //inicio algoritmo
                    ProvedoresTotales.agregarDelante(proveedorA);
                    //fin algoritmo
                    TFin4 = System.currentTimeMillis();
                    tiempo4 = TFin4 - TInicio4;
                    System.out.println("Tiempo de ejecución Agregar en LinkedList en milisegundos: " + tiempo4);
                    //FIN DE LA CALCULADORA

                    System.out.println("Proveedor agregado !!\n");
                    System.out.println("__________________________");

                    break;
                case 2:
                    System.out.println("ELIMINAR PROVEEDOR");
                    System.out.println("Digite el codigo del proveedor a eliminar");
                    int inputEliminarProvedor = input.nextInt();

                    Proveedor proveedorC = new Proveedor(inputEliminarProvedor, null);

                    //CALCULARA DE TIEMPO EJECUCION
                    long TInicio5,
                     TFin5,
                     tiempo5;
                    TInicio5 = System.currentTimeMillis();
                    //inicio algoritmo
                    ProvedoresTotales.eliminar(proveedorC);
                    //fin algoritmo
                    TFin5 = System.currentTimeMillis();
                    tiempo5 = TFin5 - TInicio5;
                    System.out.println("Tiempo de ejecución Eliminar en LinkedList en milisegundos: " + tiempo5);
                    //FIN DE LA CALCULADORA

                    break;
                case 3:
                    System.out.println("BUSCAR PROVEEDOR:");
                    System.out.println("Digite el codigo del proveedor a buscar");
                    int inputbuscarCodigoProvedor = input.nextInt();

                    Proveedor proveedorB = new Proveedor(inputbuscarCodigoProvedor, null);

                    //CALCULARA DE TIEMPO EJECUCION
                    long TInicio,
                     TFin,
                     tiempo;
                    TInicio = System.currentTimeMillis();
                    //inicio algoritmo
                    ProvedoresTotales.buscar(proveedorB);
                    //fin algoritmo
                    TFin = System.currentTimeMillis();
                    tiempo = TFin - TInicio;
                    System.out.println("Tiempo de ejecución Buscar en LinkedList en milisegundos: " + tiempo);
                    //FIN DE LA CALCULADORA

                    System.out.println("__________________________");

                    break;
                case 4:
                    System.out.println("LISTA DE PROVEEDORES:");

                    //CALCULARA DE TIEMPO EJECUCION
                    long TInicio1,
                     TFin1,
                     tiempo1;
                    TInicio1 = System.currentTimeMillis();
                    //inicio algoritmo
                    ProvedoresTotales.consultarTodos();
                    //fin algoritmo
                    TFin1 = System.currentTimeMillis();
                    tiempo1 = TFin1 - TInicio1;
                    System.out.println("Tiempo de ejecución BuscarTodos en LinkedList en milisegundos: " + tiempo1);
                    //FIN DE LA CALCULADORA

                    System.out.println("__________________________");

                    break;
                case 5:
                    System.out.println("ACTUALIZAR INFO DE PROVEEDOR:");
                    System.out.println("Digite en numero de proveedor a actualizar");
                    int inputActualizarCodigoProvedor = input.nextInt();

                    input.skip("\n");

                    System.out.println("Digite nuevo nombre del proveedor a actualizar");

                    String inputactualziarNombreProvedor = input.nextLine();

                    Proveedor provedorD = new Proveedor(inputActualizarCodigoProvedor,
                            inputactualziarNombreProvedor);

                    //CALCULAR A DE TIEMPO EJECUCION
                    long TInicio2,
                     TFin2,
                     tiempo2;
                    TInicio2 = System.currentTimeMillis();
                    //inicio algoritmo
                    ProvedoresTotales.actualizar(provedorD);
                    //fin algoritmo
                    TFin2 = System.currentTimeMillis();
                    tiempo2 = TFin2 - TInicio2;
                    System.out.println("Tiempo de ejecución Actualizar elemento en LinkedList en milisegundos: " + tiempo2);
                    //FIN DE LA CALCULADORA

                    System.out.println("__________________________");

                    break;
                case 6:

                    System.out.println("ORDERAR LISTA PROVEEDORES:");
                    //CALCULAR A DE TIEMPO EJECUCION
                    long TInicio3,
                     TFin3,
                     tiempo3;
                    TInicio3 = System.currentTimeMillis();
                    //inicio algoritmo
                    ProvedoresTotales.ordernar();
                    //fin algoritmo
                    TFin3 = System.currentTimeMillis();
                    tiempo3 = TFin3 - TInicio3;
                    System.out.println("Tiempo de ejecución Ordenar la LinkedList en milisegundos: " + tiempo3);
                    //FIN DE LA CALCULADORA

                    break;
                case 7:
                    play = false;
                    break;
            }
        }

    }

}
