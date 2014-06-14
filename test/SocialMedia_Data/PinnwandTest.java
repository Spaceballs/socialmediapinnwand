/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Date;
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
public class PinnwandTest {
    
    public PinnwandTest() {
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
     * Test of getNutzerID method, of class Pinnwand.
     */
    @Test
    public void testGetNutzerID() throws Exception {
        System.out.println("getNutzerID");
        Pinnwand instance = new PinnwandImpl();
        int expResult = 0;
        int result = instance.getNutzerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNutzerID method, of class Pinnwand.
     */
    @Test
    public void testSetNutzerID() throws Exception {
        System.out.println("setNutzerID");
        int val = 0;
        Pinnwand instance = new PinnwandImpl();
        instance.setNutzerID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPinnwandBeitraege method, of class Pinnwand.
     */
    @Test
    public void testGetAllPinnwandBeitraege() throws Exception {
        System.out.println("getAllPinnwandBeitraege");
        SocialMediaLogicImpl verwaltung = null;
        Pinnwand instance = new PinnwandImpl();
        Vector<Beitrag> expResult = null;
        Vector<Beitrag> result = instance.getAllPinnwandBeitraege(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class Pinnwand.
     */
    @Test
    public void testGetOwner() throws Exception {
        System.out.println("getOwner");
        SocialMediaLogicImpl verwaltung = null;
        Pinnwand instance = new PinnwandImpl();
        Nutzer expResult = null;
        Nutzer result = instance.getOwner(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAbonnementsOfPinnwand method, of class Pinnwand.
     */
    @Test
    public void testGetAllAbonnementsOfPinnwand() throws Exception {
        System.out.println("getAllAbonnementsOfPinnwand");
        SocialMediaLogicImpl verwaltung = null;
        Pinnwand instance = new PinnwandImpl();
        Vector<Abonnement> expResult = null;
        Vector<Abonnement> result = instance.getAllAbonnementsOfPinnwand(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PinnwandImpl implements Pinnwand {

        public int getNutzerID() throws RemoteException {
            return 0;
        }

        public void setNutzerID(int val) throws RemoteException {
        }

        public Vector<Beitrag> getAllPinnwandBeitraege(SocialMediaLogicImpl verwaltung) throws RemoteException {
            return null;
        }

        public Nutzer getOwner(SocialMediaLogicImpl verwaltung) throws RemoteException {
            return null;
        }

        public Vector<Abonnement> getAllAbonnementsOfPinnwand(SocialMediaLogicImpl verwaltung) throws RemoteException {
            return null;
        }

        public Date getCreationDate() throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public int getID() throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void setCreationDate(Date val) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void setID(int val) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
