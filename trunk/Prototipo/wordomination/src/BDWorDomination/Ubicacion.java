/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDWorDomination;

/**
 *
 * @author Andrés
 */
    public class Ubicacion {
        public Ubicacion(int uX, int uY){
        x = uX;
        y = uY;
        }
        public int getX(){return x;}
        public int getY(){return y;}
        public void setX(int uX){x = uX;}
        public void setY(int uY){y = uY;}

        private int x;
        private int y;
    }
