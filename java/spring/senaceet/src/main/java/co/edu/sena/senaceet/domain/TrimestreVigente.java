/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "trimestre_vigente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrimestreVigente.findAll", query = "SELECT t FROM TrimestreVigente t"),
    @NamedQuery(name = "TrimestreVigente.findById", query = "SELECT t FROM TrimestreVigente t WHERE t.id = :id"),
    @NamedQuery(name = "TrimestreVigente.findByTrimestreProgramado", query = "SELECT t FROM TrimestreVigente t WHERE t.trimestreProgramado = :trimestreProgramado"),
    @NamedQuery(name = "TrimestreVigente.findByFechaInicio", query = "SELECT t FROM TrimestreVigente t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TrimestreVigente.findByFechaFin", query = "SELECT t FROM TrimestreVigente t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TrimestreVigente.findByEstado", query = "SELECT t FROM TrimestreVigente t WHERE t.estado = :estado")})
public class TrimestreVigente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trimestre_programado")
    private int trimestreProgramado;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trimestreVigente", fetch = FetchType.LAZY)
    private VersionHorario versionHorario;
    @JoinColumn(name = "id_year", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Year idYear;

    public TrimestreVigente() {
    }

    public TrimestreVigente(Integer id) {
        this.id = id;
    }

    public TrimestreVigente(Integer id, int trimestreProgramado, Date fechaInicio, Date fechaFin, String estado) {
        this.id = id;
        this.trimestreProgramado = trimestreProgramado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTrimestreProgramado() {
        return trimestreProgramado;
    }

    public void setTrimestreProgramado(int trimestreProgramado) {
        this.trimestreProgramado = trimestreProgramado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public VersionHorario getVersionHorario() {
        return versionHorario;
    }

    public void setVersionHorario(VersionHorario versionHorario) {
        this.versionHorario = versionHorario;
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
        if (!(object instanceof TrimestreVigente)) {
            return false;
        }
        TrimestreVigente other = (TrimestreVigente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.TrimestreVigente[ id=" + id + " ]";
    }
    
}
