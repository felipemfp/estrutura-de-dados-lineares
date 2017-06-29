/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhashtable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipemfp
 */
public class MyHashtable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hashtable h = new Hashtable();
        
        try {
            h.insertIElement(18, "Ross");
            h.insertIElement(41, "Mônica");
            h.insertIElement(22, "Chandler");
            h.insertIElement(44, "Joey");
            h.insertIElement(59, "Rachel");
            h.insertIElement(32, "Phoebe");
            h.insertIElement(31, "Other");
            h.insertIElement(73, "Another");
        } catch (FullTableException ex) {
            Logger.getLogger(MyHashtable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(h);
    }
    
}
