/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

import java.security.Permission;
import java.util.Enumeration;
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
public class MyPermissionCollectionTest {
    
    public MyPermissionCollectionTest() {
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
     * Test of add method, of class MyPermissionCollection.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Permission p = null;
        MyPermissionCollection instance = new MyPermissionCollection();
        instance.add(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of implies method, of class MyPermissionCollection.
     */
    @Test
    public void testImplies() {
        System.out.println("implies");
        Permission p = null;
        MyPermissionCollection instance = new MyPermissionCollection();
        boolean expResult = false;
        boolean result = instance.implies(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elements method, of class MyPermissionCollection.
     */
    @Test
    public void testElements() {
        System.out.println("elements");
        MyPermissionCollection instance = new MyPermissionCollection();
        Enumeration<Permission> expResult = null;
        Enumeration<Permission> result = instance.elements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isReadOnly method, of class MyPermissionCollection.
     */
    @Test
    public void testIsReadOnly() {
        System.out.println("isReadOnly");
        MyPermissionCollection instance = new MyPermissionCollection();
        boolean expResult = false;
        boolean result = instance.isReadOnly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
