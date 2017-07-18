/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myskiplist;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author felipemfp
 */
public class SkipList {

    private class InnerList {

        private Node start;
        private Node end;

        public Node getStart() {
            return start;
        }

        public Node getEnd() {
            return end;
        }

        public InnerList(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    private Vector<InnerList> matrix;
    private Comparator comparator;
    private Random random;

    public SkipList() {
        this(new IntegerComparator());
    }

    public SkipList(Comparator c) {
        random = new Random();
        comparator = c;
        matrix = new Vector();
        addNewList();
    }

    private void addNewList() {
        InnerList list = new InnerList(
                new Node(new NegativeInfinity()),
                new Node(new PositiveInfinity())
        );

        list.getStart().setRight(list.getEnd());
        list.getEnd().setLeft(list.getStart());

        if (matrix.size() > 0) {
            matrix.lastElement().getStart().setUp(list.getStart());
            matrix.lastElement().getEnd().setUp(list.getEnd());

            list.getStart().setDown(matrix.lastElement().getStart());
            list.getEnd().setDown(matrix.lastElement().getEnd());
        }

        matrix.add(list);
    }

    public int getHeight() {
        return matrix.size();
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void insert(Object key, Object value) {
        int i = 0;
        while (random.nextInt(2) == 0) {
            i++;
        }

        if (i >= getHeight()) {
            int m = i - getHeight() + 1;
            for (int j = 0; j < m; j++) {
                addNewList();
            }
        }

        Node v[] = new Node[getHeight()];

        for (int j = getHeight() - 1; j >= 0; j--) {
            Node n = matrix.get(j).getStart();

            while (n != null && comparator.compare(n.getKey(), key) < 0) {
                v[j] = n;
                n = n.getRight();
            }
        }

        Node m[] = new Node[getHeight()];

        for (int j = 0; j < v.length; j++) {
            m[j] = new Node(key, value);

            if (v[j].getRight() != null) {
                v[j].getRight().setLeft(m[j]);
                m[j].setRight(v[j].getRight());
            }

            v[j].setRight(m[j]);
            m[j].setLeft(v[j]);

            if (j > 0) {
                m[j].setDown(m[j - 1]);
                m[j - 1].setUp(m[j]);
            }
        }

    }

    @Override
    public String toString() {
        String s = "";
        Vector x = new Vector();

        for (int j = 0; j < getHeight(); j++) {
            int i = 0;
            String l = "S[" +  String.format("%02d", j) + "] ";
            Node n = matrix.get(j).start;
            while (n != null) {
                if (j == 0) {
                    l += n.toString() + " ";
                    x.add(n.getKey());
                } else if (comparator.compare(n.getKey(), x.get(i)) == 0) {
                    l += n.toString() + " ";
                } else if (comparator.compare(n.getKey(), x.get(i)) > 0) {
                    if (n.getKey().getClass() == PositiveInfinity.class && i < x.size() - 1) {
                        for (int k = 0; k < x.size() - i - 1; k++) {
                            l+= "     ";
                        }
                            l += n.toString() + " ";
                    } else {
                        l += "     " + n.toString() + " ";
                        i++;
                    }
                } else {
                    l += n.toString() + "       ";
                    i++;
                }
                n = n.getRight();
                i++;
            }
            l += "\n";
            s = l + s;
        }
        return s;
    }
}
