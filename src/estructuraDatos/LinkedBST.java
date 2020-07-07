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
public class LinkedBST<T> {

    NodoBST<T> raiz;

    public LinkedBST(NodoBST<T> raiz) {
        this.raiz = raiz;
    }

    public LinkedBST() {

    }

    //Metods
    public boolean find(T key) {

        boolean isEncontrado = false;

        return isEncontrado;
    }

    public void DisplayOrden(NodoBST raiz) {
        //InOrder LVR
        if (raiz != null) {
            DisplayOrden(raiz.getLeft());
            System.out.print(" " + raiz.getKey());
            DisplayOrden(raiz.getRigth());

        }
    }

    public void PostOrden(NodoBST raiz) {
        //InOrder LVR
        if (raiz != null) {

            PostOrden(raiz.getLeft());
            PostOrden(raiz.getRigth());
            System.out.print(" " + raiz.getKey());

        }
    }

    public void insertar(T key) {
        NodoBST newNodo = new NodoBST<>(key, null, null);

        if (this.raiz == null) {
            raiz = newNodo;
            return;
        }

        //mirar si es mayor o menor
        //se usa nodo temporal para hacer la busqueda
        NodoBST currentNodo = raiz;
        NodoBST parentNodo = null;

        while (true) {

            parentNodo = currentNodo;
            if (key instanceof Integer) {
                if ((Integer) key < (Integer) currentNodo.getKey()) {
                    currentNodo = currentNodo.getLeft();

                    if (currentNodo == null) {
                        parentNodo.setLeft(newNodo);
                        return;

                    }
                } else {
                    currentNodo = currentNodo.getRigth();

                    if (currentNodo == null) {
                        parentNodo.setRigth(newNodo);
                        return;

                    }

                }
            }

        }
    }
}
