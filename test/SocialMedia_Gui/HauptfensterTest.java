/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Gui;

import SocialMedia_Data.Nutzer;
import SocialMedia_Logic.SocialMediaLogic;
import javax.swing.JPanel;
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
public class HauptfensterTest {
    
    public HauptfensterTest() {
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
     * Test of hauptfenster method, of class Hauptfenster.
     */
    @Test
    public void testHauptfenster() {
        System.out.println("hauptfenster");
        SocialMediaLogic server = null;
        Nutzer clientNutzer = null;
        Hauptfenster expResult = null;
        Hauptfenster result = Hauptfenster.hauptfenster(server, clientNutzer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPanelLinks method, of class Hauptfenster.
     */
    @Test
    public void testSetPanelLinks() {
        System.out.println("setPanelLinks");
        JPanel panelLinks = null;
        Hauptfenster instance = null;
        instance.setPanelLinks(panelLinks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refreshPanelLinks method, of class Hauptfenster.
     */
    @Test
    public void testRefreshPanelLinks() {
        System.out.println("refreshPanelLinks");
        Hauptfenster instance = null;
        instance.refreshPanelLinks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
