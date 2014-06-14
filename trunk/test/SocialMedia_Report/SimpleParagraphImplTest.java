/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastian Fink
 */
public class SimpleParagraphImplTest {
    
    public SimpleParagraphImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getText method, of class SimpleParagraphImpl.
     */
    @Test
    public void testGetText() throws Exception {
        System.out.println("getText");
        SimpleParagraphImpl instance = null;
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class SimpleParagraphImpl.
     */
    @Test
    public void testSetText() throws Exception {
        System.out.println("setText");
        String val = "";
        SimpleParagraphImpl instance = null;
        instance.setText(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStrings method, of class SimpleParagraphImpl.
     */
    @Test
    public void testToStrings() throws Exception {
        System.out.println("toStrings");
        SimpleParagraphImpl instance = null;
        String expResult = "";
        String result = instance.toStrings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
