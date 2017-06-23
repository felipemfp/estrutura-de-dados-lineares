/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybinarysearchtree;

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
    
    @Override
    public String toString() {
        int height = this.height() + 1;
        int max = (int) Math.pow(2, height);        
        
        Node n = this.root();
        int l = 0;
        Map<Integer, Vector> levels = new HashMap<Integer, Vector>();
        Vector curr = new Vector();        
        
        curr.add(n);
        levels.put(l, curr);

        l++;
        curr = new Vector();
        while (l <= height) {
            for (Iterator<Node> it = levels.get(l-1).iterator(); it.hasNext();) {
                n = it.next(); 
                if (n != null && n.getKey().getClass() != NotNode.class) {
                    if (this.hasLeftChild(n)) {
                        curr.add(this.leftChild(n));    
                    } else {
                        curr.add(null);
                    }
                    if (this.hasRightChild(n)) {
                        curr.add(this.rightChild(n));    
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
        int q = (max * 6) / v.size();
        
        String level = "";

        for (int i = 0; i < v.size(); i++) {
            float k = (q - 2) / 2;
            level += String.join("", Collections.nCopies((int)Math.floor(k), "-"));    
            Node n = (Node) v.get(i);
            if (n == null) {
                level += "[]";    
            } else if (n.getKey().getClass() == NotNode.class) {
                level += "--";
            } else {
                level += String.format("%02d", (int)this.key(n));
            }            
            level += String.join("", Collections.nCopies((int)Math.ceil(k), "-"));
        }
        
        return level + "\n";
    }
    
    private class NotNode { }    
}
