/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import SocialMedia_Data.Pinnwand;
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
public class PinnwandMapperTest {
    
    public PinnwandMapperTest() {
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
     * Test of pinnwandMapper method, of class PinnwandMapper.
     */
    @Test
    public void testPinnwandMapper() {
        System.out.println("pinnwandMapper");
        PinnwandMapper expResult = null;
        PinnwandMapper result = PinnwandMapper.pinnwandMapper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class PinnwandMapper.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Pinnwand val = null;
        PinnwandMapper instance = new PinnwandMapper();
        Pinnwand expResult = null;
        Pinnwand result = instance.insert(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PinnwandMapper.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Pinnwand val = null;
        PinnwandMapper instance = new PinnwandMapper();
        Pinnwand expResult = null;
        Pinnwand result = instance.update(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PinnwandMapper.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Pinnwand val = null;
        PinnwandMapper instance = new PinnwandMapper();
        instance.delete(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class PinnwandMapper.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        PinnwandMapper instance = new PinnwandMapper();
        Vector<Pinnwand> expResult = null;
        Vector<Pinnwand> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class PinnwandMapper.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int val = 0;
        PinnwandMapper instance = new PinnwandMapper();
        Pinnwand expResult = null;
        Pinnwand result = instance.findByID(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
