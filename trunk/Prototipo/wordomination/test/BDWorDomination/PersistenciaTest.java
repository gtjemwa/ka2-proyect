/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDWorDomination;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrés
 */
public class PersistenciaTest {

    public PersistenciaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of selectSQL method, of class Persistencia.
     */
    @Test
    public void testSelectSQL() throws Exception {
        System.out.println("selectSQL");
        String query = "";
        int column = 0;
        Persistencia instance = new Persistencia();
        ArrayList expResult = null;
        ArrayList result = instance.selectSQL(query, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRowSQL method, of class Persistencia.
     */
    @Test
    public void testUpdateRowSQL() {
        System.out.println("updateRowSQL");
        String query = "";
        Persistencia instance = new Persistencia();
        instance.updateRowSQL(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRowSQL method, of class Persistencia.
     */
    @Test
    public void testDeleteRowSQL() {
        System.out.println("deleteRowSQL");
        String query = "";
        Persistencia instance = new Persistencia();
        instance.deleteRowSQL(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterTableSQL method, of class Persistencia.
     */
    @Test
    public void testAlterTableSQL() {
        System.out.println("alterTableSQL");
        String query = "";
        Persistencia instance = new Persistencia();
        instance.alterTableSQL(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dropTableSQL method, of class Persistencia.
     */
    @Test
    public void testDropTableSQL() {
        System.out.println("dropTableSQL");
        String query = "";
        Persistencia instance = new Persistencia();
        instance.dropTableSQL(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Persistencia.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Persistencia.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}