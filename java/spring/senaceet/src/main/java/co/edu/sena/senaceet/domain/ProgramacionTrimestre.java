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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "programacion_trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramacionTrimestre.findAll", query = "SELECT p FROM ProgramacionTrimestre p"),
    @NamedQuery(name = "ProgramacionTrimestre.findById", query = "SELECT p FROM ProgramacionTrimestre p WHERE p.id = :id")})
public class ProgramacionTrimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_planeacion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Planeacion idPlaneacion;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoAprendizaje idResultadoAprendizaje;
    @JoinColumn(name = "id_trimestre", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trimestre idTrimestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProgramacionTrimestre", fetch = FetchType.LAZY)
    private List<ActividadPlaneacion> actividadPlaneacionList;

    public ProgramacionTrimestre() {
    }

    public ProgramacionTrimestre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Planeacion getIdPlaneacion() {
        return idPlaneacion;
    }

    public void setIdPlaneacion(Planeacion idPlaneacion) {
        this.idPlaneacion = idPlaneacion;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public Trimestre getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Trimestre idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    @XmlTransient
    public List<ActividadPlaneacion> getActividadPlaneacionList() {
        return actividadPlaneacionList;
    }

    public void setActividadPlaneacionList(List<ActividadPlaneacion> actividadPlaneacionList) {
        this.actividadPlaneacionList = actividadPlaneacionList;
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
        if (!(object instanceof ProgramacionTrimestre)) {
            return false;
        }
        ProgramacionTrimestre other = (ProgramacionTrimestre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ProgramacionTrimestre[ id=" + id + " ]";
    }
    
}
