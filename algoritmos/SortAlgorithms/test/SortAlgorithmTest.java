/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Comparator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author felipe
 */
public class SortAlgorithmTest {

    SortAlgorithm algorithm;
    Object[] input = new Object[]{10, 7, 5, 2, 11};
    Object[] expResult = new Object[]{2, 5, 7, 10, 11};

    @Test
    public void testBubbleSort() {
        algorithm = new BubbleSort();

        Object[] result = algorithm.sort(input, new IntegerComparator());

        assertArrayEquals(expResult, result);
    }

    @Test
    public void testMergeSort() {
        algorithm = new MergeSort();

        Object[] result = algorithm.sort(input, new IntegerComparator());

        assertArrayEquals(expResult, result);
    }

    class IntegerComparator implements Comparator {

        @Override
        public int compare(Object t, Object t1) {
            return (int) t - (int) t1;
        }

    }
}
