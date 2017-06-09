/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytree;

import static java.lang.Math.max;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author felipemfp
 */
public class Tree implements ITree {
    
    private int size;
    private Node root;

    public Tree(Object o) {
        size = 1;
        root = new Node(o);       
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int height() {
        return this.height(this.root);
    }
    
    private int height(Node n) {        
        if (this.isExternal(n)) {
            return 0;
        }
        int h = 0;
        for (Iterator<Node> it = this.children(n); it.hasNext();) {
            h = max(h, this.height(it.next()));
        }
        return 1 + h;
    }

    @Override
    public Iterator elements() {
        Vector v = new Vector();
        for (Iterator<Node> it = this.nodes(); it.hasNext();) {
            v.add(it.next().getElement());
        }
        return v.iterator();
    }

    @Override
    public Iterator nodes() {
        Vector v = new Vector();
        v.addAll(this.nodes(this.root));
        return v.iterator();
    }
    
    private Vector nodes(Node n) {
        Vector v = new Vector();
        v.add(n);
        for (Iterator<Node> it = this.children(n); it.hasNext();) {            
            v.addAll(this.nodes(it.next()));
        }
        return v;
    }

    @Override
    public Node root() {
        return this.root;
    }

    @Override
    public Node parent(Node n) {
        return n.getParent();
    }

    @Override
    public Iterator children(Node n) {
        return n.children();
    }

    @Override
    public boolean isInternal(Node n) {
        return (n.childrenSize() > 0);
    }

    @Override
    public boolean isExternal(Node n) {
        return (n.childrenSize() == 0);
    }

    @Override
    public boolean isRoot(Node n) {
        return (n == this.root);
    }

    @Override
    public int depth(Node n) {
        if (n == this.root)
            return 0;
        return 1 + this.depth(n.getParent());
    }

    @Override
    public Object replace(Node n, Object o) {
        Object oOld = n.getElement();
        n.setElement(o);
        return oOld;
    }

    @Override
    public Object remove(Node n) throws InvalidNodeException {
        Node parent = n.getParent();    
        Object o = n.getElement();
        
        if (parent != null && this.isExternal(n)) {
            parent.removeChild(n);
            n.clear();
        } else {
            throw new InvalidNodeException();
        }        
        
        this.size--;
        return o;        
    }

    @Override
    public void addChild(Node n, Object o) {
        Node m = new Node(o, n);
        n.addChild(m);
        this.size++;
    }

    @Override
    public void swap(Node n, Node m) {
        Node p = n.getParent();
        
        n.getParent().removeChild(n);
        m.getParent().removeChild(m);
        
        n.setParent(m.getParent());
        m.setParent(p);
        
        n.getParent().addChild(n);
        m.getParent().addChild(m);
    }
    
}
