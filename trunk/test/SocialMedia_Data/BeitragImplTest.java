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
public class BeitragImplTest {
    
    public BeitragImplTest() {
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
     * Test of getPinnwandID method, of class BeitragImpl.
     */
    @Test
    public void testGetPinnwandID() throws Exception {
        System.out.println("getPinnwandID");
        BeitragImpl instance = new BeitragImpl();
        int expResult = 0;
        int result = instance.getPinnwandID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPinnwandID method, of class BeitragImpl.
     */
    @Test
    public void testSetPinnwandID() throws Exception {
        System.out.println("setPinnwandID");
        int val = 0;
        BeitragImpl instance = new BeitragImpl();
        instance.setPinnwandID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBeitragKommentar method, of class BeitragImpl.
     */
    @Test
    public void testGetAllBeitragKommentar() throws Exception {
        System.out.println("getAllBeitragKommentar");
        SocialMediaLogicImpl verwaltung = null;
        BeitragImpl instance = new BeitragImpl();
        Vector<Kommentar> expResult = null;
        Vector<Kommentar> result = instance.getAllBeitragKommentar(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBeitragLikes method, of class BeitragImpl.
     */
    @Test
    public void testGetAllBeitragLikes() throws Exception {
        System.out.println("getAllBeitragLikes");
        SocialMediaLogicImpl verwaltung = null;
        BeitragImpl instance = new BeitragImpl();
        Vector<Like> expResult = null;
        Vector<Like> result = instance.getAllBeitragLikes(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
