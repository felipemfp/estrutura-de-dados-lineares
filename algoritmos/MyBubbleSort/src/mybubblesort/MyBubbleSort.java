/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybubblesort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author felipe
 */
public class MyBubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Object[] a = new Object[] {10, 7, 5, 2, 8};
        System.out.println(Arrays.toString(a));
        a = new BubbleSort(a, new IntegerComparator()).call();        
        System.out.println(Arrays.toString(a));
        
    }
    
    public static class IntegerComparator implements Comparator {

        @Override
        public int compare(Object t, Object t1) {
            return (int)t - (int)t1;
        }
        
    }
    
}
