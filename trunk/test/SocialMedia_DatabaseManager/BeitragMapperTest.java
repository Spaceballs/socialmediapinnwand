/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import SocialMedia_Data.Beitrag;
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
public class BeitragMapperTest {
    
    public BeitragMapperTest() {
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
     * Test of beitragMapper method, of class BeitragMapper.
     */
    @Test
    public void testBeitragMapper() {
        System.out.println("beitragMapper");
        BeitragMapper expResult = null;
        BeitragMapper result = BeitragMapper.beitragMapper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class BeitragMapper.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Beitrag val = null;
        BeitragMapper instance = new BeitragMapper();
        Beitrag expResult = null;
        Beitrag result = instance.insert(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BeitragMapper.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Beitrag val = null;
        BeitragMapper instance = new BeitragMapper();
        Beitrag expResult = null;
        Beitrag result = instance.update(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BeitragMapper.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Beitrag val = null;
        BeitragMapper instance = new BeitragMapper();
        instance.delete(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class BeitragMapper.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        BeitragMapper instance = new BeitragMapper();
        Vector<Beitrag> expResult = null;
        Vector<Beitrag> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class BeitragMapper.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int val = 0;
        BeitragMapper instance = new BeitragMapper();
        Beitrag expResult = null;
        Beitrag result = instance.findByID(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
