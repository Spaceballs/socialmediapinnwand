/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_ReportGenerator;

import SocialMedia_Data.Nutzer;
import SocialMedia_Report.Report;
import java.rmi.RemoteException;
import java.util.Date;
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
public class ReportGeneratorTest {
    
    public ReportGeneratorTest() {
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
     * Test of createContributionOfNutzerReport method, of class ReportGenerator.
     */
    @Test
    public void testCreateContributionOfNutzerReport() throws Exception {
        System.out.println("createContributionOfNutzerReport");
        Nutzer nutzerVal = null;
        int sortByVal = 0;
        Date startDateVal = null;
        Date endDateVal = null;
        ReportGenerator instance = new ReportGeneratorImpl();
        Report expResult = null;
        Report result = instance.createContributionOfNutzerReport(sortByVal, startDateVal, endDateVal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPopularityOfBeitragReport method, of class ReportGenerator.
     */
    @Test
    public void testCreatePopularityOfBeitragReport() throws Exception {
        System.out.println("createPopularityOfBeitragReport");
        int sortByVal = 0;
        Date startDateVal = null;
        Date endDateVal = null;
        ReportGenerator instance = new ReportGeneratorImpl();
        Report expResult = null;
        Report result = instance.createPopularityOfBeitragReport(sortByVal, startDateVal, endDateVal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ReportGeneratorImpl implements ReportGenerator {

        public Report createPopularityOfBeitragReport(int sortByVal, Date startDateVal, Date endDateVal) throws RemoteException {
            return null;
        }

        public Report createContributionOfNutzerReport(int sortByVal, Date startDateVal, Date endDateVal) throws RemoteException {
            return null;
        }
    }
    
}
