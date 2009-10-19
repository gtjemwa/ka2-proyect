/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Diccionario;

import BDWorDomination.Persistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrés
 */
public class WordVerify {

    public WordVerify() {    
    }
    protected String mainword;
    protected String src ;
    /**
     * Get the value of mainword
     *
     * @return the value of mainword
     */
    public String getMainword() {
        return mainword;
    }

    /**
     * Set the value of mainword
     *
     * @param mainword new value of mainword
     */
    public void setMainword(String mainword) {
        this.mainword = mainword;
    }

    //Check word with own dictionary
    public boolean isCorrect(String mainword) {
    boolean b = false;
    this.mainword = mainword.toLowerCase();
    Persistencia p = new Persistencia();
        try {
            if (((ArrayList)(p.selectSQL("select palabra from diccionario where palabra ='"+this.mainword+"'", 1))).size() != 0)
            b = true;
        } catch (SQLException ex) {
            Logger.getLogger(WordVerify.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    public boolean isCorrectMainWord(){return isCorrect(mainword);}

    //this method is for to verify if the word has a Tilde
    public boolean hasTilde(){


    return false;
    }


 /*   public static void main( String[] args )
    {
        System.out.println(new WordVerify().isCorrect("queria"));
    }
*/
}

