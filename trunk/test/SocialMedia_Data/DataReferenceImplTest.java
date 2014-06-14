/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Data;

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
public class DataReferenceImplTest {
    
    public DataReferenceImplTest() {
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
     * Test of getID method, of class DataReferenceImpl.
     */
    @Test
    public void testGetID() throws Exception {
        System.out.println("getID");
        DataReferenceImpl instance = new DataReferenceImpl();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class DataReferenceImpl.
     */
    @Test
    public void testSetID() throws Exception {
        System.out.println("setID");
        int val = 0;
        DataReferenceImpl instance = new DataReferenceImpl();
        instance.setID(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreationDate method, of class DataReferenceImpl.
     */
    @Test
    public void testGetCreationDate() throws Exception {
        System.out.println("getCreationDate");
        DataReferenceImpl instance = new DataReferenceImpl();
        Date expResult = null;
        Date result = instance.getCreationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreationDate method, of class DataReferenceImpl.
     */
    @Test
    public void testSetCreationDate() throws Exception {
        System.out.println("setCreationDate");
        Date val = null;
        DataReferenceImpl instance = new DataReferenceImpl();
        instance.setCreationDate(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
