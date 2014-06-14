/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.util.Vector;
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
public class NutzerImplTest {
    
    public NutzerImplTest() {
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
     * Test of getName method, of class NutzerImpl.
     */
    @Test
    public void testGetName() throws Exception {
        System.out.println("getName");
        NutzerImpl instance = new NutzerImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class NutzerImpl.
     */
    @Test
    public void testSetName() throws Exception {
        System.out.println("setName");
        String val = "";
        NutzerImpl instance = new NutzerImpl();
        instance.setName(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class NutzerImpl.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        NutzerImpl instance = new NutzerImpl();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class NutzerImpl.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        String val = "";
        NutzerImpl instance = new NutzerImpl();
        instance.setPassword(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSurname method, of class NutzerImpl.
     */
    @Test
    public void testGetSurname() throws Exception {
        System.out.println("getSurname");
        NutzerImpl instance = new NutzerImpl();
        String expResult = "";
        String result = instance.getSurname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSurname method, of class NutzerImpl.
     */
    @Test
    public void testSetSurname() throws Exception {
        System.out.println("setSurname");
        String val = "";
        NutzerImpl instance = new NutzerImpl();
        instance.setSurname(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class NutzerImpl.
     */
    @Test
    public void testGetUsername() throws Exception {
        System.out.println("getUsername");
        NutzerImpl instance = new NutzerImpl();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class NutzerImpl.
     */
    @Test
    public void testSetUsername() throws Exception {
        System.out.println("setUsername");
        String val = "";
        NutzerImpl instance = new NutzerImpl();
        instance.setUsername(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNutzerPinnwand method, of class NutzerImpl.
     */
    @Test
    public void testGetNutzerPinnwand() throws Exception {
        System.out.println("getNutzerPinnwand");
        SocialMediaLogicImpl verwaltung = null;
        NutzerImpl instance = new NutzerImpl();
        Pinnwand expResult = null;
        Pinnwand result = instance.getNutzerPinnwand(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllNutzerAbonnement method, of class NutzerImpl.
     */
    @Test
    public void testGetAllNutzerAbonnement() throws Exception {
        System.out.println("getAllNutzerAbonnement");
        SocialMediaLogicImpl verwaltung = null;
        NutzerImpl instance = new NutzerImpl();
        Vector<Abonnement> expResult = null;
        Vector<Abonnement> result = instance.getAllNutzerAbonnement(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
