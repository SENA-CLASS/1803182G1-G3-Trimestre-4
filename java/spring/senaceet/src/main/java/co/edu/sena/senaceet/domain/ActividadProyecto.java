/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "actividad_proyecto")
public class ActividadProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_actividad")
    private int numeroActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descipcion_actividad")
    private String descipcionActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "id_fase", referencedColumnName = "id"),
        @JoinColumn(name = "id_fase", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Fase fase;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actividadProyecto", fetch = FetchType.LAZY)
    private ActividadPlaneacion actividadPlaneacion;

    public ActividadProyecto() {
    }

    public ActividadProyecto(Integer id) {
        this.id = id;
    }

    public ActividadProyecto(Integer id, int numeroActividad, String descipcionActividad, String estado) {
        this.id = id;
        this.numeroActividad = numeroActividad;
        this.descipcionActividad = descipcionActividad;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroActividad() {
        return numeroActividad;
    }

    public void setNumeroActividad(int numeroActividad) {
        this.numeroActividad = numeroActividad;
    }

    public String getDescipcionActividad() {
        return descipcionActividad;
    }

    public void setDescipcionActividad(String descipcionActividad) {
        this.descipcionActividad = descipcionActividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public ActividadPlaneacion getActividadPlaneacion() {
        return actividadPlaneacion;
    }

    public void setActividadPlaneacion(ActividadPlaneacion actividadPlaneacion) {
        this.actividadPlaneacion = actividadPlaneacion;
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
        if (!(object instanceof ActividadProyecto)) {
            return false;
        }
        ActividadProyecto other = (ActividadProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ActividadProyecto[ id=" + id + " ]";
    }
    
}
