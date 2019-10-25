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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "disponibilidad_competencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibilidadCompetencias.findAll", query = "SELECT d FROM DisponibilidadCompetencias d"),
    @NamedQuery(name = "DisponibilidadCompetencias.findById", query = "SELECT d FROM DisponibilidadCompetencias d WHERE d.id = :id")})
public class DisponibilidadCompetencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Competencia idCompetencia;
    @JoinColumn(name = "id_vinculacion_instructor", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private VinculacionInstructor idVinculacionInstructor;

    public DisponibilidadCompetencias() {
    }

    public DisponibilidadCompetencias(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public VinculacionInstructor getIdVinculacionInstructor() {
        return idVinculacionInstructor;
    }

    public void setIdVinculacionInstructor(VinculacionInstructor idVinculacionInstructor) {
        this.idVinculacionInstructor = idVinculacionInstructor;
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
        if (!(object instanceof DisponibilidadCompetencias)) {
            return false;
        }
        DisponibilidadCompetencias other = (DisponibilidadCompetencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.DisponibilidadCompetencias[ id=" + id + " ]";
    }
    
}
