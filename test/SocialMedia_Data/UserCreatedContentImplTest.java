/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
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
public class UserCreatedContentImplTest {
    
    public UserCreatedContentImplTest() {
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
     * Test of getNutzerID method, of class UserCreatedContentImpl.
     */
    @Test
    public void testGetNutzerID() throws Exception {
        System.out.println("getNutzerID");
        UserCreatedContentImpl instance = new UserCreatedContentImpl();
        int expResult = 0;
        int result = instance.getNutzerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNutzerID method, of class UserCreatedContentImpl.
     */
    @Test
    public void testSetNutzerID() throws Exception {
        System.out.println("setNutzerID");
        int val = 0;
        UserCreatedContentImpl instance = new UserCreatedContentImpl();
        instance.setNutzerID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class UserCreatedContentImpl.
     */
    @Test
    public void testGetText() throws Exception {
        System.out.println("getText");
        UserCreatedContentImpl instance = new UserCreatedContentImpl();
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class UserCreatedContentImpl.
     */
    @Test
    public void testSetText() throws Exception {
        System.out.println("setText");
        String val = "";
        UserCreatedContentImpl instance = new UserCreatedContentImpl();
        instance.setText(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class UserCreatedContentImpl.
     */
    @Test
    public void testGetOwner() throws Exception {
        System.out.println("getOwner");
        SocialMediaLogicImpl verwaltung = null;
        UserCreatedContentImpl instance = new UserCreatedContentImpl();
        Nutzer expResult = null;
        Nutzer result = instance.getOwner(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
