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
import javax.persistence.Table;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "partida", catalog = "bdwordomination", schema = "")
@NamedQueries({@NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"), @NamedQuery(name = "Partida.findByIDpartida", query = "SELECT p FROM Partida p WHERE p.iDpartida = :iDpartida")})
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDpartida", nullable = false)
    private Integer iDpartida;
    @JoinColumn(name = "nombrecuadrilla", referencedColumnName = "nombrecuadrilla", nullable = false)
    @ManyToOne(optional = false)
    private Cuadrilla nombrecuadrilla;
    @JoinColumn(name = "Jugador1", referencedColumnName = "nombre", nullable = false)
    @ManyToOne(optional = false)
    private Usuario jugador1;
    @JoinColumn(name = "Jugador2", referencedColumnName = "nombre", nullable = false)
    @ManyToOne(optional = false)
    private Usuario jugador2;
    @JoinColumn(name = "Jugador3", referencedColumnName = "nombre")
    @ManyToOne
    private Usuario jugador3;
    @JoinColumn(name = "Jugador4", referencedColumnName = "nombre")
    @ManyToOne
    private Usuario jugador4;

    public Partida() {
    }

    public Partida(Integer iDpartida) {
        this.iDpartida = iDpartida;
    }

    public Integer getIDpartida() {
        return iDpartida;
    }

    public void setIDpartida(Integer iDpartida) {
        this.iDpartida = iDpartida;
    }

    public Cuadrilla getNombrecuadrilla() {
        return nombrecuadrilla;
    }

    public void setNombrecuadrilla(Cuadrilla nombrecuadrilla) {
        this.nombrecuadrilla = nombrecuadrilla;
    }

    public Usuario getJugador1() {
        return jugador1;
    }

    public void setJugador1(Usuario jugador1) {
        this.jugador1 = jugador1;
    }

    public Usuario getJugador2() {
        return jugador2;
    }

    public void setJugador2(Usuario jugador2) {
        this.jugador2 = jugador2;
    }

    public Usuario getJugador3() {
        return jugador3;
    }

    public void setJugador3(Usuario jugador3) {
        this.jugador3 = jugador3;
    }

    public Usuario getJugador4() {
        return jugador4;
    }

    public void setJugador4(Usuario jugador4) {
        this.jugador4 = jugador4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDpartida != null ? iDpartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.iDpartida == null && other.iDpartida != null) || (this.iDpartida != null && !this.iDpartida.equals(other.iDpartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BDWordominaton.Partida[iDpartida=" + iDpartida + "]";
    }

}
