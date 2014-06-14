/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
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
public class BeitragTest {
    
    public BeitragTest() {
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
     * Test of getPinnwandID method, of class Beitrag.
     */
    @Test
    public void testGetPinnwandID() throws Exception {
        System.out.println("getPinnwandID");
        Beitrag instance = new BeitragImpl();
        int expResult = 0;
        int result = instance.getPinnwandID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPinnwandID method, of class Beitrag.
     */
    @Test
    public void testSetPinnwandID() throws Exception {
        System.out.println("setPinnwandID");
        int val = 0;
        Beitrag instance = new BeitragImpl();
        instance.setPinnwandID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBeitragKommentar method, of class Beitrag.
     */
    @Test
    public void testGetAllBeitragKommentar() throws Exception {
        System.out.println("getAllBeitragKommentar");
        SocialMediaLogicImpl verwaltung = null;
        Beitrag instance = new BeitragImpl();
        Vector<Kommentar> expResult = null;
        Vector<Kommentar> result = instance.getAllBeitragKommentar(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBeitragLikes method, of class Beitrag.
     */
    @Test
    public void testGetAllBeitragLikes() throws Exception {
        System.out.println("getAllBeitragLikes");
        SocialMediaLogicImpl verwaltung = null;
        Beitrag instance = new BeitragImpl();
        Vector<Like> expResult = null;
        Vector<Like> result = instance.getAllBeitragLikes(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BeitragImpl implements Beitrag {

        public int getPinnwandID() throws RemoteException {
            return 0;
        }

        public void setPinnwandID(int val) throws RemoteException {
        }

        public Vector<Kommentar> getAllBeitragKommentar(SocialMediaLogicImpl verwaltung) throws RemoteException {
            return null;
        }

        public Vector<Like> getAllBeitragLikes(SocialMediaLogicImpl verwaltung) throws RemoteException {
            return null;
        }
    }
    
}
