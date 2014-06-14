/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import SocialMedia_Data.Kommentar;
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
public class KommentarMapperTest {
    
    public KommentarMapperTest() {
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
     * Test of kommentarMapper method, of class KommentarMapper.
     */
    @Test
    public void testKommentarMapper() {
        System.out.println("kommentarMapper");
        KommentarMapper expResult = null;
        KommentarMapper result = KommentarMapper.kommentarMapper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class KommentarMapper.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Kommentar val = null;
        KommentarMapper instance = new KommentarMapper();
        Kommentar expResult = null;
        Kommentar result = instance.insert(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class KommentarMapper.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Kommentar val = null;
        KommentarMapper instance = new KommentarMapper();
        Kommentar expResult = null;
        Kommentar result = instance.update(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class KommentarMapper.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Kommentar val = null;
        KommentarMapper instance = new KommentarMapper();
        instance.delete(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class KommentarMapper.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        KommentarMapper instance = new KommentarMapper();
        Vector<Kommentar> expResult = null;
        Vector<Kommentar> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class KommentarMapper.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int val = 0;
        KommentarMapper instance = new KommentarMapper();
        Kommentar expResult = null;
        Kommentar result = instance.findByID(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
