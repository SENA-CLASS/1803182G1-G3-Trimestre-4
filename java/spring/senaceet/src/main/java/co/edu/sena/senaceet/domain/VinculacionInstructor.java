/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "vinculacion_instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VinculacionInstructor.findAll", query = "SELECT v FROM VinculacionInstructor v"),
    @NamedQuery(name = "VinculacionInstructor.findById", query = "SELECT v FROM VinculacionInstructor v WHERE v.id = :id"),
    @NamedQuery(name = "VinculacionInstructor.findByFechaInicio", query = "SELECT v FROM VinculacionInstructor v WHERE v.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "VinculacionInstructor.findByFechaFin", query = "SELECT v FROM VinculacionInstructor v WHERE v.fechaFin = :fechaFin")})
public class VinculacionInstructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVinculacionInstructor", fetch = FetchType.LAZY)
    private List<DisponibilidadCompetencias> disponibilidadCompetenciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVinculacionInstructor", fetch = FetchType.LAZY)
    private List<DisponibilidadHoraria> disponibilidadHorariaList;
    @JoinColumn(name = "id_instructor", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Instructor idInstructor;
    @JoinColumn(name = "id_vinculacion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vinculacion idVinculacion;
    @JoinColumn(name = "id_year", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Year idYear;

    public VinculacionInstructor() {
    }

    public VinculacionInstructor(Integer id) {
        this.id = id;
    }

    public VinculacionInstructor(Integer id, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<DisponibilidadCompetencias> getDisponibilidadCompetenciasList() {
        return disponibilidadCompetenciasList;
    }

    public void setDisponibilidadCompetenciasList(List<DisponibilidadCompetencias> disponibilidadCompetenciasList) {
        this.disponibilidadCompetenciasList = disponibilidadCompetenciasList;
    }

    @XmlTransient
    public List<DisponibilidadHoraria> getDisponibilidadHorariaList() {
        return disponibilidadHorariaList;
    }

    public void setDisponibilidadHorariaList(List<DisponibilidadHoraria> disponibilidadHorariaList) {
        this.disponibilidadHorariaList = disponibilidadHorariaList;
    }

    public Instructor getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Instructor idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Vinculacion getIdVinculacion() {
        return idVinculacion;
    }

    public void setIdVinculacion(Vinculacion idVinculacion) {
        this.idVinculacion = idVinculacion;
    }

    public Year getIdYear() {
        return idYear;
    }

    public void setIdYear(Year idYear) {
        this.idYear = idYear;
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
        if (!(object instanceof VinculacionInstructor)) {
            return false;
        }
        VinculacionInstructor other = (VinculacionInstructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.VinculacionInstructor[ id=" + id + " ]";
    }
    
}
