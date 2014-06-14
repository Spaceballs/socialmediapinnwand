/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_IOandHelper;

import java.security.CodeSource;
import java.security.PermissionCollection;
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
public class ServerPolicyTest {
    
    public ServerPolicyTest() {
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
     * Test of getPermissions method, of class ServerPolicy.
     */
    @Test
    public void testGetPermissions() {
        System.out.println("getPermissions");
        CodeSource codesource = null;
        ServerPolicy instance = new ServerPolicy();
        PermissionCollection expResult = null;
        PermissionCollection result = instance.getPermissions(codesource);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
