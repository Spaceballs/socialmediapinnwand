/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.rmi.RemoteException;
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
public class CompositeParagraphTest {
    
    public CompositeParagraphTest() {
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
     * Test of addSubParagraph method, of class CompositeParagraph.
     */
    @Test
    public void testAddSubParagraph() throws Exception {
        System.out.println("addSubParagraph");
        SimpleParagraph val = null;
        CompositeParagraph instance = new CompositeParagraphImpl();
        instance.addSubParagraph(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumParagraphs method, of class CompositeParagraph.
     */
    @Test
    public void testGetNumParagraphs() throws Exception {
        System.out.println("getNumParagraphs");
        CompositeParagraph instance = new CompositeParagraphImpl();
        int expResult = 0;
        int result = instance.getNumParagraphs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParagraphAt method, of class CompositeParagraph.
     */
    @Test
    public void testGetParagraphAt() throws Exception {
        System.out.println("getParagraphAt");
        int val = 0;
        CompositeParagraph instance = new CompositeParagraphImpl();
        SimpleParagraph expResult = null;
        SimpleParagraph result = instance.getParagraphAt(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubParagraphs method, of class CompositeParagraph.
     */
    @Test
    public void testGetSubParagraphs() throws Exception {
        System.out.println("getSubParagraphs");
        CompositeParagraph instance = new CompositeParagraphImpl();
        Vector<SimpleParagraph> expResult = null;
        Vector<SimpleParagraph> result = instance.getSubParagraphs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSubParagraph method, of class CompositeParagraph.
     */
    @Test
    public void testRemoveSubParagraph() throws Exception {
        System.out.println("removeSubParagraph");
        SimpleParagraph val = null;
        CompositeParagraph instance = new CompositeParagraphImpl();
        instance.removeSubParagraph(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStrings method, of class CompositeParagraph.
     */
    @Test
    public void testToStrings() throws Exception {
        System.out.println("toStrings");
        CompositeParagraph instance = new CompositeParagraphImpl();
        String expResult = "";
        String result = instance.toStrings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CompositeParagraphImpl implements CompositeParagraph {

        public void addSubParagraph(SimpleParagraph val) throws RemoteException {
        }

        public int getNumParagraphs() throws RemoteException {
            return 0;
        }

        public SimpleParagraph getParagraphAt(int val) throws RemoteException {
            return null;
        }

        public Vector<SimpleParagraph> getSubParagraphs() throws RemoteException {
            return null;
        }

        public void removeSubParagraph(SimpleParagraph val) throws RemoteException {
        }

        public String toStrings() throws RemoteException {
            return "";
        }
    }
    
}
