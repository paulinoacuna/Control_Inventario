/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

/**
 *
 * @author juanc Item<T extends Comparable<T>>
 */
public class Nodo<T> {

    T valor;
    Nodo<T> next;
    //private Nodo<T> prev;

    public Nodo(T valor, Nodo<T> next) {
        this.valor = valor;
        this.next = next;
        //this.prev = null;
    }

    public T getValor() {
        return valor;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

}
