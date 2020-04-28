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

    protected Nodo<T> head;
    protected Nodo<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        this.size = 0;
    }

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
    public void agregarDelante(T key) {

        //solo ageega elementos en la cabeza
        if ((size <= 0) && (this.head == null) && (this.tail == null)) {

            this.head = new Nodo<>(key, this.head);
            this.tail = head;
            this.size++;

        } else {

            Nodo<T> newNodo = new Nodo<>(key, this.head);
            this.head = newNodo;
            this.size++;
        }

    }

    public T buscar(T key) {
        return null;
    }

}
