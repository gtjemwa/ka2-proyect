/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDWorDomination;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.JLabel;

/**
 *
 * @author Andrés
 * Son las fichas individuales que se guardan en la bolsadeletras
 */
@Entity
@Table(name = "cuadro", catalog = "bdwordomination", schema = "")
@NamedQueries({@NamedQuery(name = "Cuadro.findAll", query = "SELECT c FROM Cuadro c"), @NamedQuery(name = "Cuadro.findByUbicacion", query = "SELECT c FROM Cuadro c WHERE c.ubicacion = :ubicacion"), @NamedQuery(name = "Cuadro.findByLetra", query = "SELECT c FROM Cuadro c WHERE c.letra = :letra")})
public class Cuadro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ubicacion", nullable = false)
    private Ubicacion ubicacion;
    @Basic(optional = false)
    @Column(name = "letra", nullable = false)
    @ManyToOne
    private Letra letra;
    @JoinColumn(name = "nombrecuadrilla", referencedColumnName = "nombrecuadrilla", nullable = false)
    @ManyToOne(optional = false)
    private Cuadrilla nombrecuadrilla;
    @Basic(optional = false)
    @Column(name = "propietario", nullable = true)
    @OneToOne(mappedBy = "propietario")
    private Usuario propietario;
    //el atributo de abajo permite saber si esta en la mano del jugador
    //o ya fue puesta en la cuadrilla
    private boolean incuadrilla;

    public Cuadro() {
    }

    public Cuadro(int X,int Y) {
        ubicacion = new Ubicacion(X, Y);
        incuadrilla = false;
        this.letra.setLetra("");
        this.letra.setUrlimagen("");
        this.letra.setPuntuacionletra(0);
    }
    public Cuadro(int X,int Y, Letra letra) {
        ubicacion = new Ubicacion(X, Y);
        incuadrilla = false;
        this.letra = letra;
    }
    public Cuadro(Ubicacion ub, Letra letra) {
        this.ubicacion = ub;
        incuadrilla = false;
        this.letra = letra;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public Cuadrilla getNombrecuadrilla() {
        return nombrecuadrilla;
    }

    public void setNombrecuadrilla(Cuadrilla nombrecuadrilla) {
        this.nombrecuadrilla = nombrecuadrilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubicacion != null ? ubicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuadro)) {
            return false;
        }
        Cuadro other = (Cuadro) object;
        if ((this.ubicacion == null && other.ubicacion != null) || (this.ubicacion != null && !this.ubicacion.equals(other.ubicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wordominaton.Cuadro[ubicacion=" + ubicacion + "]";
    }

    /**
     * @return the propietario
     */
    public Usuario getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public boolean isInCuadrilla(){return incuadrilla;}

    public void setInCuadrilla(boolean in){incuadrilla = in;}

}
