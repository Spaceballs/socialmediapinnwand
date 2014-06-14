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
public class LikeTest {
    
    public LikeTest() {
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
     * Test of getBeitragID method, of class Like.
     */
    @Test
    public void testGetBeitragID() throws Exception {
        System.out.println("getBeitragID");
        Like instance = new LikeImpl();
        int expResult = 0;
        int result = instance.getBeitragID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBeitragID method, of class Like.
     */
    @Test
    public void testSetBeitragID() throws Exception {
        System.out.println("setBeitragID");
        int val = 0;
        Like instance = new LikeImpl();
        instance.setBeitragID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNutzerID method, of class Like.
     */
    @Test
    public void testGetNutzerID() throws Exception {
        System.out.println("getNutzerID");
        Like instance = new LikeImpl();
        int expResult = 0;
        int result = instance.getNutzerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNutzerID method, of class Like.
     */
    @Test
    public void testSetNutzerID() throws Exception {
        System.out.println("setNutzerID");
        int val = 0;
        Like instance = new LikeImpl();
        instance.setNutzerID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class Like.
     */
    @Test
    public void testGetOwner() throws Exception {
        System.out.println("getOwner");
        SocialMediaLogicImpl verwaltung = null;
        Like instance = new LikeImpl();
        Nutzer expResult = null;
        Nutzer result = instance.getOwner(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class LikeImpl implements Like {

        public int getBeitragID() throws RemoteException {
            return 0;
        }

        public void setBeitragID(int val) throws RemoteException {
        }

        public int getNutzerID() throws RemoteException {
            return 0;
        }

        public void setNutzerID(int val) throws RemoteException {
        }

        public Nutzer getOwner(SocialMediaLogicImpl verwaltung) throws RemoteException {
            return null;
        }
    }
    
}
