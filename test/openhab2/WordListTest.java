/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erik
 */
public class WordListTest {

    public WordListTest() {
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
     * Test of indexOf method, of class WordList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        String regex = "t[a-z]+";
        WordList instance = new WordList(" one two three");
        int expResult = 1;

        int result = instance.indexOf(regex);

        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method, of class WordList.
     */
    @Test
    public void testIndexOfNoMatch() {
        System.out.println("indexOfNoMatch");
        String regex = "xyz";
        WordList instance = new WordList(" one two three");
        int expResult = -1;

        int result = instance.indexOf(regex);

        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class WordList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        WordList instance = new WordList(" one two three ");
        String expResult = "two";

        String result = instance.get(1);

        assertEquals(expResult, result);

    }

    /**
     * Test of size method, of class WordList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        WordList instance = new WordList(" one two three ");
        int expResult = 3;

        int result = instance.size();

        assertEquals(expResult, result);
    }

}
