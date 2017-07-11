/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybubblesort;

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
public class BubbleSortTest {

    /**
     * Test of call method, of class BubbleSort.
     */
    @Test
    public void testCall() throws Exception {
        Object[] input = new Object[]{10, 7, 5, 2, 8};
        BubbleSort instance = new BubbleSort(input, new IntegerComparator());
        Object[] expResult = new Object[]{2, 5, 7, 8, 10};

        Object[] result = instance.call();

        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testCall_2() throws Exception {
        Object[] input = new Object[]{1, 2, 3};
        BubbleSort instance = new BubbleSort(input, new IntegerComparator());
        Object[] expResult = new Object[]{1, 2, 3};

        Object[] result = instance.call();

        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testCall_3() throws Exception {
        Object[] input = new Object[]{1};
        BubbleSort instance = new BubbleSort(input, new IntegerComparator());
        Object[] expResult = new Object[]{1};

        Object[] result = instance.call();

        assertArrayEquals(expResult, result);
    }

}
