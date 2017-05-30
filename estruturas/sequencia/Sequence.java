package mysequence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felipe
 */
public class Sequence implements ISequence {

    private Node nStart;
    private Node nEnd;
    private int size;

    public Sequence() {
        nStart = new Node();
        nEnd = new Node();
        size = 0;

        nStart.setNext(nEnd);
        nEnd.setPrev(nStart);
    }
    
    @Override
    public Node atRank(int r) {
        Node n;
        if (r <= size() / 2) {
            n = nStart.getNext();
            for (int i = 0; i < r; i++) {
                n = n.getNext();
            }
        } else {
            n = nEnd.getPrev();
            for (int i = 0; i < size() - r - 1; i++) {
                n = n.getPrev();
            }
        }
        return n;
    }

    @Override
    public int rankOf(Node n) {
        int r = 0;
        while (n.getPrev() != nStart) {
            n = n.getPrev();
            r++;
        }
        return r;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFirst(Node n) {
        return n.getPrev() == nStart;
    }

    @Override
    public boolean isLast(Node n) {
        return n.getNext() == nEnd;
    }

    @Override
    public Object first() {
        return nStart.getNext();
    }

    @Override
    public Object last() {
        return nEnd.getPrev();
    }

    @Override
    public Object before(Node n) {
        return n.getPrev();
    }

    @Override
    public Object after(Node n) {
        return n.getNext();
    }

    @Override
    public Object elemAtRank(int r) {
        return atRank(r).getElement();
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Node n = atRank(r);
        Object oOld = n.getElement();
        n.setElement(o);
        return oOld;
    }

    @Override
    public void replaceElement(Node n, Object o) {
        n.setElement(o);
    }

    @Override
    public void swapElements(Node n, Node q) {
        Object oAux = n.getElement();
        n.setElement(q.getElement());
        q.setElement(oAux);
    }

    @Override
    public void insertBefore(Node n, Object o) {
        Node nNew = new Node(o, n.getPrev(), n);
        n.getPrev().setNext(nNew);
        n.setPrev(nNew);
        size++;
    }

    @Override
    public void insertAfter(Node n, Object o) {
        Node nNew = new Node(o, n, n.getNext());
        n.getNext().setPrev(nNew);
        n.setNext(nNew);
        size++;
    }

    @Override
    public void insertFirst(Object o) {
        Node nNew = new Node(o, nStart, nStart.getNext());
        nStart.getNext().setPrev(nNew);
        nStart.setNext(nNew);
        size++;
    }

    @Override
    public void insertLast(Object o) {
        Node nNew = new Node(o, nEnd.getPrev(), nEnd);
        nEnd.getPrev().setNext(nNew);
        nEnd.setPrev(nNew);
        size++;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        Node n = atRank(r);
        insertBefore(n, o);
    }

    @Override
    public Object remove(Node n) {
        Object o = n.getElement();
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        n.setPrev(null);
        n.setNext(null);
        size--;
        return o;
    }

    @Override
    public Object removeAtRank(int r) {
        return remove(atRank(r));
    }

}
