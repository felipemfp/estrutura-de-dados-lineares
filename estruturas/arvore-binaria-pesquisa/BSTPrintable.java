/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybinarysearchtree;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author felipe
 */
public class BSTPrintable extends BSTree {

    public BSTPrintable(Object k, Object o) {
        super(k, o);
    }

    private BSTPrintable prepareToString() {
        int n = 0;
        
        Vector nodes = new Vector();
        Iterator iter = this.traverse();
        
        while (iter.hasNext())
            nodes.add(iter.next());

        int l = 0;
        int r = nodes.size() - 1;
        int m = (int) (r - l) / 2;

        Node tmp = (Node) nodes.get(m);
        BSTPrintable bst = new BSTPrintable(tmp.getKey(), tmp.getElement());
        nodes.set(m, null);

        insertToTree(bst, nodes, l, m - 1);
        insertToTree(bst, nodes, m + 1, r);

        return bst;
    }

    private void insertToTree(BSTPrintable bst, Vector nodes, int l, int r) {
        int m = (int) (l + r) / 2;
        Node n = (Node) nodes.get(m);
        if (n != null) {
            bst.insert(n.getKey(), n.getElement());
        }        
        nodes.set(m, null);
        if (l < m) {
            insertToTree(bst, nodes, l, m - 1);
        }
        if (r > m) {
            insertToTree(bst, nodes, m + 1, r);    
        }
    }
    
    @Override
    public String toString() {
        return this.toString(false);
    }
    
    public String toString(boolean original) {
        BSTPrintable bst = original ? this : this.prepareToString();

        int height = bst.height() + 1;
        int max = (int) Math.pow(2, height);

        Node n = bst.root();
        int l = 0;
        Map<Integer, Vector> levels = new HashMap<Integer, Vector>();
        Vector curr = new Vector();

        curr.add(n);
        levels.put(l, curr);

        l++;
        curr = new Vector();
        while (l <= height) {
            for (Iterator<Node> it = levels.get(l - 1).iterator(); it.hasNext();) {
                n = it.next();
                if (n != null && n.getKey().getClass() != NotNode.class) {
                    if (bst.hasLeftChild(n)) {
                        curr.add(bst.leftChild(n));
                    } else {
                        curr.add(null);
                    }
                    if (bst.hasRightChild(n)) {
                        curr.add(bst.rightChild(n));
                    } else {
                        curr.add(null);
                    }
                } else {
                    curr.add(new Node(new NotNode(), new NotNode()));
                    curr.add(new Node(new NotNode(), new NotNode()));
                }
            }
            levels.put(l, curr);
            l++;
            curr = new Vector();
        }

        String r = "";

        for (int i = 0; i <= height; i++) {
            r += this.levelToString(levels.get(i), i, max);
        }

        return r;
    }

    public String levelToString(Vector v, int l, int max) {
        int c = 0;
        int q = (max * 4) / v.size();

        String level = "";

        for (int i = 0; i < v.size(); i++) {
            float k = (q - 2) / 2;
            level += String.join("", Collections.nCopies((int) Math.floor(k), "-"));
            Node n = (Node) v.get(i);
            if (n == null) {
                level += "[]";
            } else if (n.getKey().getClass() == NotNode.class) {
                level += "--";
            } else {
                level += String.format("%02d", (int) this.key(n));
            }
            level += String.join("", Collections.nCopies((int) Math.ceil(k), "-"));
        }

        return level + "\n";
    }

    private class NotNode {
    }
}
