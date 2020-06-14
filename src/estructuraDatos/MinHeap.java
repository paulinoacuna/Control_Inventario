/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

/**
 *
 * @author Thesiz
 */
public class MinHeap {
private int[] Heap;
private int size;
private int maxsize;

private static final int FRONT = 1; 

public MinHeap(int maxsize) 
{ 
    this.maxsize = maxsize; 
    this.size = 0; 
    Heap = new int[this.maxsize + 1]; 
    Heap[0] = Integer.MIN_VALUE; 
} 

// Función para devolver la posición del padre para el nodo actualmente en la posición
private int parent(int pos) 
{ 
    return pos / 2; 
} 

// Función para devolver la posición del hijo izquierdo del nodo actualmente en la posición
private int leftChild(int pos) 
{ 
    return (2 * pos); 
} 

// función para devolver la posición del hijo derecho del nodo actualmente en la posición
private int rightChild(int pos) 
{ 
    return (2 * pos) + 1; 
} 

// Función que devuelve verdadero si el nodo que se da como parametro es un nodo hoja
private boolean isLeaf(int pos) 
{ 
    if (pos >= (size / 2) && pos <= size) { 
        return true; 
    } 
    return false; 
} 

// Función para intercambiar dos nodos del heap
private void swap(int fpos, int spos) 
{ 
    int tmp; 
    tmp = Heap[fpos]; 
    Heap[fpos] = Heap[spos]; 
    Heap[spos] = tmp; 
} 

// Función para amontonar el nodo en posicion
private void minHeapify(int pos) 
{ 

    // Si el nodo no es un nodo hoja y mayor que cualquiera de sus hijos
    if (!isLeaf(pos)) { 
        if (Heap[pos] > Heap[leftChild(pos)] 
            || Heap[pos] > Heap[rightChild(pos)]) { 

            // Intercambia con el hijo izquierdo y lo amontona
            if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                minHeapify(leftChild(pos)); 
            } 

            // Intercambiar con el hijo derecho y lo amontona
            else { 
                swap(pos, rightChild(pos)); 
                minHeapify(rightChild(pos)); 
            } 
        } 
    } 
} 

// Función para insertar un nodo en el heap
public void insert(int element) 
{ 
    if (size >= maxsize) { 
        return; 
    } 
    Heap[++size] = element; 
    int current = size; 

    while (Heap[current] < Heap[parent(current)]) { 
        swap(current, parent(current)); 
        current = parent(current); 
    } 
} 

// Función para imprimir el contenido del heap 
public void print() 
{ 
    for (int i = 1; i <= size / 2; i++) { 
        System.out.print(" PARENT : " + Heap[i] 
                         + " LEFT CHILD : " + Heap[2 * i] 
                         + " RIGHT CHILD :" + Heap[2 * i + 1]); 
        System.out.println(); 
    } 
} 

// Función para construir el minheap usando minHeapify (amontonar)
public void minHeap() 
{ 
    for (int pos = (size / 2); pos >= 1; pos--) { 
        minHeapify(pos); 
    } 
} 

// Función para eliminar y devolver el elemento mínimo del heap
public int remove() 
{ 
    int popped = Heap[FRONT]; 
    Heap[FRONT] = Heap[size--]; 
    minHeapify(FRONT); 
    return popped; 
} 
}