/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import SocialMedia_Data.Like;
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
public class LikeMapperTest {
    
    public LikeMapperTest() {
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
     * Test of likeMapper method, of class LikeMapper.
     */
    @Test
    public void testLikeMapper() {
        System.out.println("likeMapper");
        LikeMapper expResult = null;
        LikeMapper result = LikeMapper.likeMapper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class LikeMapper.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Like val = null;
        LikeMapper instance = new LikeMapper();
        Like expResult = null;
        Like result = instance.insert(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LikeMapper.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Like val = null;
        LikeMapper instance = new LikeMapper();
        Like expResult = null;
        Like result = instance.update(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LikeMapper.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Like val = null;
        LikeMapper instance = new LikeMapper();
        instance.delete(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class LikeMapper.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        LikeMapper instance = new LikeMapper();
        Vector<Like> expResult = null;
        Vector<Like> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class LikeMapper.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int val = 0;
        LikeMapper instance = new LikeMapper();
        Like expResult = null;
        Like result = instance.findByID(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
