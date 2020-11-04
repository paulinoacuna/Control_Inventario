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
public class NodoAVL<T> {

    T key;
    int height;
    private NodoAVL<T> left, right;
    
    

    NodoAVL(T key) {
        this.key = key;
        this.height = 0;

    }
    
    

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public NodoAVL<T> getLeft() {
        return left;
    }

    public void setLeft(NodoAVL<T> left) {
        this.left = left;
    }

    public NodoAVL<T> getRight() {
        return right;
    }

    public void setRight(NodoAVL<T> right) {
        this.right = right;
    }
    
    
}
