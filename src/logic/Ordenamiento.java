/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.*;
import estructuraDatos.*;

/**
 *
 * @author Thesiz
 */
public class Ordenamiento<T> {

    private MinHeap myHeap;

    public MinHeap getMyHeap() {
        return myHeap;
    }

    public void cargarMinHeap() {

        T[] array = (T[]) Controlador.ArbolProductosTotales.getKeysArray();
        //no es generica la funcion, solo funciona con arbol de productos
        Producto.compararPorCantidad = true;

        this.myHeap = new MinHeap((Comparable[]) array, true);

        Producto.compararPorCantidad = false;

    }

}
