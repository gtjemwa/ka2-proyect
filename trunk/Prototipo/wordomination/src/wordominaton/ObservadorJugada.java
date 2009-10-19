/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wordominaton;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Andrés
 * Observa si hay algun cambio en la partida y procede a actualizar la info del
 * jugador.
 */
public class ObservadorJugada implements Runnable {

    public void run() {
        try {
            Thread.sleep(1000L);



        } catch (InterruptedException ex) {
            Logger.getLogger(ObservadorJugada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
