/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

import data.Proveedor;
import java.util.Objects;

/**
 *
 * @author juanc
 */
public class LinkedList<T> extends estructurasLineales {

    protected Nodo<T> head;
    protected Nodo<T> tail;
    private int size;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.head.valor.equals(obj)) {
            return true;
        }
        return true;
    }

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

    //METODS
    public void agregarDelante(T key) {
        //esta operacion pesa O(1)

        //solo ageega elementos en la cabeza
        if (isEmpty()) {

            this.head = new Nodo<>(key, this.head);
            this.tail = head;
            this.size++;

        } else {

            Nodo<T> newNodo = new Nodo<>(key, this.head);
            this.head = newNodo;
            this.size++;
        }

    }

    //error
    public Nodo<T> buscar(T key) {

        Nodo temp = this.head;

        while (temp != null) {
            if (temp.valor.equals(key)) {
                System.out.println("Elemento encontrado: " + "[" + temp.valor + "]");
                return temp;
            } else {
                temp = temp.next;
            }

        }
        System.out.println("Elemento no encontrado");
        return null;

    }

    public void consultarTodos() {
        //esta operacion pesa O(n)
        Nodo element = this.head;
        while (element != null) {
            System.out.println("[" + element.valor + "]");
            element = element.next;
        }

    }

    //mejorar eliminacion
    public void eliminar(T element) {

        if (!isEmpty()) {
            if (this.head == this.tail && (this.head.valor.equals(element))) {
                this.head = this.tail = null;

            } else if (this.head.valor.equals(element)) {
                //si es el primero pero hay mas elementos
                this.head = this.head.next;

            } else {
                //si esta en medio
                Nodo prev, temp;
                prev = this.head;
                temp = this.head.next;
                while (temp != null && (!temp.valor.equals(element))) {
                    prev = prev.next;
                    temp = temp.next;
                }
                if (temp != null) {
                    //si no es el ultimo
                    prev.next = temp.next;
                    if (temp == this.tail) {
                        this.tail = prev;
                    }

                }

            }

            this.size--;
        } else {
            System.out.println("Lista vacia");
        }

    }

    public void ordernar() {
        //ingrese su logica aqui

    }

    public void actualizar(T key) {
        Nodo temp = buscar(key);
        
        if(temp != null){
            //ecnontrado
            temp.valor = key;
            System.out.println("Elemento modificado: " + temp.valor);
            
        }else{
            System.out.println("Elemento no encontrado, modificación cancelada");
        }

    }

}
