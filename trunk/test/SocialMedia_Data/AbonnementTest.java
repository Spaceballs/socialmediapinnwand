/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
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
public class AbonnementTest {
    
    public AbonnementTest() {
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
     * Test of getPinnwandID method, of class Abonnement.
     */
    @Test
    public void testGetPinnwandID() throws Exception {
        System.out.println("getPinnwandID");
        Abonnement instance = new AbonnementImpl();
        int expResult = 0;
        int result = instance.getPinnwandID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPinnwandID method, of class Abonnement.
     */
    @Test
    public void testSetPinnwandID() throws Exception {
        System.out.println("setPinnwandID");
        int val = 0;
        Abonnement instance = new AbonnementImpl();
        instance.setPinnwandID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNutzerID method, of class Abonnement.
     */
    @Test
    public void testGetNutzerID() throws Exception {
        System.out.println("getNutzerID");
        Abonnement instance = new AbonnementImpl();
        int expResult = 0;
        int result = instance.getNutzerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNutzerID method, of class Abonnement.
     */
    @Test
    public void testSetNutzerID() throws Exception {
        System.out.println("setNutzerID");
        int val = 0;
        Abonnement instance = new AbonnementImpl();
        instance.setNutzerID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAbonnementPinnwand method, of class Abonnement.
     */
    @Test
    public void testGetAbonnementPinnwand() throws Exception {
        System.out.println("getAbonnementPinnwand");
        SocialMediaLogicImpl verwaltung = null;
        Abonnement instance = new AbonnementImpl();
        Pinnwand expResult = null;
        Pinnwand result = instance.getAbonnementPinnwand(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbonnementImpl implements Abonnement {

        public int getPinnwandID() throws RemoteException {
            return 0;
        }

        public void setPinnwandID(int val) throws RemoteException {
        }

        public int getNutzerID() throws RemoteException {
            return 0;
        }

        public void setNutzerID(int val) throws RemoteException {
        }

        public Pinnwand getAbonnementPinnwand(SocialMediaLogicImpl verwaltung) throws RemoteException {
            return null;
        }
    }
    
}
