/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybinarysearchtree;

import static java.lang.Math.max;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 *
 * @author felipemfp
 */
public class BSTree implements IBSTree {

    private int size;
    private Node root;

    public BSTree(Object k, Object o) {
        size = 1;
        root = new Node(k, o);
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
        if (this.hasLeftChild(n)) {
            h = this.height(this.leftChild(n));
        }
        if (this.hasRightChild(n)) {
            h = max(h, this.height(this.rightChild(n)));
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
        return this.nodes(this.root).iterator();
    }

    private Vector nodes(Node n) {
        Vector v = new Vector();
        v.add(n);
        if (this.hasLeftChild(n)) {
            v.addAll(this.nodes(this.leftChild(n)));
        }
        if (this.hasRightChild(n)) {
            v.addAll(this.nodes(this.rightChild(n)));
        }
        return v;
    }

    protected Object key(Node n) {
        return n.getKey();
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
    public boolean isInternal(Node n) {
        return (this.hasLeftChild(n) || this.hasRightChild(n));
    }

    @Override
    public boolean isExternal(Node n) {
        return (!this.hasLeftChild(n) && !this.hasRightChild(n));
    }

    @Override
    public boolean isRoot(Node n) {
        return (n == this.root);
    }

    @Override
    public int depth(Node n) {
        if (n == this.root) {
            return 0;
        }
        return 1 + this.depth(n.getParent());
    }

    @Override
    public Node leftChild(Node n) {
        return n.getLeftChild();
    }

    @Override
    public Node rightChild(Node n) {
        return n.getRightChild();
    }

    @Override
    public Node sibling(Node n) {
        if (this.rightChild(n.getParent()) == n) {
            return this.leftChild(n.getParent());
        }
        return this.rightChild(n.getParent());
    }

    @Override
    public boolean hasLeftChild(Node n) {
        return (this.leftChild(n) != null);
    }

    @Override
    public boolean hasRightChild(Node n) {
        return (this.rightChild(n) != null);
    }

    @Override
    public boolean hasSibling(Node n) {
        return (this.sibling(n) != null);
    }

    @Override
    public Node find(Object k) {
        return find(k, this.root());
    }

    private Node find(Object k, Node n) {
        if (this.isExternal(n)) {
            return n;
        }
        if ((int) this.key(n) > (int) k && this.hasLeftChild(n)) {
            return find(k, this.leftChild(n));
        } else if ((int) this.key(n) < (int) k && this.hasRightChild(n)) {
            return find(k, this.rightChild(n));
        }
        return n;
    }

    @Override
    public void insert(Object k, Object o) {
        Node p = this.find(k);

        if ((int) this.key(p) != (int) k) {
            Node n = new Node(k, o, p);
            if ((int) this.key(p) > (int) k) {
                p.setLeftChild(n);
            } else {
                p.setRightChild(n);
            }
            this.size++;
        }

    }

    @Override
    public Object remove(Object k) throws InvalidKeyException {
        Node n = this.find(k);

        if ((int) this.key(n) != (int) k) {
            throw new InvalidKeyException();
        }

        return this.remove(n);
    }

    private Object remove(Node n) {
        Object o = n.getElement();

        if (this.isInternal(n)) {
            Node m;

            if (this.hasRightChild(n)) {
                m = (Node) traverse(this.rightChild(n)).next();

                n.setKey(m.getKey());
                n.setElement(m.getElement());

                this.remove(m);
            } else {
                m = this.leftChild(n);
                m.setParent(this.parent(n));
                if (this.leftChild(n.getParent()) == n) {
                    n.getParent().setLeftChild(m);
                } else {
                    n.getParent().setRightChild(m);
                }
                n.clear();
                this.size--;
            }
        } else {
            if (this.leftChild(n.getParent()) == n) {
                n.getParent().setLeftChild(null);
            } else {
                n.getParent().setRightChild(null);
            }
            n.clear();
            this.size--;
        }

        return o;
    }

    public Iterator traverse() {
        return this.traverse(this.root);
    }

    public Iterator traverse(Node n) {
        Vector v = new Vector();
        this.traverse(n, v);
        return v.iterator();
    }

    private void traverse(Node n, Vector v) {
        if (this.hasLeftChild(n)) {
            traverse(this.leftChild(n), v);
        }
        v.add(n);
        if (this.hasRightChild(n)) {
            traverse(this.rightChild(n), v);
        }
    }
}
