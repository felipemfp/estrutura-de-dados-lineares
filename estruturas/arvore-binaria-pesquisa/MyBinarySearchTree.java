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
    public static void main(String[] args) throws InvalidKeyException {
        // TODO code application logic here
        
        BSTPrintable bst = new BSTPrintable(7, "Felipe Pontes");
        
        addAndPrint(bst, 5, "Karen Cristina");
        addAndPrint(bst, 3, "Francisco Bento");
        addAndPrint(bst, 4, "Beatriz Nascimento");
        addAndPrint(bst, 14, "Alguém");
        addAndPrint(bst, 15, "Mareana Graciano");
        addAndPrint(bst, 22, "Cecília Rayllana");
        addAndPrint(bst, 10, "Lana Raquel");
        addAndPrint(bst, 6, "Rebeca Gagliuffi");
        addAndPrint(bst, 23, "Paulo Trindade");
        addAndPrint(bst, 8, "Cesar Vagner");
        addAndPrint(bst, 12, "Deyvison Costa");
        
        removeAndPrint(bst, 14);        
        removeAndPrint(bst, 6);        
        removeAndPrint(bst, 7);
        
        addAndPrint(bst, 6, "Karla Viviane");
        
        removeAndPrint(bst, 5);
        removeAndPrint(bst, 8);
        removeAndPrint(bst, 6);
        removeAndPrint(bst, 15);
        removeAndPrint(bst, 22);
        addAndPrint(bst, 6, "Rebeca Gagliuffi");
        addAndPrint(bst, 22, "Cecília Rayllana");
    }
    
    private static void removeAndPrint(BSTPrintable bst, Object k) throws InvalidKeyException {
        String alguem = (String)bst.remove(k);
        System.out.println(alguem + " [" +k+ "] foi removido.");
        System.out.println(bst);
    }
    
    private static void addAndPrint(BSTPrintable bst, Object k, Object o) {
        bst.insert(k, o);
        System.out.println(o + " [" +k+ "] foi adicionado.");
        System.out.println(bst);
    }
    
}
