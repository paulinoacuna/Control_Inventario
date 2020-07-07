/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

/**
 *
 * @author Thesiz
 * @param <T>
 */
public class LinkedQueue<T> {

    private int count;
    private Nodo<T> front, back;

    public LinkedQueue() {
        count = 0;
        front = back = null;
    }

    public void enqueue(T key) {
        Nodo<T> nodo = new Nodo<>(key, null);

        if (isEmpty()) {
            front = nodo;
        } else {
            back.setNext(nodo);
        }

        back = nodo;
        count++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Cola Vacia");
            return null;
        }

        T key = front.getValor();
        front = front.getNext();
        count--;

        if (isEmpty()) {
            back = null;
        }

        return key;
    }

    public T getFront() {
        if (isEmpty()) {
            System.out.println("Cola Vacia");
            return null;
        }

        return front.getValor();
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    public String toString() {

        String value = "";
        Nodo<T> current = front;

        while (current != null) {
            value = value + (current.getValor()).toString() + "\n";
            current = current.getNext();
        }

        return value;
    }
}
