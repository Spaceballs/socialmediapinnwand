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
public class ReportTest {
    
    public ReportTest() {
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
     * Test of getBodyParagraph method, of class Report.
     */
    @Test
    public void testGetBodyParagraph() throws Exception {
        System.out.println("getBodyParagraph");
        Report instance = new ReportImpl();
        Paragraph expResult = null;
        Paragraph result = instance.getBodyParagraph();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreationDate method, of class Report.
     */
    @Test
    public void testGetCreationDate() throws Exception {
        System.out.println("getCreationDate");
        Report instance = new ReportImpl();
        Date expResult = null;
        Date result = instance.getCreationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDate method, of class Report.
     */
    @Test
    public void testGetEndDate() throws Exception {
        System.out.println("getEndDate");
        Report instance = new ReportImpl();
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeaderAndTitleParagraph method, of class Report.
     */
    @Test
    public void testGetHeaderAndTitleParagraph() throws Exception {
        System.out.println("getHeaderAndTitleParagraph");
        Report instance = new ReportImpl();
        Paragraph expResult = null;
        Paragraph result = instance.getHeaderAndTitleParagraph();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImprintParagraph method, of class Report.
     */
    @Test
    public void testGetImprintParagraph() throws Exception {
        System.out.println("getImprintParagraph");
        Report instance = new ReportImpl();
        Paragraph expResult = null;
        Paragraph result = instance.getImprintParagraph();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRows method, of class Report.
     */
    @Test
    public void testGetRows() throws Exception {
        System.out.println("getRows");
        Report instance = new ReportImpl();
        Vector<Row> expResult = null;
        Vector<Row> result = instance.getRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class Report.
     */
    @Test
    public void testGetStartDate() throws Exception {
        System.out.println("getStartDate");
        Report instance = new ReportImpl();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBodyParagraph method, of class Report.
     */
    @Test
    public void testSetBodyParagraph() throws Exception {
        System.out.println("setBodyParagraph");
        Paragraph bodyParagraph = null;
        Report instance = new ReportImpl();
        instance.setBodyParagraph(bodyParagraph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreationDate method, of class Report.
     */
    @Test
    public void testSetCreationDate() throws Exception {
        System.out.println("setCreationDate");
        Date creationDate = null;
        Report instance = new ReportImpl();
        instance.setCreationDate(creationDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class Report.
     */
    @Test
    public void testSetEndDate() throws Exception {
        System.out.println("setEndDate");
        Date endDate = null;
        Report instance = new ReportImpl();
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeaderAndTitleParagraph method, of class Report.
     */
    @Test
    public void testSetHeaderAndTitleParagraph() throws Exception {
        System.out.println("setHeaderAndTitleParagraph");
        Paragraph headerAndTitleParagraph = null;
        Report instance = new ReportImpl();
        instance.setHeaderAndTitleParagraph(headerAndTitleParagraph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImprintParagraph method, of class Report.
     */
    @Test
    public void testSetImprintParagraph() throws Exception {
        System.out.println("setImprintParagraph");
        Paragraph imprintParagraph = null;
        Report instance = new ReportImpl();
        instance.setImprintParagraph(imprintParagraph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRows method, of class Report.
     */
    @Test
    public void testSetRows() throws Exception {
        System.out.println("setRows");
        Vector<Row> rows = null;
        Report instance = new ReportImpl();
        instance.setRows(rows);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class Report.
     */
    @Test
    public void testSetStartDate() throws Exception {
        System.out.println("setStartDate");
        Date startDate = null;
        Report instance = new ReportImpl();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ReportImpl implements Report {

        public Paragraph getBodyParagraph() throws RemoteException {
            return null;
        }

        public Date getCreationDate() throws RemoteException {
            return null;
        }

        public Date getEndDate() throws RemoteException {
            return null;
        }

        public Paragraph getHeaderAndTitleParagraph() throws RemoteException {
            return null;
        }

        public Paragraph getImprintParagraph() throws RemoteException {
            return null;
        }

        public Vector<Row> getRows() throws RemoteException {
            return null;
        }

        public Date getStartDate() throws RemoteException {
            return null;
        }

        public void setBodyParagraph(Paragraph bodyParagraph) throws RemoteException {
        }

        public void setCreationDate(Date creationDate) throws RemoteException {
        }

        public void setEndDate(Date endDate) throws RemoteException {
        }

        public void setHeaderAndTitleParagraph(Paragraph headerAndTitleParagraph) throws RemoteException {
        }

        public void setImprintParagraph(Paragraph imprintParagraph) throws RemoteException {
        }

        public void setRows(Vector<Row> rows) throws RemoteException {
        }

        public void setStartDate(Date startDate) throws RemoteException {
        }
    }
    
}
