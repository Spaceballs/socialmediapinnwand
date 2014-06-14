/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import SocialMedia_Data.Nutzer;
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
public class NutzerMapperTest {
    
    public NutzerMapperTest() {
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
     * Test of nutzerMapper method, of class NutzerMapper.
     */
    @Test
    public void testNutzerMapper() {
        System.out.println("nutzerMapper");
        NutzerMapper expResult = null;
        NutzerMapper result = NutzerMapper.nutzerMapper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class NutzerMapper.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Nutzer val = null;
        NutzerMapper instance = new NutzerMapper();
        Nutzer expResult = null;
        Nutzer result = instance.insert(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class NutzerMapper.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Nutzer val = null;
        NutzerMapper instance = new NutzerMapper();
        Nutzer expResult = null;
        Nutzer result = instance.update(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class NutzerMapper.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Nutzer val = null;
        NutzerMapper instance = new NutzerMapper();
        instance.delete(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class NutzerMapper.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        NutzerMapper instance = new NutzerMapper();
        Vector<Nutzer> expResult = null;
        Vector<Nutzer> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class NutzerMapper.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int val = 0;
        NutzerMapper instance = new NutzerMapper();
        Nutzer expResult = null;
        Nutzer result = instance.findByID(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
