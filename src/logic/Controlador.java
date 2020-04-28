/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.*;
import estructuraDatos.*;
import java.util.Scanner;

/**
 *
 * @author Thesiz
 */
public class Controlador {

    //testing con la clase Proveedor
    public static LinkedList<Proveedor> ProvedoresTotales = new LinkedList();

    public static LinkedList<Producto> ProductosTotales = new LinkedList();
    public static LinkedList<Pedido> PedidosTotales = new LinkedList();
    public static LinkedList<Empleado> EmpleadosTotales = new LinkedList();
    public static LinkedList<Almacen> AlmacenesTotales = new LinkedList();
    public static LinkedList<Categoria> CategoriasTotales = new LinkedList();
    public static LinkedList<SubCategoria> SubCategoriasTotales = new LinkedList();

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
                    ProvedoresTotales.agregarDelante(proveedorA);
                    System.out.println("Proveedor agregado !!\n");
                    System.out.println("__________________________");

                    break;
                case 2:
                    System.out.println("ELIMINAR PROVEEDOR");
                    System.out.println("Digite el codigo del proveedor a eliminar");
                    int inputEliminarProvedor = input.nextInt();

                    Proveedor proveedorC = new Proveedor(inputEliminarProvedor, null);

                    ProvedoresTotales.eliminar(proveedorC);

                    break;
                case 3:
                    System.out.println("BUSCAR PROVEEDOR:");
                    System.out.println("Digite el codigo del proveedor a buscar");
                    int inputbuscarCodigoProvedor = input.nextInt();

                    Proveedor proveedorB = new Proveedor(inputbuscarCodigoProvedor, null);

                    ProvedoresTotales.buscar(proveedorB);

                    System.out.println("__________________________");

                    break;
                case 4:
                    System.out.println("LISTA DE PROVEEDORES:");
                    ProvedoresTotales.consultarTodos();

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

                    ProvedoresTotales.actualizar(provedorD);

                    System.out.println("__________________________");

                    break;
                case 6:

                    System.out.println("ORDERAR LISTA PROVEEDORES:");
                    
                    ProvedoresTotales.ordernar();
                    break;
                case 7:
                    play = false;
                    break;
            }
        }

    }

    public static void iniciarSesion() {

    }

    public static void registrarse() {

    }

}
