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
public class IntegerComparatorTest {

    /**
     * Test of compare method, of class IntegerComparator.
     */
    @Test
    public void testCompareLower() {
        Object t = 25;
        Object t1 = 30;
        IntegerComparator instance = new IntegerComparator();
        
        int result = instance.compare(t, t1);
        
        assertTrue(result < 0);
    }
    
    @Test
    public void testCompareEquals() {
        Object t = 30;
        Object t1 = 30;
        IntegerComparator instance = new IntegerComparator();
        
        int result = instance.compare(t, t1);
        
        assertTrue(result == 0);
    }
    
    @Test
    public void testCompareBigger() {
        Object t = 35;
        Object t1 = 30;
        IntegerComparator instance = new IntegerComparator();
        
        int result = instance.compare(t, t1);
        
        assertTrue(result > 0);
    }
    
}
