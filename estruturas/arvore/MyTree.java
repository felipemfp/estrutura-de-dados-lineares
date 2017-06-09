/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytree;

import java.util.Iterator;

/**
 *
 * @author guest-ruyqrj
 */
public class MyTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        
        Tree t = new Tree(i++);
        
        t.addChild(t.root(), i++);
        t.addChild(t.root(), i++);
        
        for (Iterator<Node> it = t.children(t.root()); it.hasNext();) {
            Node n = it.next();
            t.addChild(n, i++);
            t.addChild(n, i++);
        }
        
        System.out.println("Height: " + t.height());
        System.out.println("Nodes: ");
        for (Iterator<Node> it = t.nodes(); it.hasNext();) {
            System.out.print(it.next().getElement() + " ");
        }
        System.out.println("\nElements: ");
        for (Iterator<Integer> it = t.elements(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println("");
    }
    
}
