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
public class UserCreatedContentTest {
    
    public UserCreatedContentTest() {
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
     * Test of getNutzerID method, of class UserCreatedContent.
     */
    @Test
    public void testGetNutzerID() throws Exception {
        System.out.println("getNutzerID");
        UserCreatedContent instance = new UserCreatedContentImpl();
        int expResult = 0;
        int result = instance.getNutzerID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getText method, of class UserCreatedContent.
     */
    @Test
    public void testGetText() throws Exception {
        System.out.println("getText");
        UserCreatedContent instance = new UserCreatedContentImpl();
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNutzerID method, of class UserCreatedContent.
     */
    @Test
    public void testSetNutzerID() throws Exception {
        System.out.println("setNutzerID");
        int val = 0;
        UserCreatedContent instance = new UserCreatedContentImpl();
        instance.setNutzerID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class UserCreatedContent.
     */
    @Test
    public void testSetText() throws Exception {
        System.out.println("setText");
        String val = "";
        UserCreatedContent instance = new UserCreatedContentImpl();
        instance.setText(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class UserCreatedContent.
     */
    @Test
    public void testGetOwner() throws Exception {
        System.out.println("getOwner");
        SocialMediaLogicImpl verwaltung = null;
        UserCreatedContent instance = new UserCreatedContentImpl();
        Nutzer expResult = null;
        Nutzer result = instance.getOwner(verwaltung);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class UserCreatedContentImpl implements UserCreatedContent {

        public int getNutzerID() throws RemoteException {
            return 0;
        }

        public String getText() throws RemoteException {
            return "";
        }

        public void setNutzerID(int val) throws RemoteException {
        }

        public void setText(String val) throws RemoteException {
        }

        public Nutzer getOwner(SocialMediaLogicImpl verwaltung) throws RemoteException {
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
