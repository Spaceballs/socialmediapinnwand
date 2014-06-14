/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Report;

import java.rmi.RemoteException;
import java.util.Date;
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
public class ReportImplTest {
    
    public ReportImplTest() {
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
     * Test of getCreationDate method, of class ReportImpl.
     */
    @Test
    public void testGetCreationDate() throws RemoteException {
        System.out.println("getCreationDate");
        ReportImpl instance = new ReportImpl();
        Date expResult = null;
        Date result = instance.getCreationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreationDate method, of class ReportImpl.
     */
    @Test
    public void testSetCreationDate() throws RemoteException {
        System.out.println("setCreationDate");
        Date creationDate = null;
        ReportImpl instance = new ReportImpl();
        instance.setCreationDate(creationDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class ReportImpl.
     */
    @Test
    public void testGetStartDate() throws RemoteException {
        System.out.println("getStartDate");
        ReportImpl instance = new ReportImpl();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class ReportImpl.
     */
    @Test
    public void testSetStartDate() throws RemoteException {
        System.out.println("setStartDate");
        Date startDate = null;
        ReportImpl instance = new ReportImpl();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDate method, of class ReportImpl.
     */
    @Test
    public void testGetEndDate() throws RemoteException {
        System.out.println("getEndDate");
        ReportImpl instance = new ReportImpl();
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class ReportImpl.
     */
    @Test
    public void testSetEndDate() throws RemoteException {
        System.out.println("setEndDate");
        Date endDate = null;
        ReportImpl instance = new ReportImpl();
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRows method, of class ReportImpl.
     */
    @Test
    public void testGetRows() throws RemoteException {
        System.out.println("getRows");
        ReportImpl instance = new ReportImpl();
        Vector<Row> expResult = null;
        Vector<Row> result = instance.getRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRows method, of class ReportImpl.
     */
    @Test
    public void testSetRows() throws RemoteException {
        System.out.println("setRows");
        Vector<Row> rows = null;
        ReportImpl instance = new ReportImpl();
        instance.setRows(rows);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeaderAndTitleParagraph method, of class ReportImpl.
     */
    @Test
    public void testGetHeaderAndTitleParagraph() throws RemoteException {
        System.out.println("getHeaderAndTitleParagraph");
        ReportImpl instance = new ReportImpl();
        Paragraph expResult = null;
        Paragraph result = instance.getHeaderAndTitleParagraph();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeaderAndTitleParagraph method, of class ReportImpl.
     */
    @Test
    public void testSetHeaderAndTitleParagraph() throws RemoteException {
        System.out.println("setHeaderAndTitleParagraph");
        Paragraph headerAndTitleParagraph = null;
        ReportImpl instance = new ReportImpl();
        instance.setHeaderAndTitleParagraph(headerAndTitleParagraph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBodyParagraph method, of class ReportImpl.
     */
    @Test
    public void testGetBodyParagraph() throws RemoteException {
        System.out.println("getBodyParagraph");
        ReportImpl instance = new ReportImpl();
        Paragraph expResult = null;
        Paragraph result = instance.getBodyParagraph();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBodyParagraph method, of class ReportImpl.
     */
    @Test
    public void testSetBodyParagraph() throws RemoteException {
        System.out.println("setBodyParagraph");
        Paragraph bodyParagraph = null;
        ReportImpl instance = new ReportImpl();
        instance.setBodyParagraph(bodyParagraph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImprintParagraph method, of class ReportImpl.
     */
    @Test
    public void testGetImprintParagraph() throws RemoteException {
        System.out.println("getImprintParagraph");
        ReportImpl instance = new ReportImpl();
        Paragraph expResult = null;
        Paragraph result = instance.getImprintParagraph();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImprintParagraph method, of class ReportImpl.
     */
    @Test
    public void testSetImprintParagraph() throws RemoteException {
        System.out.println("setImprintParagraph");
        Paragraph imprintParagraph = null;
        ReportImpl instance = new ReportImpl();
        instance.setImprintParagraph(imprintParagraph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
