/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytree;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author felipemfp
 */
public class Node {
    
    private Object o;
    private Node parent;
    private Vector children = new Vector();

    public Node(Object o) {
        this.o = o;
    }

    public Node(Object o, Node parent) {
        this.o = o;
        this.parent = parent;
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
    
    public void addChild(Node n) {
        this.children.add(n);
    }
    
    public void removeChild(Node n) {
        this.children.remove(n);
    }    
    
    public int childrenSize() {
        return this.children.size();
    }

    public Iterator children() {
        return this.children.iterator();
    }
    
    public void clear() {
        this.parent = null;
        this.children.clear();
    }
    
}
