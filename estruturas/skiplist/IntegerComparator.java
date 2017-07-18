/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myskiplist;

import java.util.Comparator;

/**
 *
 * @author felipemfp
 */
public class IntegerComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1.getClass() == PositiveInfinity.class && o1.getClass() == o2.getClass()) {
            return 0;
        } else if (o1.getClass() == NegativeInfinity.class && o1.getClass() == o2.getClass()) {
            return 0;
        } else if (o1.getClass() == PositiveInfinity.class || o2.getClass() == NegativeInfinity.class) {
            return 1;
        } else if (o1.getClass() == NegativeInfinity.class || o2.getClass() == PositiveInfinity.class) {
            return -1;
        }

        return (int) o1 - (int) o2;
    }

}
