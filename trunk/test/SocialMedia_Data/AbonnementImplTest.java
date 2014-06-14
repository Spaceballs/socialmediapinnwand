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
public class AbonnementImplTest {
    
    public AbonnementImplTest() {
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
     * Test of getNutzerID method, of class AbonnementImpl.
     */
    @Test
    public void testGetNutzerID() throws Exception {
        System.out.println("getNutzerID");
        AbonnementImpl instance = new AbonnementImpl();
        int expResult = 0;
        int result = instance.getNutzerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNutzerID method, of class AbonnementImpl.
     */
    @Test
    public void testSetNutzerID() throws Exception {
        System.out.println("setNutzerID");
        int val = 0;
        AbonnementImpl instance = new AbonnementImpl();
        instance.setNutzerID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPinnwandID method, of class AbonnementImpl.
     */
    @Test
    public void testGetPinnwandID() throws Exception {
        System.out.println("getPinnwandID");
        AbonnementImpl instance = new AbonnementImpl();
        int expResult = 0;
        int result = instance.getPinnwandID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPinnwandID method, of class AbonnementImpl.
     */
    @Test
    public void testSetPinnwandID() throws Exception {
        System.out.println("setPinnwandID");
        int val = 0;
        AbonnementImpl instance = new AbonnementImpl();
        instance.setPinnwandID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAbonnementPinnwand method, of class AbonnementImpl.
     */
    @Test
    public void testGetAbonnementPinnwand() throws Exception {
        System.out.println("getAbonnementPinnwand");
        SocialMediaLogicImpl verwaltung = null;
        AbonnementImpl instance = new AbonnementImpl();
        Pinnwand expResult = null;
        Pinnwand result = instance.getAbonnementPinnwand(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
