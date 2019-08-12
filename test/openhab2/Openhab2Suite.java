/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openhab2;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author erik
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({openhab2.WordListTest.class, openhab2.RulesTest.class, openhab2.RuleTest.class, openhab2.TranslationTest.class, openhab2.TranslatorTest.class, openhab2.IndexTest.class, openhab2.AliasTest.class, openhab2.IndexParameterizedTest.class})
public class Openhab2Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
