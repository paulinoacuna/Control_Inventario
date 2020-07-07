/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import estructuraDatos.LinkedStack;

/**
 *
 * @author Thesiz
 */
public class Paginador {

    public static Object[] currentPage = new Object[200];
    public static int counter = 0;
    public static String viewParam = "Productos";

    public static LinkedStack<String> pilaA = new LinkedStack<>();
    public static LinkedStack<String> pilaB = new LinkedStack<>();

    public static void cargarPilas() {
        int size = 0;

        switch (viewParam) {
            case "Productos":
                size = Controlador.ArbolProductosTotales.getSize(); //450, 10000
                break;
            case "Proveedores":
                size = Controlador.ArbolProveedoresTotales.getSize(); //??

                break;
            case "Empleados":
                size = Controlador.ArbolEmpleadosTotales.getSize(); //??

                break;
            default:
                System.out.println("param erroneo");
        }

        while (size > 1) {

            int max = size; //50
            size = size - 199; //1

            /*
              //CALCULAR A DE TIEMPO EJECUCION
                    long TInicio3,
                     TFin3,
                     tiempo3;
                    TInicio3 = System.currentTimeMillis();
                    //inicio algoritmo
                       pilaA.push(String.valueOf(size) + "-" + String.valueOf(max));
                    //fin algoritmo
                    TFin3 = System.currentTimeMillis();
                    tiempo3 = TFin3 - TInicio3;
                    System.out.println("Tiempo ms LinkedStack<String> | op: Push() " + tiempo3);
                //FIN DE LA CALCULADORA
            
             */
            pilaA.push(String.valueOf(size) + "-" + String.valueOf(max));

            size--;

        }

    }

    public static void vaciarPilas() {

        if (!pilaA.isEmpty()) {
            pilaA.pop();
            vaciarPilas();
            return;

        }
        if (!pilaB.isEmpty()) {
            pilaB.pop();
            vaciarPilas();
            return;
        }

    }

    public static int[] nextPage(LinkedStack pilaA, LinkedStack pilaB) {
        int[] intsArray = new int[2];

        if (!pilaA.isEmpty()) {

            /*
             //CALCULAR A DE TIEMPO EJECUCION
                    long TInicio3,
                     TFin3,
                     tiempo3;
                    TInicio3 = System.currentTimeMillis();
                    //inicio algoritmo
                       Object value = pilaA.pop();
                    //fin algoritmo
                    TFin3 = System.currentTimeMillis();
                    tiempo3 = TFin3 - TInicio3;
                    System.out.println("Tiempo ms LinkedStack<String> | op: Pop() " + tiempo3);
                //FIN DE LA CALCULADORA
             */
            Object value = pilaA.pop();
            pilaB.push(value);

            String range = (String) pilaB.top();

            String[] rangeArray = range.split("-");

            intsArray[0] = Integer.parseInt(rangeArray[0]);
            intsArray[1] = Integer.parseInt(rangeArray[1]);

            return intsArray;
        } else {
            System.out.println("No hay mas resultados");
            return intsArray;
        }

    }

    public static int[] prevPage(LinkedStack pilaA, LinkedStack pilaB) {
        int[] intsArray = new int[2];

        if (pilaB.getSize() >= 2) {
            pilaA.push(pilaB.pop());

            /*
             //CALCULAR A DE TIEMPO EJECUCION
                    long TInicio3,
                     TFin3,
                     tiempo3;
                    TInicio3 = System.currentTimeMillis();
                    //inicio algoritmo
                       String range = (String) pilaB.top();
                    //fin algoritmo
                    TFin3 = System.currentTimeMillis();
                    tiempo3 = TFin3 - TInicio3;
                    System.out.println("Tiempo ms LinkedStack<String> | op: top() " + tiempo3);
                //FIN DE LA CALCULADORA
             */
            String range = (String) pilaB.top();
            String[] rangeArray = range.split("-");

            intsArray[0] = Integer.parseInt(rangeArray[0]);
            intsArray[1] = Integer.parseInt(rangeArray[1]);

            return intsArray;
        } else {
            //deshabilitar boton atras
            System.out.println("No hay resultados anteriores");
            return intsArray;
        }

    }

}
