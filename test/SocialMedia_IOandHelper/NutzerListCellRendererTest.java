/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

import java.awt.Component;
import javax.swing.JList;
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
public class NutzerListCellRendererTest {
    
    public NutzerListCellRendererTest() {
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
     * Test of getListCellRendererComponent method, of class NutzerListCellRenderer.
     */
    @Test
    public void testGetListCellRendererComponent() {
        System.out.println("getListCellRendererComponent");
        JList list = null;
        Object value = null;
        int index = 0;
        boolean isSelected = false;
        boolean cellHasFocus = false;
        NutzerListCellRenderer instance = new NutzerListCellRenderer();
        Component expResult = null;
        Component result = instance.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
