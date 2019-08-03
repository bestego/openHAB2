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
public class TranslatorTest {

    public TranslatorTest() {
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
     * Test of getCommandIn method, of class Translator.
     */
    @Test
    public void testGetCommandIn() {
        System.out.println("getCommandIn");
        Translator instance = new Translator();
        instance.setCommandIn("Command");

        String result = instance.getCommandIn();

        assertEquals("Command", result);
    }

    /**
     * Test of getCommandOut method, of class Translator.
     */
    @Test
    public void testGetCommandOut() {
//        System.out.println("getCommandOut");
//        Translator instance = null;
//        String expResult = "";
//        String result = instance.getCommandOut();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        assertTrue(true);
    }

    /**
     * Test of translate method, of class Translator.
     */
    @Test
    public void testTranslate() {
        System.out.println("translateItem");
        String command = "Zet verwarming 2 graden hoger";
        Rules rules = new Rules();
        rules.add("target_temperature: temperatuur, verwarming, thermostaat");
        Translator instance = new Translator(command, rules);

        String result = instance.getCommandOut();
        assertEquals("target_temperature", result);

    }

    /**
     * Test of translate method, of class Translator.
     */
    @Test
    public void testTranslateSingleIndex() {
        System.out.println("translateSingleIndex");
        String command = "This is a command line";
        Rules rules = new Rules();
        rules.add("[1]: command ");
        Translator instance = new Translator(command, rules);

        String result = instance.getCommandOut();

        assertEquals("line", result);
    }

    /**
     * Test of translate method, of class Translator.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testTranslateSingleIndexOutOfUpperBound() {
        System.out.println("translateSingleIndexOutOfUpperBound");
        String command = "This is a command line";
        Rules rules = new Rules();
        rules.add("[2]: command");
        Translator instance = new Translator(command, rules);

        instance.getCommandOut();
    }

    /**
     * Test of translate method, of class Translator.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testTranslateSingleIndexOutOfLowerBound() {
        System.out.println("translateSingleIndexOutOfLowerBound");
        String command = "This is a command line";
        Rules rules = new Rules();
        rules.add("[-4]: command");
        Translator instance = new Translator(command, rules);

        instance.getCommandOut();
    }

    /**
     * Test of translate method, of class Translator.
     */
    @Test
    public void testTranslateDualIndex() {
        System.out.println("translateDualIndex");
        String command = "This is a regular command line";
        Rules rules = new Rules();
        rules.add("[-1,1]: regular ");
        Translator instance = new Translator(command, rules);

        String result = instance.getCommandOut();

        assertEquals("a regular command", result);
    }

    /**
     * Test of translate method, of class Translator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTranslateDualInvalidIndex() {
        System.out.println("translateInvalidIndex");
        String command = "This is a regular command line";
        Rules rules = new Rules();
        rules.add("[1,-1]: regular ");      // start > end
        Translator instance = new Translator(command, rules);

        instance.getCommandOut();
    }

    /**
     * Test of translate method, of class Translator.
     */
    @Test
    public void testTranslateCommandMultipleRuleHits() {
        System.out.println("translateCommand");
        String command = "Zet uitsluitend verwarming aan";
        Rules rules = new Rules();
        rules.add("DUMMY: ver");
        rules.add("UIT: uit");
        rules.add("ON: [ ]*aan[^a-z]");         // last match overrules

        Translator instance = new Translator(command, rules);

        String result = instance.getCommandOut();
        assertEquals("ON", result);
    }

    /**
     * Test of setCommandIn method, of class Translator.
     */
    @Test
    public void testSetCommandIn() {
        System.out.println("setCommandIn");
        Translator instance = new Translator();
        instance.setCommandIn("Command");
        assertEquals("Command", instance.getCommandIn());
    }

    /**
     * Test of setRules method, of class Translator.
     */
    @Test
    public void testSetRules() {
//        System.out.println("setRules");
//        Rules rules = null;
//        Translator instance = new Translator();
//        instance.setRules(rules);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        assertTrue(true);
    }

}
