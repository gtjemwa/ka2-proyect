/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDWorDomination;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "letra")
@NamedQueries({@NamedQuery(name = "Letra.findAll", query = "SELECT l FROM Letra l"), @NamedQuery(name = "Letra.findByLetra", query = "SELECT l FROM Letra l WHERE l.letra = :letra"), @NamedQuery(name = "Letra.findByUrlimagen", query = "SELECT l FROM Letra l WHERE l.urlimagen = :urlimagen"), @NamedQuery(name = "Letra.findByPuntuacionletra", query = "SELECT l FROM Letra l WHERE l.puntuacionletra = :puntuacionletra")})
public class Letra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "letra", nullable = false)
    private String letra;
    @Basic(optional = false)
    @Column(name = "urlimagen", nullable = false, length = 50)
    private String urlimagen;
    @Basic(optional = false)
    @Column(name = "puntuacionletra", nullable = false)
    private int puntuacionletra;


    public Letra() {
        this.letra = null;
        this.urlimagen = "";
        this.puntuacionletra = 0;
    }

    public Letra(String letra) {
        this.letra = letra;
        this.urlimagen = "";
        this.puntuacionletra = 0;
    }

    public Letra(String letra, String urlimagen, int puntuacionletra) {
        this.letra = letra;
        this.urlimagen = urlimagen;
        this.puntuacionletra = puntuacionletra;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public int getPuntuacionletra() {
        return puntuacionletra;
    }

    public void setPuntuacionletra(int puntuacionletra) {
        this.puntuacionletra = puntuacionletra;
    }

    @Override
    public String toString() {
        return "BDWorDomination.Letra[letra=" + letra + "]";
    }

}
