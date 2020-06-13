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

    public static Object[] currentPage = new Object[50];
    public static int counter = 0;

    public static LinkedStack<String> pilaA = new LinkedStack<>();
    public static LinkedStack<String> pilaB = new LinkedStack<>();

    public static void cargarPilas() {

        int size = Controlador.ArbolProductosTotales.getSize(); //450

        while (size > 1) {

            int max = size; //50
            size = size - 49; //1

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

            pilaB.push(pilaA.pop());

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
