/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

import java.util.Arrays;

/**
 *
 * @author Thesiz
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] heap;
    private int length;
    private boolean min;

    /**
     * Construtor Estandar capacidad maxima de 9 (el indice 0 nunca se usa)
     */
    public MinHeap() {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        length = 0;
        min = true;
    }

    /**
     * Constructor - toma un arreglo de tipo T y un valor booleano para min /
     * max
     *
     * @param array T[] array
     * @param min boolean true = min heap, false = max heap
     */
    public MinHeap(T[] array, boolean min) {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        length = 0;
        this.min = min;
        // Añade cada elemento al Heap
        for (T each : array) {
            add(each);
        }
    }

    /**
     * Constructor - especifica si boolean true = min heap, false = max heap
     *
     * @param min boolean true = min heap, false = max heap
     */
    public MinHeap(boolean min) {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        length = 0;
        this.min = min;
    }

    /**
     * trae el arreglo que representa el Heap
     *
     * @return arreglo de tipo T[]
     */
    public T[] getHeap() {
        return Arrays.copyOfRange(heap, 1, length + 1);
    }

    /**
     * Añade un valor generico de tipo T al Heap Recorre un arbol hacia abajo
     *
     * @param value valor tipo T
     */
    public void add(T value) {
        if (this.length >= heap.length - 1) {
            heap = this.resize();
        }

        length++;
        heap[length] = value;
        bubbleUp();
    }

    /**
     * Remueve el maximo o el minimo item del heap
     * <p>
     * re-heapifies
     *
     * @return valor de T que es el valor mínimo o máximo en el Heap
     */
    public T remove() {
        T result = peek();

        swap(1, length);
        heap[length] = null;
        length--;

        bubbleDown();

        return result;
    }

    /**
     * Elimina un nodo (objeto) especifico del Heap
     *
     * @param value type T
     * @return verdadero (boolean) si lo encuentra y elimina
     */
    public boolean remove(T value) {
        for (int i = 0; i < heap.length; i++) {
            if (value.equals(heap[i])) {
                System.out.println(i);
                swap(i, length);
                heap[length] = null;
                length--;
                bubbleDown();
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina el elemento mínimo o máximo del montón igual que remove () pero
     * no arroja excepción en vacío
     *
     * @ valor de retorno de T que es el valor mínimo o máximo en el Heap; o
     * null si está vacío
     */
    public T poll() {
        if (isEmpty()) {
            return null;
        }

        T result = peek();

        swap(1, length);
        heap[length] = null;
        length--;

        bubbleDown();

        return result;
    }

    /**
     * Revisa si el Heap esta vacio
     *
     * @return true si esta vacio
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Devuelve el max/min sin eliminar
     *
     * @return valor tipo T
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return heap[1];
    }

    /**
     * Tamaño del Heap
     *
     * @return un entero
     */
    public int length() {
        return length;
    }

    private T[] resize() {
        // Añade capacidad, tamaño (?) REVISAR SI ES NECESARIO
        return Arrays.copyOf(heap, heap.length + DEFAULT_CAPACITY);
    }

    private void bubbleUp() {
        int index = length;
        if (min) {
            while (hasParent(index) && (parent(index).compareTo(heap[index]) > 0)) {
                swap(index, parentIndex(index));
                index = parentIndex(index);
            }
        } else {
            while (hasParent(index) && (parent(index).compareTo(heap[index]) < 0)) {
                swap(index, parentIndex(index));
                index = parentIndex(index);
            }

        }
    }

    private void bubbleDown() {
        int index = 1;
        if (min) // min heap
        {

            while (hasLeftChild(index)) {
                // Halla el menor de los valores entre los nodos (hijos)
                int smaller = leftIndex(index);
                if (hasRightChild(index) && heap[leftIndex(index)].compareTo(heap[rightIndex(index)]) > 0) {
                    smaller = rightIndex(index);
                }
                if (heap[index].compareTo(heap[smaller]) > 0) {
                    swap(index, smaller);
                } else {
                    break;
                }

                index = smaller;
            }
        } else // MaxHeap
        {
            while (hasLeftChild(index)) {
                // Halla el mayor de los valores entre los nodos (hijos)
                int larger = leftIndex(index);
                if (hasRightChild(index) && heap[leftIndex(index)].compareTo(heap[rightIndex(index)]) < 0) {
                    larger = rightIndex(index);
                }
                if (heap[index].compareTo(heap[larger]) < 0) {
                    swap(index, larger);
                } else {
                    break;
                }

                index = larger;
            }

        }
    }

    /**
     * Si nodo hijo tiene un padre (en ingles tiene mas sentido)
     *
     * @param i integer - index
     * @return true if index > 1
     */
    private boolean hasParent(int i) {
        return i > 1;
    }

    /**
     * Trae el indice del nodo izquierdo
     *
     * @param i index
     * @return indice i
     */
    private int leftIndex(int i) {
        return i * 2;
    }

    /**
     * Trae el indice del nodo derecho
     *
     * @param i index
     * @return indice i
     */
    private int rightIndex(int i) {
        return i * 2 + 1;
    }

    /**
     * Revisa si el nodo es un padre con nodo izquierdo
     *
     * @param i index
     * @return verdadero si si lo tiene.
     */
    private boolean hasLeftChild(int i) {
        return leftIndex(i) <= length;
    }

    /**
     * Revisa si el nodo es un padre con nodo derecho
     *
     * @param i index
     * @return verdadero si si lo tiene.
     */
    private boolean hasRightChild(int i) {
        return rightIndex(i) <= length;
    }

    /**
     * Obtiene el indice del nodo padre
     *
     * @param i index
     * @return indice i
     */
    private int parentIndex(int i) {
        return i / 2;
    }

    /**
     * Valor del padre
     *
     * @param i index
     * @return valor tipo T
     */
    private T parent(int i) {
        return heap[parentIndex(i)];
    }

    /**
     * Operacion basica - cambiar 2 valores en el Heap
     *
     * @param index1 int first index
     * @param index2 int second index
     */
    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    /**
     * REVISAR SI NECESARIO - FUNCION OVERRIDE PARA EL METODO toString
     *
     * @return vuelve string todos los valores del Heap sin dejar un null
     */
    @Override
    public String toString() {
        String retval = "";
        for (T each : heap) {
            if (each != null) {
                retval += each + " : ";
            }
        }
        return retval + "\n";

    }
}
