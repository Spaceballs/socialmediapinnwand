/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import SocialMedia_Data.Abonnement;
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
public class AbonnementMapperTest {
    
    public AbonnementMapperTest() {
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
     * Test of abonnementMapper method, of class AbonnementMapper.
     */
    @Test
    public void testAbonnementMapper() {
        System.out.println("abonnementMapper");
        AbonnementMapper expResult = null;
        AbonnementMapper result = AbonnementMapper.abonnementMapper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class AbonnementMapper.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Abonnement val = null;
        AbonnementMapper instance = new AbonnementMapper();
        Abonnement expResult = null;
        Abonnement result = instance.insert(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AbonnementMapper.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Abonnement val = null;
        AbonnementMapper instance = new AbonnementMapper();
        Abonnement expResult = null;
        Abonnement result = instance.update(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AbonnementMapper.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Abonnement val = null;
        AbonnementMapper instance = new AbonnementMapper();
        instance.delete(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class AbonnementMapper.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AbonnementMapper instance = new AbonnementMapper();
        Vector<Abonnement> expResult = null;
        Vector<Abonnement> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class AbonnementMapper.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int val = 0;
        AbonnementMapper instance = new AbonnementMapper();
        Abonnement expResult = null;
        Abonnement result = instance.findByID(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
