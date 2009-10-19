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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "usuario", catalog = "bdwordomination", schema = "")
@NamedQueries({@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"), @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"), @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass"), @NamedQuery(name = "Usuario.findByPuntuacion", query = "SELECT u FROM Usuario u WHERE u.puntuacion = :puntuacion")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "pass", nullable = false, length = 30)
    private String pass;
    @Column(name = "puntuacion")
    private Integer puntuacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador1")
    private Collection<Partida> partidaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador2")
    private Collection<Partida> partidaCollection1;
    @OneToMany(mappedBy = "jugador3")
    private Collection<Partida> partidaCollection2;
    @OneToMany(mappedBy = "jugador4")
    private Collection<Partida> partidaCollection3;
    @OneToOne
    private Cuadro propietario;

    public Usuario() {
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Collection<Partida> getPartidaCollection() {
        return partidaCollection;
    }

    public void setPartidaCollection(Collection<Partida> partidaCollection) {
        this.partidaCollection = partidaCollection;
    }

    public Collection<Partida> getPartidaCollection1() {
        return partidaCollection1;
    }

    public void setPartidaCollection1(Collection<Partida> partidaCollection1) {
        this.partidaCollection1 = partidaCollection1;
    }

    public Collection<Partida> getPartidaCollection2() {
        return partidaCollection2;
    }

    public void setPartidaCollection2(Collection<Partida> partidaCollection2) {
        this.partidaCollection2 = partidaCollection2;
    }

    public Collection<Partida> getPartidaCollection3() {
        return partidaCollection3;
    }

    public void setPartidaCollection3(Collection<Partida> partidaCollection3) {
        this.partidaCollection3 = partidaCollection3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wordominaton.Usuario[nombre=" + nombre + "]";
    }

}
