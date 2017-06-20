/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybinarysearchtree;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest-zaiqyn
 */
public class MyBinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BSTPrintable bst = new BSTPrintable(7, "Felipe Pontes");
        
        bst.insert( 5, "Karen Cristina");
        bst.insert( 3, "Francisco Bento");
        bst.insert( 4, "Beatriz Nascimento");
        bst.insert(14, "Alguém");
        bst.insert(15, "Mareana Graciano");
        bst.insert(22, "Cecília Rayllana");
        bst.insert(10, "Lana Raquel");
        bst.insert( 6, "Rebeca Gagliuffi");
        bst.insert(23, "Paulo Trindade");
        bst.insert(8, "Cesar Vagner");
        bst.insert(12, "Deyvison Costa");
        
        System.out.println(bst);
        
        try {
            String alguem = (String)bst.remove(14);
            System.out.println(alguem + " [" +14+ "] foi removido.");
            System.out.println(bst);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MyBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String alguem = (String)bst.remove(6);
            System.out.println(alguem + " [" +6+ "] foi removido.");
            System.out.println(bst);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MyBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String alguem = (String)bst.remove(7);
            System.out.println(alguem + " [" +7+ "] foi removido.");
            System.out.println(bst);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MyBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        bst.insert(6, "Karla Viviane");
        System.out.println(bst);
        
        try {
            String alguem = (String)bst.remove(5);
            System.out.println(alguem + " [" +5+ "] foi removido.");
            System.out.println(bst);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(MyBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
