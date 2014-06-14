/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocialMedia_DatabaseManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Sebastian Fink
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({SocialMedia_DatabaseManager.LikeMapperTest.class, SocialMedia_DatabaseManager.NutzerMapperTest.class, SocialMedia_DatabaseManager.BeitragMapperTest.class, SocialMedia_DatabaseManager.KommentarMapperTest.class, SocialMedia_DatabaseManager.DBStatementFactoryTest.class, SocialMedia_DatabaseManager.PinnwandMapperTest.class, SocialMedia_DatabaseManager.AbonnementMapperTest.class, SocialMedia_DatabaseManager.DBConnectionTest.class})
public class SocialMedia_DatabaseManagerSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
