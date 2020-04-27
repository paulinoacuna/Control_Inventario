/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

/**
 *
 * @author juanc
 */
public class LinkedList<T> extends estructurasLineales {

    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;
      
    

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }

    }

    //CRUD 
    public void push(T key) {
        
        //revisar este metodo
        Nodo<T> nodo = new Nodo<T>(key, this.head, this.tail);
        this.head = nodo;
        this.tail = nodo;

        this.size++;

    }

    public T buscar(T key) {
        return null;
    }
}
