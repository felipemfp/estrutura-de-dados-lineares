/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myskiplist;

/**
 *
 * @author felipemfp
 */
public class Node {

    private Object key;
    private Object value;
    private Node up;
    private Node down;
    private Node left;
    private Node right;

    public Node(Object key, Object value, Node up, Node down, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Object key) {
        this.key = key;
    }

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Node getUp() {
        return up;
    }

    public Node getDown() {
        return down;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        if (getKey().getClass() == PositiveInfinity.class) {
            return "(+inf)";
        } else if (getKey().getClass() == NegativeInfinity.class) {
            return "(-inf)";
        }
        return "(" + String.format("%02d", getKey()) + ")";
    }

}
