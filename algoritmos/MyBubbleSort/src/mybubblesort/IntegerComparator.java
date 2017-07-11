/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybubblesort;

import java.util.Comparator;

/**
 *
 * @author felipe
 */
public class IntegerComparator implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        return (int) t - (int) t1;
    }

}
