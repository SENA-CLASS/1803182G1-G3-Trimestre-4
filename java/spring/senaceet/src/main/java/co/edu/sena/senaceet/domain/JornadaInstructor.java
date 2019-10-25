/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "jornada_Instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JornadaInstructor.findAll", query = "SELECT j FROM JornadaInstructor j"),
    @NamedQuery(name = "JornadaInstructor.findById", query = "SELECT j FROM JornadaInstructor j WHERE j.id = :id"),
    @NamedQuery(name = "JornadaInstructor.findByNombreJornada", query = "SELECT j FROM JornadaInstructor j WHERE j.nombreJornada = :nombreJornada"),
    @NamedQuery(name = "JornadaInstructor.findByDescripcion", query = "SELECT j FROM JornadaInstructor j WHERE j.descripcion = :descripcion"),
    @NamedQuery(name = "JornadaInstructor.findByEstado", query = "SELECT j FROM JornadaInstructor j WHERE j.estado = :estado")})
public class JornadaInstructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_jornada")
    private String nombreJornada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idjornadaInstructor", fetch = FetchType.LAZY)
    private List<DisponibilidadHoraria> disponibilidadHorariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idjornadaInstructores", fetch = FetchType.LAZY)
    private List<DiaJornada> diaJornadaList;

    public JornadaInstructor() {
    }

    public JornadaInstructor(Integer id) {
        this.id = id;
    }

    public JornadaInstructor(Integer id, String nombreJornada, String descripcion, String estado) {
        this.id = id;
        this.nombreJornada = nombreJornada;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreJornada() {
        return nombreJornada;
    }

    public void setNombreJornada(String nombreJornada) {
        this.nombreJornada = nombreJornada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<DisponibilidadHoraria> getDisponibilidadHorariaList() {
        return disponibilidadHorariaList;
    }

    public void setDisponibilidadHorariaList(List<DisponibilidadHoraria> disponibilidadHorariaList) {
        this.disponibilidadHorariaList = disponibilidadHorariaList;
    }

    @XmlTransient
    public List<DiaJornada> getDiaJornadaList() {
        return diaJornadaList;
    }

    public void setDiaJornadaList(List<DiaJornada> diaJornadaList) {
        this.diaJornadaList = diaJornadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JornadaInstructor)) {
            return false;
        }
        JornadaInstructor other = (JornadaInstructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.JornadaInstructor[ id=" + id + " ]";
    }
    
}
