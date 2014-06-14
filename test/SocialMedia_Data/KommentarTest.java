/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

import SocialMedia_Logic.SocialMediaLogicImpl;
import java.rmi.RemoteException;
import java.util.Date;
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
public class KommentarTest {
    
    public KommentarTest() {
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
     * Test of getBeitragID method, of class Kommentar.
     */
    @Test
    public void testGetBeitragID() throws Exception {
        System.out.println("getBeitragID");
        Kommentar instance = new KommentarImpl();
        int expResult = 0;
        int result = instance.getBeitragID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBeitragID method, of class Kommentar.
     */
    @Test
    public void testSetBeitragID() throws Exception {
        System.out.println("setBeitragID");
        int val = 0;
        Kommentar instance = new KommentarImpl();
        instance.setBeitragID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class KommentarImpl implements Kommentar {

        public int getBeitragID() throws RemoteException {
            return 0;
        }

        public void setBeitragID(int val) throws RemoteException {
        }

        public int getNutzerID() throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public String getText() throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void setNutzerID(int val) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void setText(String val) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public Nutzer getOwner(SocialMediaLogicImpl verwaltung) throws RemoteException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
