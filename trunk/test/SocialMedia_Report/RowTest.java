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
public class RowTest {
    
    public RowTest() {
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
     * Test of addColumn method, of class Row.
     */
    @Test
    public void testAddColumn() throws Exception {
        System.out.println("addColumn");
        Column val = null;
        Row instance = new RowImpl();
        instance.addColumn(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnAt method, of class Row.
     */
    @Test
    public void testGetColumnAt() throws Exception {
        System.out.println("getColumnAt");
        int val = 0;
        Row instance = new RowImpl();
        Column expResult = null;
        Column result = instance.getColumnAt(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumns method, of class Row.
     */
    @Test
    public void testGetColumns() throws Exception {
        System.out.println("getColumns");
        Row instance = new RowImpl();
        Vector<Column> expResult = null;
        Vector<Column> result = instance.getColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfColumn method, of class Row.
     */
    @Test
    public void testGetNumOfColumn() throws Exception {
        System.out.println("getNumOfColumn");
        Row instance = new RowImpl();
        int expResult = 0;
        int result = instance.getNumOfColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeColumn method, of class Row.
     */
    @Test
    public void testRemoveColumn() throws Exception {
        System.out.println("removeColumn");
        Column val = null;
        Row instance = new RowImpl();
        instance.removeColumn(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class RowImpl implements Row {

        public void addColumn(Column val) throws RemoteException {
        }

        public Column getColumnAt(int val) throws RemoteException {
            return null;
        }

        public Vector<Column> getColumns() throws RemoteException {
            return null;
        }

        public int getNumOfColumn() throws RemoteException {
            return 0;
        }

        public void removeColumn(Column val) throws RemoteException {
        }
    }
    
}
