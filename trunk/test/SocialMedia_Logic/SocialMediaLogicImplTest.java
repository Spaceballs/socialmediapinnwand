/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_Logic;

import SocialMedia_Data.Abonnement;
import SocialMedia_Data.Beitrag;
import SocialMedia_Data.Kommentar;
import SocialMedia_Data.Like;
import SocialMedia_Data.Nutzer;
import SocialMedia_Data.Pinnwand;
import SocialMedia_ReportGenerator.ReportGenerator;
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
public class SocialMediaLogicImplTest {
    
    public SocialMediaLogicImplTest() {
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
     * Test of getAllLikeOfBeitrag method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllLikeOfBeitrag() throws Exception {
        System.out.println("getAllLikeOfBeitrag");
        Beitrag val = null;
        SocialMediaLogicImpl instance = null;
        Vector<Like> expResult = null;
        Vector<Like> result = instance.getAllLikeOfBeitrag(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllKommentarOfBeitrag method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllKommentarOfBeitrag() throws Exception {
        System.out.println("getAllKommentarOfBeitrag");
        Beitrag val = null;
        SocialMediaLogicImpl instance = null;
        Vector<Kommentar> expResult = null;
        Vector<Kommentar> result = instance.getAllKommentarOfBeitrag(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBeitrag method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllBeitrag() throws Exception {
        System.out.println("getAllBeitrag");
        SocialMediaLogicImpl instance = null;
        Vector<Beitrag> expResult = null;
        Vector<Beitrag> result = instance.getAllBeitrag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAbonnementOfNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllAbonnementOfNutzer() throws Exception {
        System.out.println("getAllAbonnementOfNutzer");
        Nutzer val = null;
        SocialMediaLogicImpl instance = null;
        Vector<Abonnement> expResult = null;
        Vector<Abonnement> result = instance.getAllAbonnementOfNutzer(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPinnwandOfAbonnement method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetPinnwandOfAbonnement() throws Exception {
        System.out.println("getPinnwandOfAbonnement");
        Abonnement val = null;
        SocialMediaLogicImpl instance = null;
        Pinnwand expResult = null;
        Pinnwand result = instance.getPinnwandOfAbonnement(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlreadyBooked method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testIsAlreadyBooked() throws Exception {
        System.out.println("isAlreadyBooked");
        Nutzer n = null;
        Pinnwand p = null;
        SocialMediaLogicImpl instance = null;
        Boolean expResult = null;
        Boolean result = instance.isAlreadyBooked(n, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlreadyLiked method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testIsAlreadyLiked() throws Exception {
        System.out.println("isAlreadyLiked");
        Nutzer n = null;
        Beitrag b = null;
        SocialMediaLogicImpl instance = null;
        Boolean expResult = null;
        Boolean result = instance.isAlreadyLiked(n, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserLike method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetUserLike() throws Exception {
        System.out.println("getUserLike");
        Nutzer n = null;
        Beitrag b = null;
        SocialMediaLogicImpl instance = null;
        Like expResult = null;
        Like result = instance.getUserLike(n, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPinnwandAbonnement method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetPinnwandAbonnement() throws Exception {
        System.out.println("getPinnwandAbonnement");
        Nutzer n = null;
        Pinnwand p = null;
        SocialMediaLogicImpl instance = null;
        Abonnement expResult = null;
        Abonnement result = instance.getPinnwandAbonnement(n, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testCreateNutzer() throws Exception {
        System.out.println("createNutzer");
        String username = "";
        String name = "";
        String surname = "";
        String password = "";
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.createNutzer(username, name, surname, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPinnwand method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testCreatePinnwand() throws Exception {
        System.out.println("createPinnwand");
        Nutzer n = null;
        SocialMediaLogicImpl instance = null;
        Pinnwand expResult = null;
        Pinnwand result = instance.createPinnwand(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBeitrag method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testCreateBeitrag() throws Exception {
        System.out.println("createBeitrag");
        Pinnwand p = null;
        Nutzer n = null;
        String text = "";
        SocialMediaLogicImpl instance = null;
        Beitrag expResult = null;
        Beitrag result = instance.createBeitrag(p, n, text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createKommentar method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testCreateKommentar() throws Exception {
        System.out.println("createKommentar");
        Beitrag b = null;
        Nutzer n = null;
        String text = "";
        SocialMediaLogicImpl instance = null;
        Kommentar expResult = null;
        Kommentar result = instance.createKommentar(b, n, text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createLike method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testCreateLike() throws Exception {
        System.out.println("createLike");
        Beitrag b = null;
        Nutzer n = null;
        SocialMediaLogicImpl instance = null;
        Like expResult = null;
        Like result = instance.createLike(b, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAbonnement method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testCreateAbonnement() throws Exception {
        System.out.println("createAbonnement");
        Pinnwand p = null;
        Nutzer n = null;
        SocialMediaLogicImpl instance = null;
        Abonnement expResult = null;
        Abonnement result = instance.createAbonnement(p, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBeitrag method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testDeleteBeitrag() throws Exception {
        System.out.println("deleteBeitrag");
        Beitrag val = null;
        SocialMediaLogicImpl instance = null;
        instance.deleteBeitrag(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteKommentar method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testDeleteKommentar() throws Exception {
        System.out.println("deleteKommentar");
        Kommentar val = null;
        SocialMediaLogicImpl instance = null;
        instance.deleteKommentar(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLike method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testDeleteLike() throws Exception {
        System.out.println("deleteLike");
        Like val = null;
        SocialMediaLogicImpl instance = null;
        instance.deleteLike(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAbonnement method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testDeleteAbonnement() throws Exception {
        System.out.println("deleteAbonnement");
        Abonnement val = null;
        SocialMediaLogicImpl instance = null;
        instance.deleteAbonnement(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deactivateNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testDeactivateNutzer() throws Exception {
        System.out.println("deactivateNutzer");
        Nutzer val = null;
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.deactivateNutzer(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePinnwand method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testDeletePinnwand() throws Exception {
        System.out.println("deletePinnwand");
        Pinnwand val = null;
        SocialMediaLogicImpl instance = null;
        instance.deletePinnwand(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authenticateNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testAuthenticateNutzer() throws Exception {
        System.out.println("authenticateNutzer");
        String username = "";
        String password = "";
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.authenticateNutzer(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrateNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testRegistrateNutzer() throws Exception {
        System.out.println("registrateNutzer");
        String username = "";
        String name = "";
        String surname = "";
        String password = "";
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.registrateNutzer(username, name, surname, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPinnwandOfNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetPinnwandOfNutzer() throws Exception {
        System.out.println("getPinnwandOfNutzer");
        Nutzer val = null;
        SocialMediaLogicImpl instance = null;
        Pinnwand expResult = null;
        Pinnwand result = instance.getPinnwandOfNutzer(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAbonnementsOfPinnwand method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllAbonnementsOfPinnwand() throws Exception {
        System.out.println("getAllAbonnementsOfPinnwand");
        Pinnwand p = null;
        SocialMediaLogicImpl instance = null;
        Vector<Abonnement> expResult = null;
        Vector<Abonnement> result = instance.getAllAbonnementsOfPinnwand(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPinnwand method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllPinnwand() throws Exception {
        System.out.println("getAllPinnwand");
        SocialMediaLogicImpl instance = null;
        Vector<Pinnwand> expResult = null;
        Vector<Pinnwand> result = instance.getAllPinnwand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBeitragOfPinnwand method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllBeitragOfPinnwand() throws Exception {
        System.out.println("getAllBeitragOfPinnwand");
        Pinnwand val = null;
        SocialMediaLogicImpl instance = null;
        Vector<Beitrag> expResult = null;
        Vector<Beitrag> result = instance.getAllBeitragOfPinnwand(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllLike method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllLike() throws Exception {
        System.out.println("getAllLike");
        SocialMediaLogicImpl instance = null;
        Vector<Like> expResult = null;
        Vector<Like> result = instance.getAllLike();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllKommentar method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllKommentar() throws Exception {
        System.out.println("getAllKommentar");
        SocialMediaLogicImpl instance = null;
        Vector<Kommentar> expResult = null;
        Vector<Kommentar> result = instance.getAllKommentar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAbonnement method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllAbonnement() throws Exception {
        System.out.println("getAllAbonnement");
        SocialMediaLogicImpl instance = null;
        Vector<Abonnement> expResult = null;
        Vector<Abonnement> result = instance.getAllAbonnement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwnerOfPinnwandOfAbonnement method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetOwnerOfPinnwandOfAbonnement() throws Exception {
        System.out.println("getOwnerOfPinnwandOfAbonnement");
        Abonnement val = null;
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.getOwnerOfPinnwandOfAbonnement(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetAllNutzer() throws Exception {
        System.out.println("getAllNutzer");
        SocialMediaLogicImpl instance = null;
        Vector<Nutzer> expResult = null;
        Vector<Nutzer> result = instance.getAllNutzer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testSearchNutzer() throws Exception {
        System.out.println("searchNutzer");
        String val = "";
        SocialMediaLogicImpl instance = null;
        Vector<Nutzer> expResult = null;
        Vector<Nutzer> result = instance.searchNutzer(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testEditNutzer() throws Exception {
        System.out.println("editNutzer");
        String username = "";
        String name = "";
        String surname = "";
        String password = "";
        Nutzer val = null;
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.editNutzer(username, name, surname, password, val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editBeitrag method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testEditBeitrag() throws Exception {
        System.out.println("editBeitrag");
        String text = "";
        Beitrag b = null;
        SocialMediaLogicImpl instance = null;
        Beitrag expResult = null;
        Beitrag result = instance.editBeitrag(text, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editKommentar method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testEditKommentar() throws Exception {
        System.out.println("editKommentar");
        String text = "";
        Kommentar k = null;
        SocialMediaLogicImpl instance = null;
        Kommentar expResult = null;
        Kommentar result = instance.editKommentar(text, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNutzer method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testSaveNutzer() throws Exception {
        System.out.println("saveNutzer");
        Nutzer val = null;
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.saveNutzer(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveBeitrag method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testSaveBeitrag() throws Exception {
        System.out.println("saveBeitrag");
        Beitrag val = null;
        SocialMediaLogicImpl instance = null;
        Beitrag expResult = null;
        Beitrag result = instance.saveBeitrag(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveKommentar method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testSaveKommentar() throws Exception {
        System.out.println("saveKommentar");
        Kommentar val = null;
        SocialMediaLogicImpl instance = null;
        Kommentar expResult = null;
        Kommentar result = instance.saveKommentar(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwnerOfPinnwand method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetOwnerOfPinnwand() throws Exception {
        System.out.println("getOwnerOfPinnwand");
        Pinnwand p = null;
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.getOwnerOfPinnwand(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ownerCheck method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testOwnerCheck() throws Exception {
        System.out.println("ownerCheck");
        Nutzer n = null;
        Object o = null;
        SocialMediaLogicImpl instance = null;
        Boolean expResult = null;
        Boolean result = instance.ownerCheck(n, o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReportGenerator method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetReportGenerator() throws Exception {
        System.out.println("getReportGenerator");
        SocialMediaLogicImpl instance = null;
        ReportGenerator expResult = null;
        ReportGenerator result = instance.getReportGenerator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNutzerOf method, of class SocialMediaLogicImpl.
     */
    @Test
    public void testGetNutzerOf() throws Exception {
        System.out.println("getNutzerOf");
        Object o = null;
        SocialMediaLogicImpl instance = null;
        Nutzer expResult = null;
        Nutzer result = instance.getNutzerOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
