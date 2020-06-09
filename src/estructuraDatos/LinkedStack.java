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
public class LinkedStack<T> {
    //usada para insertar rango de busqueda de paginacion, deberia almacenar un String en cada nodo

    private Nodo<T> top;
    private int size;

    public LinkedStack() {

        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {

        if (this.top == null && size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(T key) {

        Nodo<T> nodo = new Nodo<>(key, this.top);

        this.top = nodo; // sube el top al nuevo

        this.size++;
    }

    public T pop() {

        T temp;

        if (isEmpty()) {
            System.out.println("Pila Vacia");
            return null;
        } else {
            temp = this.top.getValor();
            this.top = this.top.getNext();
            this.size--;

        }
        return temp;
    }

    public T top() {

        if (isEmpty()) {
            System.out.println("Pila Vacia");
            return null;
        } else {
            return this.top.getValor();

        }

    }

}
