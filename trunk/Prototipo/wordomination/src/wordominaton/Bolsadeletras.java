/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wordominaton;

import BDWorDomination.*;

/**
 *
 * @author Andrés
 * Es capas de suplir ciertos servicios sobre el uso de la bolsa de letras
 * para el juego.
 */
public class Bolsadeletras {
    
    private Letra[] letras;
    private int limiteactual;
    
    public Bolsadeletras(){
    letras = new Letra[98];  //La cantidad de letras aparece en el reglamento del juego
    limiteactual = 0;
    inicializarLetras();
    }
    //Lanza la letra que este en esta parte de la bolsa
    public Letra getLetraAt(int at){
        if (letras[at] != null)
            return letras[at];
        return null;
    }
    //Basandonos en las reglas del juego se agrega la cantidad
    //de cada letra dentro de la bolsa
    public void inicializarLetras(){
    Letra l = new Letra();
        
        //Agregamos 12 de "A" y "E"
        for(int i=0; i<=11;i++)
        {this.addLetra(new Letra("A")); this.addLetra(new Letra("E"));}

        //Agregamos 9 de "0"
        for(int i=0; i<=8;i++) this.addLetra(new Letra("O"));

        //Agregamos 6 de "I" y "S"
        for(int i=0; i<=5;i++)
        {this.addLetra(new Letra("I")); this.addLetra(new Letra("S"));}

        //Agregamos 5 de "D","U","R" y "N"
        for(int i=0; i<=4;i++)
            {this.addLetra(new Letra("D"));
             this.addLetra(new Letra("U"));
             this.addLetra(new Letra("R"));
             this.addLetra(new Letra("N"));
            }

        //Agregamos 4 de "T","L" y "C"
        for(int i=0; i<=3;i++)
            {this.addLetra(new Letra("T"));
             this.addLetra(new Letra("L"));
             this.addLetra(new Letra("C"));
            }

        //Agregamos 2 de "G","B","M","P" y "H"
        for(int i=0; i<=1;i++)
            {this.addLetra(new Letra("G"));
             this.addLetra(new Letra("B"));
             this.addLetra(new Letra("M"));
             this.addLetra(new Letra("P"));
             this.addLetra(new Letra("H"));
            }
         //Agregamos 1 de "F","V","Y","CH","Q","J","LL",
         //               "Ñ","RR","X" y "Z"
         this.addLetra(new Letra("F"));
         this.addLetra(new Letra("V"));
         this.addLetra(new Letra("Y"));
         this.addLetra(new Letra("CH"));
         this.addLetra(new Letra("Q"));
         this.addLetra(new Letra("J"));
         this.addLetra(new Letra("LL"));
         this.addLetra(new Letra("Ñ"));
         this.addLetra(new Letra("RR"));
         this.addLetra(new Letra("X"));
         this.addLetra(new Letra("Z"));
    }
    public void addLetra(Letra l){
    letras[limiteactual] = l;
    limiteactual++;
    }
    //verifica la existencia de un char especifico dentro de la bolsa de letras
    public boolean existletra(String letra){
        if(limiteactual > 0){
        for (int i=0; i<limiteactual ; i++)
            if (letras[i].getLetra().equals(letra)){
                return true;
            }
        }
    return false;
    }
    //Arroja la ubicacion de la primera letra que encuentre con este tipo.
    public int searchletraAt(String letra){
        if(limiteactual > 0){
        for (int i=0; i<limiteactual ; i++)
            if (letras[i].getLetra().equals(letra)){
                return i;
            }
        }
    return -1;
    }
    //Elimina la letra que encuentre con este tipo, y las que le siguen se corren
    //como en una pila
    public void quitarUnaLetra(String letra){
        int s;
        if (existletra(letra)){
        s = searchletraAt(letra);
           if(limiteactual == 0) limiteactual=-1;
            else if (limiteactual == 1)limiteactual=0;
            else{                
                for (int i=s; i<limiteactual-1;i++){
                letras[i] = letras[i+1];}
                limiteactual--;
                }
            }
    }

    //Realiza todo lo que implica sacar una ficha de la bolsa
    //para ello busca una letra aleatoriamente,
    //actualiza la bolsa y lanza la letra
    public Letra sacarFicha(){
        Letra l = new Letra();
        if (limiteactual == 0){System.out.println("<Error : 'La bolsa esta vacia'.>");}
        else{
        l = this.getLetraAt(ubicacionAleatoria());
        this.quitarUnaLetra(l.getLetra());}

        return l;
    }

    //Lanza una ubicacion dentro de la bolsa que este dentro del rango
    //de la cantidad de fichas hasta el momento
    public int ubicacionAleatoria(){
        return (int) Math.floor(Math.random() * (limiteactual));
    }

    public int getCantFichasEnLaBolsa(){return limiteactual;}

    public static void main(String args[]){
    }

}
