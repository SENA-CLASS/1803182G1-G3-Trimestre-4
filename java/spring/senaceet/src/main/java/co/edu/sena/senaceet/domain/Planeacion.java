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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "planeacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planeacion.findAll", query = "SELECT p FROM Planeacion p"),
    @NamedQuery(name = "Planeacion.findById", query = "SELECT p FROM Planeacion p WHERE p.id = :id"),
    @NamedQuery(name = "Planeacion.findByCodigo", query = "SELECT p FROM Planeacion p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Planeacion.findByFecha", query = "SELECT p FROM Planeacion p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Planeacion.findByEstado", query = "SELECT p FROM Planeacion p WHERE p.estado = :estado")})
public class Planeacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlaneacion", fetch = FetchType.LAZY)
    private List<ProgramacionTrimestre> programacionTrimestreList;

    public Planeacion() {
    }

    public Planeacion(Integer id) {
        this.id = id;
    }

    public Planeacion(Integer id, String codigo, Date fecha, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ProgramacionTrimestre> getProgramacionTrimestreList() {
        return programacionTrimestreList;
    }

    public void setProgramacionTrimestreList(List<ProgramacionTrimestre> programacionTrimestreList) {
        this.programacionTrimestreList = programacionTrimestreList;
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
        if (!(object instanceof Planeacion)) {
            return false;
        }
        Planeacion other = (Planeacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.Planeacion[ id=" + id + " ]";
    }
    
}
