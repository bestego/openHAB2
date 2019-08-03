/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author erik
 */
public class AliasTest {

    public AliasTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class Alias.
     */
    @Test
    public void testEquals() {
        System.out.println("equalsTrueForIdenticalCase");
        Object obj = new Alias("ABC");
        Alias instance = new Alias("ABC");
        assertTrue(instance.equals(obj));
    }

    /**
     * Test of hashCode method, of class Alias.
     */
    @Test
    public void identicalHashCodeForIdenticalCase() {
        System.out.println("identicalHashCodeForIdenticalCase");
        Alias instance = new Alias("abc");
        int expResult = "abc".hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Alias.
     */
    @Test
    public void testHashCode() {
        System.out.println("equalsTrueForUpperLowerCase");
        Object obj = new Alias("abc");
        Alias instance = new Alias("ABC");
        assertTrue(instance.equals(obj));
    }

    /**
     * Test of hashCode method, of class Alias.
     */
    @Test
    public void identicalHashCodeForUpperLowerCase() {
        System.out.println("identicalHashCodeForUpperLowerCase");
        Alias instance = new Alias("ABC");
        int expResult = "abc".hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Alias.
     */
    @Test
    public void equalsTrueForLeadingTrailingSpaces() {
        System.out.println("equalsTrueForLeadingTrailingSpaces");
        Object obj = new Alias(" abc \t");
        Alias instance = new Alias("abc");
        assertTrue(instance.equals(obj));
    }
    
       /**
     * Test of hashCode method, of class Alias.
     */
    @Test
    public void identicalHashCodeForLeadingTrailingSpaces() {
        System.out.println("identicalHashCodeForLeadingTrailingSpaces");
        Alias instance = new Alias(" abc \t");
        int expResult = "abc".hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Alias.
     */
    @Test
    public void equalsFalseForDifferentValues() {
        System.out.println("equalsFalseForDifferentValues");
        Object obj = new Alias("CBA");
        Alias instance = new Alias("ABC");
        assertFalse(instance.equals(obj));
    }

    /**
     * Test of hashCode method, of class Alias.
     */
    @Test
    public void differentHashCodeForDifferentValues() {
        System.out.println("differentHashCodeForDifferentValues");
        Alias instance = new Alias("cba");
        int expResult = "abc".hashCode();
        int result = instance.hashCode();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Alias.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Alias instance = new Alias("alias");
        String expResult = "alias";
        
        String result = instance.toString();
        
        assertEquals(expResult, result);
    }

}
