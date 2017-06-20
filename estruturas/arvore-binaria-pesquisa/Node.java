/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybinarysearchtree;

/**
 *
 * @author felipemfp
 */
public class Node {
    private Object k;
    private Object o;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(Object k, Object o) {
        this.k = k;
        this.o = o;
    }

    public Node(Object k, Object o, Node parent) {
        this.k = k;
        this.o = o;
        this.parent = parent;
    }
    
    public void setKey(Object k) {
        this.k = k;
    }
    
    public Object getKey() {
        return this.k;
    }

    public Node getParent() {
        return parent;
    }
    
    public void setParent(Node n) {
        this.parent = n;
    }

    public Object getElement() {
        return o;
    }

    public void setElement(Object o) {
        this.o = o;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    
    public void clear() {
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }
    
}
