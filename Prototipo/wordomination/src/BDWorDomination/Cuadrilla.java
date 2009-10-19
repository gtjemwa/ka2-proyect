/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BDWorDomination;

import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "cuadrilla", catalog = "bdwordomination", schema = "")
@NamedQueries({@NamedQuery(name = "Cuadrilla.findAll", query = "SELECT c FROM Cuadrilla c"), @NamedQuery(name = "Cuadrilla.findByNombrecuadrilla", query = "SELECT c FROM Cuadrilla c WHERE c.nombrecuadrilla = :nombrecuadrilla"), @NamedQuery(name = "Cuadrilla.findByCuadrosHorizontales", query = "SELECT c FROM Cuadrilla c WHERE c.cuadrosHorizontales = :cuadrosHorizontales"), @NamedQuery(name = "Cuadrilla.findByCuadrosVerticales", query = "SELECT c FROM Cuadrilla c WHERE c.cuadrosVerticales = :cuadrosVerticales")})
public class Cuadrilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombrecuadrilla", nullable = false, length = 50)
    private String nombrecuadrilla;
    @Basic(optional = false)
    @Column(name = "cuadrosHorizontales", nullable = false)
    private int cuadrosHorizontales;
    @Basic(optional = false)
    @Column(name = "cuadrosVerticales", nullable = false)
    private int cuadrosVerticales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombrecuadrilla")
    private Collection<Partida> partidaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombrecuadrilla")
    private Collection<Cuadro> cuadroCollection;

    public Cuadrilla() {
    }

    public Cuadrilla(String nombrecuadrilla) {
        this.nombrecuadrilla = nombrecuadrilla;
    }

    public Cuadrilla(String nombrecuadrilla, int cuadrosHorizontales, int cuadrosVerticales) {
        this.nombrecuadrilla = nombrecuadrilla;
        this.cuadrosHorizontales = cuadrosHorizontales;
        this.cuadrosVerticales = cuadrosVerticales;
    }

    public String getNombrecuadrilla() {
        return nombrecuadrilla;
    }

    public void setNombrecuadrilla(String nombrecuadrilla) {
        this.nombrecuadrilla = nombrecuadrilla;
    }

    public int getCuadrosHorizontales() {
        return cuadrosHorizontales;
    }

    public void setCuadrosHorizontales(int cuadrosHorizontales) {
        this.cuadrosHorizontales = cuadrosHorizontales;
    }

    public int getCuadrosVerticales() {
        return cuadrosVerticales;
    }

    public void setCuadrosVerticales(int cuadrosVerticales) {
        this.cuadrosVerticales = cuadrosVerticales;
    }

    public Collection<Partida> getPartidaCollection() {
        return partidaCollection;
    }

    public void setPartidaCollection(Collection<Partida> partidaCollection) {
        this.partidaCollection = partidaCollection;
    }

    public Collection<Cuadro> getCuadroCollection() {
        return cuadroCollection;
    }

    public void setCuadroCollection(Collection<Cuadro> cuadroCollection) {
        this.cuadroCollection = cuadroCollection;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombrecuadrilla != null ? nombrecuadrilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuadrilla)) {
            return false;
        }
        Cuadrilla other = (Cuadrilla) object;
        if ((this.nombrecuadrilla == null && other.nombrecuadrilla != null) || (this.nombrecuadrilla != null && !this.nombrecuadrilla.equals(other.nombrecuadrilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wordominaton.Cuadrilla[nombrecuadrilla=" + nombrecuadrilla + "]";
    }

}