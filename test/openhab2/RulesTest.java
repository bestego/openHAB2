/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author erik
 */
public class RulesTest {

    
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    

    public RulesTest() {

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
     * Test of add method, of class Rules.
     */
    @Test
    public void testAddSingleAlias() {
        System.out.println("testAddSingleAlias");
        String line = "fanStatus: afzuiging";
        String[] fields = line.split(":");
        String translation = fields[0].trim();
        fields = fields[1].split(",");
        String alias = fields[0].trim();
        Rules instance = new Rules();

        instance.add(line);

        assertEquals(translation, instance.get(new Alias(alias)).toString()); // depends on get()
    }

    /**
     * Test of add method, of class Rules.
     */
    @Test
    public void testAddSingleAliasTrailingSpaces() {
        System.out.println("testAddSingleAliasTrailingSpaces");
        String line = " fanStatus : afzuiging ";
        String[] fields = line.split(":");
        String translation = fields[0].trim();
        fields = fields[1].split(",");
        String alias = fields[0].trim();
        Rules instance = new Rules();

        instance.add(line);

        assertEquals(translation, instance.get(new Alias(alias)).toString()); // depends on get()
    }

    /**
     * Test of add method, of class Rules.
     */
    @Test
    public void testAdd() {
        System.out.println("testAddMultipleAliases");
        String line = "fanStatus: afzuiging, ventilatie, verwarming";
        String[] fields = line.split(":");
        String translation = fields[0].trim();
        fields = fields[1].split(",");
        String alias = fields[1].trim();
        Rules instance = new Rules();

        instance.add(line);

        assertEquals(translation, instance.get(new Alias(alias)).toString());  // depends on get() method
    }
    
    /**
     * Test of add method, of class Rules.
     */
    @Test
    public void testAddEmptyLine() {
        System.out.println("testAddEmptyLine");
        String line = "";
        Rules instance = new Rules();

        instance.add(line);

        assertEquals(0, instance.getAliases().size());  // depends on get() method
    }
    
     /**
     * Test of add method, of class Rules.
     */
    @Test
    public void testAddBlankLine() {
        System.out.println("testAddBlankLine");
        String line = "  ";
        Rules instance = new Rules();

        instance.add(line);

        assertEquals(0, instance.getAliases().size());  // depends on get() method
    }
    
         /**
     * Test of add method, of class Rules.
     */
    @Test
    public void testAddCommentLine() {
        System.out.println("testAddCommentLine");
        String line = "  #";
        Rules instance = new Rules();

        instance.add(line);

        assertEquals(0, instance.getAliases().size());  // depends on get() method
    }
    
    /**
     * Test of add method, of class Rules.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testAddInvalidLine() {
        System.out.println("testAddInvalidLine");
        String line = "fanStatus afzuiging, ventilatie, verwarming";
        Rules instance = new Rules();
        instance.add(line);
    }

    
    /**
     * Test of loadFile method, of class Rules.
     */
    @Test
    public void testLoadFile() throws IOException {
        System.out.println("loadFile");
        // create file to be loaded
        File file = folder.newFile();
        Writer fw = new FileWriter(file);
        fw.write("x: a, b, c \n");
        fw.write("y: d \n");
        fw.write("z: e, f \n");
        fw.close();
        Rules instance = new Rules();
        
        instance.loadFile(file.toPath());

        assertEquals(6,instance.getAliases().size());
    }

    /**
     * Test of get method, of class Rules.
     */
    @Test
    public void testGet() {
        System.out.println("getMachingAlias");
        Rules instance = new Rules();
        instance.put(new Alias("a1"), new Translation("t1"));
        instance.put(new Alias("a2"), new Translation("t2"));
        instance.put(new Alias("a3"), new Translation("t3"));
        String expResult = "t2";

        String result = instance.get(new Alias("a2")).toString();

        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class Rules.
     */
    @Test
    public void testGetNoMatchingAlias() {
        System.out.println("getNoMachingAlias");
        Rules instance = new Rules();
        instance.put(new Alias("a1"), new Translation("t1"));
        instance.put(new Alias("a2"), new Translation("t2"));
        instance.put(new Alias("a3"), new Translation("t3"));
        Translation expResult = null;

        Translation result = instance.get(new Alias("b"));

        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class Rules.
     */
    @Test
    public void testGetNoRules() {
        System.out.println("getNoRules");
        Rules instance = new Rules();
        Translation expResult = null;

        Translation result = instance.get(new Alias("alias"));

        assertEquals(expResult, result);
    }

    /**
     * Test of loadLines method, of class Rules.
     */
    @Test
    public void testLoadLines() {
        System.out.println("loadLines");
        String[] sa = {"x: a,b,c", "y: d", "z: e,f"};
        Stream<String> lines = Arrays.asList(sa).stream();
        Rules instance = new Rules();
        int expResult = 6;

        instance.loadLines(lines);

        int result = instance.getAliases().size();
        assertEquals(expResult, result); // depends on getMap
    }

    /**
     * Test of put method, of class Rules.
     */
    @Test
    public void testPut() {
        System.out.println("putUniqueEntry");       // ToDo: add put DuplicateEntry
        Alias alias = new Alias("a1");
        Translation translation = new Translation("t1");
        Rules instance = new Rules();

        instance.put(alias, translation);

        assertEquals(translation, instance.get(alias));
    }

    /**
     * Test of put method, of class Rules.
     */
    @Test(expected=IllegalArgumentException.class )
    public void testPutDuplicateAlias() {
        System.out.println("putDuplicateAlias");       // ToDo: add put DuplicateEntry
        Rules instance = new Rules();
        instance.put(new Alias("aa"), new Translation("t1"));
        instance.put(new Alias("AA"), new Translation("t2"));
    }

    /**
     * Test of getAliases method, of class Rules.
     */
    @Test
    public void testGetAliases() {
        System.out.println("getAliases");
        Rules instance = new Rules();
        instance.put(new Alias("a1"), new Translation("t1"));
        instance.put(new Alias("a2"), new Translation("t2"));
        instance.put(new Alias("a3"), new Translation("t3"));    
        Set<Alias> expResult = new HashSet<>();
        expResult.add(new Alias("a1"));
        expResult.add(new Alias("a2"));
        expResult.add(new Alias("a3"));
        Set<Alias> result = instance.getAliases();
        
        assertEquals(expResult, result);
    }

}
