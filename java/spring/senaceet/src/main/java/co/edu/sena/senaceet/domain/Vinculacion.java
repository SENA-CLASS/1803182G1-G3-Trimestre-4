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
@Table(name = "vinculacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vinculacion.findAll", query = "SELECT v FROM Vinculacion v"),
    @NamedQuery(name = "Vinculacion.findById", query = "SELECT v FROM Vinculacion v WHERE v.id = :id"),
    @NamedQuery(name = "Vinculacion.findByTipoVinculacion", query = "SELECT v FROM Vinculacion v WHERE v.tipoVinculacion = :tipoVinculacion"),
    @NamedQuery(name = "Vinculacion.findByHoras", query = "SELECT v FROM Vinculacion v WHERE v.horas = :horas"),
    @NamedQuery(name = "Vinculacion.findByEstado", query = "SELECT v FROM Vinculacion v WHERE v.estado = :estado")})
public class Vinculacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "tipo_vinculacion")
    private String tipoVinculacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horas")
    private int horas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVinculacion", fetch = FetchType.LAZY)
    private List<VinculacionInstructor> vinculacionInstructorList;

    public Vinculacion() {
    }

    public Vinculacion(Integer id) {
        this.id = id;
    }

    public Vinculacion(Integer id, String tipoVinculacion, int horas, String estado) {
        this.id = id;
        this.tipoVinculacion = tipoVinculacion;
        this.horas = horas;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoVinculacion() {
        return tipoVinculacion;
    }

    public void setTipoVinculacion(String tipoVinculacion) {
        this.tipoVinculacion = tipoVinculacion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<VinculacionInstructor> getVinculacionInstructorList() {
        return vinculacionInstructorList;
    }

    public void setVinculacionInstructorList(List<VinculacionInstructor> vinculacionInstructorList) {
        this.vinculacionInstructorList = vinculacionInstructorList;
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
        if (!(object instanceof Vinculacion)) {
            return false;
        }
        Vinculacion other = (Vinculacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.Vinculacion[ id=" + id + " ]";
    }
    
}
