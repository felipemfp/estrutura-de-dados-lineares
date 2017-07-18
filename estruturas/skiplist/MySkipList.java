/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myskiplist;

/**
 *
 * @author felipemfp
 */
public class MySkipList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SkipList skip = new SkipList();
        skip.insert(15, "Felipe");
        skip.insert(25, "Felipe");
        skip.insert(7, "Felipe");
        System.out.println("\n" + skip);
    }
    
}
