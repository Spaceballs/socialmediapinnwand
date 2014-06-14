/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Client;

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
public class SocialMediaReportClientTest {
    
    public SocialMediaReportClientTest() {
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
     * Test of createAndShowDialogue method, of class SocialMediaReportClient.
     */
    @Test
    public void testCreateAndShowDialogue() {
        System.out.println("createAndShowDialogue");
        SocialMediaReportClient instance = null;
        instance.createAndShowDialogue();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeClient method, of class SocialMediaReportClient.
     */
    @Test
    public void testExecuteClient() {
        System.out.println("executeClient");
        String adresse = "";
        String serverPort = "";
        String clientPort = "";
        SocialMediaReportClient instance = null;
        instance.executeClient(adresse, serverPort, clientPort);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAndShowGUI method, of class SocialMediaReportClient.
     */
    @Test
    public void testCreateAndShowGUI() {
        System.out.println("createAndShowGUI");
        SocialMediaReportClient instance = null;
        instance.createAndShowGUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class SocialMediaReportClient.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SocialMediaReportClient.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
