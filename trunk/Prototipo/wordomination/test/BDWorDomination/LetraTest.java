/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDWorDomination;

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
public class LetraTest {

    public LetraTest() {
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
     * Test of getLetra method, of class Letra.
     */
    @Test
    public void testGetLetra() {
        System.out.println("getLetra");
        Letra instance = new Letra();
        String expResult = "";
        String result = instance.getLetra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLetra method, of class Letra.
     */
    @Test
    public void testSetLetra() {
        System.out.println("setLetra");
        String letra = "";
        Letra instance = new Letra();
        instance.setLetra(letra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrlimagen method, of class Letra.
     */
    @Test
    public void testGetUrlimagen() {
        System.out.println("getUrlimagen");
        Letra instance = new Letra();
        String expResult = "";
        String result = instance.getUrlimagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrlimagen method, of class Letra.
     */
    @Test
    public void testSetUrlimagen() {
        System.out.println("setUrlimagen");
        String urlimagen = "";
        Letra instance = new Letra();
        instance.setUrlimagen(urlimagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntuacionletra method, of class Letra.
     */
    @Test
    public void testGetPuntuacionletra() {
        System.out.println("getPuntuacionletra");
        Letra instance = new Letra();
        int expResult = 0;
        int result = instance.getPuntuacionletra();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPuntuacionletra method, of class Letra.
     */
    @Test
    public void testSetPuntuacionletra() {
        System.out.println("setPuntuacionletra");
        int puntuacionletra = 0;
        Letra instance = new Letra();
        instance.setPuntuacionletra(puntuacionletra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Letra.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Letra instance = new Letra();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}