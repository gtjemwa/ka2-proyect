/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wordominaton;

import BDWorDomination.Cuadro;
import java.awt.Point;
import org.jdesktop.application.Task;
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
public class PlayWordominationTest {

    public PlayWordominationTest() {
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
     * Test of iniciarTurno method, of class PlayWordomination.
     */
    @Test
    public void testIniciarTurno() {
        System.out.println("iniciarTurno");
        PlayWordomination instance = null;
        instance.iniciarTurno();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reiniciarTurno method, of class PlayWordomination.
     */
    @Test
    public void testReiniciarTurno() {
        System.out.println("reiniciarTurno");
        PlayWordomination instance = null;
        instance.reiniciarTurno();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of posCuadroDisponible method, of class PlayWordomination.
     */
    @Test
    public void testPosCuadroDisponible() {
        System.out.println("posCuadroDisponible");
        String direccion = "";
        int ux = 0;
        int uy = 0;
        PlayWordomination instance = null;
        int expResult = 0;
        int result = instance.posCuadroDisponible(direccion, ux, uy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of posAnyRed method, of class PlayWordomination.
     */
    @Test
    public void testPosAnyRed() {
        System.out.println("posAnyRed");
        PlayWordomination instance = null;
        Point expResult = null;
        Point result = instance.posAnyRed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hayletracuadrilla method, of class PlayWordomination.
     */
    @Test
    public void testHayletracuadrilla() {
        System.out.println("hayletracuadrilla");
        PlayWordomination instance = null;
        boolean expResult = false;
        boolean result = instance.hayletracuadrilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enabledPosCuadrilla method, of class PlayWordomination.
     */
    @Test
    public void testEnabledPosCuadrilla() {
        System.out.println("enabledPosCuadrilla");
        PlayWordomination instance = null;
        instance.enabledPosCuadrilla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarCuadrilla method, of class PlayWordomination.
     */
    @Test
    public void testIniciarCuadrilla() {
        System.out.println("iniciarCuadrilla");
        PlayWordomination instance = null;
        instance.iniciarCuadrilla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarCuadro method, of class PlayWordomination.
     */
    @Test
    public void testLimpiarCuadro() {
        System.out.println("limpiarCuadro");
        int x = 0;
        int y = 0;
        PlayWordomination instance = null;
        instance.limpiarCuadro(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enabledCuadrilla method, of class PlayWordomination.
     */
    @Test
    public void testEnabledCuadrilla() {
        System.out.println("enabledCuadrilla");
        boolean b = false;
        PlayWordomination instance = null;
        instance.enabledCuadrilla(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCuadroRAM method, of class PlayWordomination.
     */
    @Test
    public void testSetCuadroRAM() {
        System.out.println("setCuadroRAM");
        Cuadro[][] c = null;
        PlayWordomination instance = null;
        instance.setCuadroRAM(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enabledExtremos method, of class PlayWordomination.
     */
    @Test
    public void testEnabledExtremos() {
        System.out.println("enabledExtremos");
        int porizquierda = 0;
        int porderecha = 0;
        int porabajo = 0;
        int porarriba = 0;
        int x = 0;
        int y = 0;
        PlayWordomination instance = null;
        instance.enabledExtremos(porizquierda, porderecha, porabajo, porarriba, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmarJugada method, of class PlayWordomination.
     */
    @Test
    public void testConfirmarJugada() {
        System.out.println("confirmarJugada");
        PlayWordomination instance = null;
        Task expResult = null;
        Task result = instance.confirmarJugada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}