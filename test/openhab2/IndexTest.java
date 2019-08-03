/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erik
 */
public class IndexTest {

    public IndexTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIndices method, of class Index.
     */
    @Test
    public void testGetIndices() {
        System.out.println("getIndicesDouble");
        Index instance = new Index("[-1,2]");
        List<Integer> expResult = new ArrayList<>();
        expResult.add(-1);
        expResult.add(2);
        
        List<Integer> result = instance.getIndices();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getIndices method, of class Index.
     */
    @Test
    public void testGetIndicesSingle() {
        System.out.println("getIndicesSingle");
        Index instance = new Index(" [3]");
        List<Integer> expResult = new ArrayList<>();
        expResult.add(3);
        
        List<Integer> result = instance.getIndices();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of getIndices method, of class Index.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testGetIndicesMissingBracket() {
        System.out.println("getIndicesMissingBracket");
        Index instance = new Index("3");
        
        List<Integer> result = instance.getIndices();
    }

}
