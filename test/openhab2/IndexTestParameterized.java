/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author erik
 */
@RunWith(Parameterized.class)
public class IndexTestParameterized {

    private String input;
    private List<Integer> output;

    public IndexTestParameterized(String input, List<Integer> output) {
        this.input = input;
        this.output = output;
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

    @Parameterized.Parameters
    public static Collection methodName() {
        return Arrays.asList(new Object[][]{
            {"[-1]",  Arrays.asList(new Integer[]{-1})},
            {"[-1,2]", Arrays.asList(new Integer[]{-1,2})},
        });
    }

    /**
     * Test of getIndices method, of class Index.
     */
    @Test
    public void testGetIndices() {
        System.out.println("getIndicesDouble");
        Index instance = new Index(input);
        List<Integer> expResult = output;
        //expResult.add(output);
        List<Integer> result = instance.getIndices();
        assertEquals(expResult, result);
    }
}

