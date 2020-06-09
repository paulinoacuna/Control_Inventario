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
public class LinkedAVL<T extends Comparable> {

    NodoAVL<T> root;

    int counter = 0; //cambiar
    boolean hasRotated = false; //cambiar

    //constructor
    public LinkedAVL() {
        this.root = null;

    }
    //Metods

    //altura
    int height(NodoAVL<T> N) {

        if (N == null) {
            return -1;
        }

        return N.getHeight();
    }

    //max
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //obtener factorBalanceo
    int getBalance(NodoAVL<T> N) {
        return (height(N.getLeft()) - height(N.getRight()));
    }

    //rotations
    NodoAVL<T> rightRotate(NodoAVL<T> y) {
        NodoAVL<T> x = y.getLeft();
        y.setLeft(x.getRight());

        // Perform rotation
        x.setRight(y);

        // actualiza alturas
        y.setHeight(1 + max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + max(height(x.getLeft()), height(x.getRight())));

        // Return new root
        return x;
    }

    NodoAVL<T> leftRotate(NodoAVL<T> x) {

        NodoAVL<T> y = x.getRight();

        x.setRight(y.getLeft());

        y.setLeft(x);

        // actualiza alturas
        x.setHeight(1 + max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + max(height(y.getLeft()), height(y.getRight())));
        // Return new root

        return y;
    }

    //find
    public NodoAVL<T> find(NodoAVL<T> n, T key) {

        if (key.equals(n.key)) {
            return n;

        } else if (key.compareTo(n.key) > 0) { //1  , reuturn 1 if key > n.key
            if (n.getRight() != null) {
                return find(n.getRight(), key);

            }

        } else if (key.compareTo(n.key) < 0) { //-1
            if (n.getLeft() != null) {
                return find(n.getLeft(), key);
            }

        }
        System.out.println("Elemento No Encontrado");
        return null;

    }

    //insert
    public NodoAVL<T> insert(NodoAVL<T> nodo, T key) {

        if (nodo == null) {
            return (new NodoAVL<>(key));
        }

        if (key.compareTo(nodo.key) < 0) { // foo > 0 param primero

            nodo.setLeft(insert(nodo.getLeft(), key));

        } else if (key.compareTo(nodo.key) > 0) {

            nodo.setRight(insert(nodo.getRight(), key));

        } else {

            return nodo;
        }

        //actualizar alturas
        nodo.setHeight(1 + max(height(nodo.getLeft()), height(nodo.getRight())));

        //rebalance
        //comprobar factor balanceo
        int balance = getBalance(nodo); //returns negative if right is gratter

        // desbalanceado izquierda izquierda
        if (balance > 1 && key.compareTo(nodo.getLeft().key) < 0) {

            this.hasRotated = true;
            return rightRotate(nodo);

        }

        // derecha derecha
        if (balance < -1 && key.compareTo(nodo.getRight().key) > 0) {

            this.hasRotated = true;
            return leftRotate(nodo);

        }

        //double rotations
        // Izquierda derecha
        if (balance > 1 && key.compareTo(nodo.getLeft().key) > 0) {
            this.hasRotated = true;
            nodo.setLeft(leftRotate(nodo.getLeft()));
            return rightRotate(nodo);
        }

        // Derecha Izquierda
        if (balance < -1 && key.compareTo(nodo.getRight().key) < 0) {
            this.hasRotated = true;
            nodo.setRight(rightRotate(nodo.getRight()));
            return leftRotate(nodo);
        }

        return nodo;
    }

    public void inOrder(NodoAVL<T> n) {
        if (n != null) {
            inOrder(n.getLeft());
            //TODO: enviar a jframe para visualizar
                System.out.println(n.getKey().toString());
            inOrder(n.getRight());
        }
    }
    //TODO: 
   
    //ELIMINAR

}
