/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

import data.Empleado;
import data.Producto;
import data.Proveedor;
import java.util.ArrayList;
import logic.Paginador;

/**
 *
 * @author Thesiz
 * @param <T>
 */
public class LinkedAVL<T extends Comparable> {

    private NodoAVL<T> root;
    private int size = 0;
    private int counter = 0;

    private boolean hasRotated = false;

    //constructor
    public LinkedAVL(T key) {

        this.root = new NodoAVL<>(key);
        this.size = 1;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodoAVL<T> getRoot() {
        return root;
    }

    public void setRoot(NodoAVL<T> root) {
        this.root = root;
    }

    public boolean isHasRotated() {
        return hasRotated;
    }

    public void setHasRotated(boolean hasRotated) {
        this.hasRotated = hasRotated;
    }

    //Metods
    public NodoAVL<T> insert(NodoAVL<T> nodo, T key) {
        //actualiza la nueva raiz si hubo rotacion
        NodoAVL<T> newRoot = add(nodo, key);

        if (this.isHasRotated()) {
            this.setRoot(newRoot);
            this.setHasRotated(false);
        }

        return nodo;

    }

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
    public NodoAVL<T> add(NodoAVL<T> nodo, T key) {

        if (nodo == null) {
            this.size++;
            return (new NodoAVL<>(key));

        }

        if (key.compareTo(nodo.key) < 0) { // foo > 0 param primero

            nodo.setLeft(add(nodo.getLeft(), key));

        } else if (key.compareTo(nodo.key) > 0) {

            nodo.setRight(add(nodo.getRight(), key));

        } else if (key.equals(nodo.key)) {
            System.out.println("Elemento repetido");

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

    public T[] inOrder(NodoAVL<T> n, T[] keysArray) {
        if (n != null) {
            inOrder(n.getLeft(), keysArray);

            //System.out.println(n.getKey().toString());
            keysArray[counter] = n.getKey();
            counter++;

            //System.out.println(n.getKey().toString());
            inOrder(n.getRight(), keysArray);
        }
        return keysArray;
    }

    public T[] getKeysArray() {
        T[] keysArray = (T[]) new Comparable[this.size];
        counter = 0;
        return inOrder(this.root, keysArray);
    }

    public void printByRange(NodoAVL<T> root, int k1, int k2) {

        if (null == root) {
            return;
        }

        //comprovar si tengo en el arbol productos
        if (root.getKey().getClass() == Producto.class) {

            Producto producto = (Producto) root.getKey();

            if (k1 < producto.getCodigoProducto()) {
                printByRange(root.getLeft(), k1, k2);
            }

            if (k1 <= producto.getCodigoProducto() && k2 >= producto.getCodigoProducto()) {
                Paginador.currentPage[Paginador.counter] = root.getKey();
                Paginador.counter++;
            }

            if (k2 > producto.getCodigoProducto()) {
                printByRange(root.getRight(), k1, k2);
            }

        } else if (root.getKey().getClass() == Proveedor.class) {
            Proveedor proveedor = (Proveedor) root.getKey();

            if (k1 < proveedor.getCodigoProveedor()) {
                printByRange(root.getLeft(), k1, k2);
            }

            if (k1 <= proveedor.getCodigoProveedor() && k2 >= proveedor.getCodigoProveedor()) {
                Paginador.currentPage[Paginador.counter] = root.getKey();
                Paginador.counter++;
            }

            if (k2 > proveedor.getCodigoProveedor()) {
                printByRange(root.getRight(), k1, k2);
            }

        } else if (root.getKey().getClass() == Empleado.class) {
            Empleado empleado = (Empleado) root.getKey();

            if (k1 < empleado.getCodigoEmpleado()) {
                printByRange(root.getLeft(), k1, k2);
            }

            if (k1 <= empleado.getCodigoEmpleado() && k2 >= empleado.getCodigoEmpleado()) {
                Paginador.currentPage[Paginador.counter] = root.getKey();
                Paginador.counter++;
            }

            if (k2 > empleado.getCodigoEmpleado()) {
                printByRange(root.getRight(), k1, k2);
            }

        }

    }

    //TODO COMPLETE
    public NodoAVL<T> delete(NodoAVL<T> root, T key) {

        NodoAVL<T> nodo = this.find(root, key);

        return null;
    }

    //TODO: 
    //ELIMINAR
}
