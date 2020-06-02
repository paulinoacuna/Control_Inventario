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
public class NodoBST<T> {

    T key;
    private NodoBST<T> left;
    private NodoBST<T> rigth;

    //constrctores
    public NodoBST() {

    }

    public NodoBST(T key, NodoBST<T> left, NodoBST<T> rigth) {
        this.key = key;
        this.left = left;
        this.rigth = rigth;
    }
    
    //getters setters

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public NodoBST<T> getLeft() {
        return left;
    }

    public void setLeft(NodoBST<T> left) {
        this.left = left;
    }

    public NodoBST<T> getRigth() {
        return rigth;
    }

    public void setRigth(NodoBST<T> rigth) {
        this.rigth = rigth;
    }
   

}
