/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysequence;

/**
 *
 * @author felipe
 */
public class MySequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sequence seq = new Sequence();
        
        seq.insertFirst(10);
        seq.insertLast(20);
        seq.insertLast(30);        
        seq.insertAtRank(2, 25);
        seq.insertAtRank(2, 27);
        seq.replaceAtRank(2, 24);
        seq.insertFirst(5);  
        
        Node n = seq.atRank(4);
        seq.insertAfter(n, 27);
        seq.insertBefore(n.getNext(), 26);
        
        for (int i = 0; i < seq.size(); i++) {
            System.out.print("[");    
            System.out.print(i);
            System.out.print("] ");
            System.out.println(seq.elemAtRank(i));
        }
    }
    
}
