/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "actividad_planeacion")
public class ActividadPlaneacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumns({
        @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id"),
        @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ActividadProyecto actividadProyecto;
    @JoinColumn(name = "id_programacion_trimestre", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProgramacionTrimestre idProgramacionTrimestre;

    public ActividadPlaneacion() {
    }

    public ActividadPlaneacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ActividadProyecto getActividadProyecto() {
        return actividadProyecto;
    }

    public void setActividadProyecto(ActividadProyecto actividadProyecto) {
        this.actividadProyecto = actividadProyecto;
    }

    public ProgramacionTrimestre getIdProgramacionTrimestre() {
        return idProgramacionTrimestre;
    }

    public void setIdProgramacionTrimestre(ProgramacionTrimestre idProgramacionTrimestre) {
        this.idProgramacionTrimestre = idProgramacionTrimestre;
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
        if (!(object instanceof ActividadPlaneacion)) {
            return false;
        }
        ActividadPlaneacion other = (ActividadPlaneacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ActividadPlaneacion[ id=" + id + " ]";
    }
    
}
