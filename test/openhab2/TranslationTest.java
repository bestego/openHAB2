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
public class TranslationTest {

    public TranslationTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        assertTrue("no methods to be tested", true);
    }

    /**
     * Test of toString method, of class Translation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Translation instance = new Translation("Translation");
        String expResult = "Translation";
        
        String result = instance.toString();
        
        assertEquals(expResult, result);
    }

}
