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
public class Nodo<T> {
    
    T valor;
    Nodo<T> next;
    Nodo<T> prev;

    public Nodo(T valor, Nodo<T> next, Nodo<T> prev) {
        this.valor = valor;
        this.next = next;
        this.prev = prev;
    }
    
}
