/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

import javax.swing.JComponent;
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
public class FormattedTextFieldVerifierTest {
    
    public FormattedTextFieldVerifierTest() {
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
     * Test of verify method, of class FormattedTextFieldVerifier.
     */
    @Test
    public void testVerify() {
        System.out.println("verify");
        JComponent input = null;
        FormattedTextFieldVerifier instance = new FormattedTextFieldVerifier();
        boolean expResult = false;
        boolean result = instance.verify(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shouldYieldFocus method, of class FormattedTextFieldVerifier.
     */
    @Test
    public void testShouldYieldFocus() {
        System.out.println("shouldYieldFocus");
        JComponent input = null;
        FormattedTextFieldVerifier instance = new FormattedTextFieldVerifier();
        boolean expResult = false;
        boolean result = instance.shouldYieldFocus(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
