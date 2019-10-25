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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambiente.findAll", query = "SELECT a FROM Ambiente a"),
    @NamedQuery(name = "Ambiente.findById", query = "SELECT a FROM Ambiente a WHERE a.id = :id"),
    @NamedQuery(name = "Ambiente.findByNumeroAmbiente", query = "SELECT a FROM Ambiente a WHERE a.numeroAmbiente = :numeroAmbiente"),
    @NamedQuery(name = "Ambiente.findByDescripcion", query = "SELECT a FROM Ambiente a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Ambiente.findByEstado", query = "SELECT a FROM Ambiente a WHERE a.estado = :estado"),
    @NamedQuery(name = "Ambiente.findByLimitacion", query = "SELECT a FROM Ambiente a WHERE a.limitacion = :limitacion")})
public class Ambiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero_ambiente")
    private String numeroAmbiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "limitacion")
    private String limitacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ambiente", fetch = FetchType.LAZY)
    private List<Horario> horarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ambiente", fetch = FetchType.LAZY)
    private LimitacionAmbiente limitacionAmbiente;
    @JoinColumns({
        @JoinColumn(name = "id_sede", referencedColumnName = "id"),
        @JoinColumn(name = "id_sede", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Sede sede;
    @JoinColumns({
        @JoinColumn(name = "id_tipo_ambiente", referencedColumnName = "id"),
        @JoinColumn(name = "id_tipo_ambiente", referencedColumnName = "id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoAmbiente tipoAmbiente;

    public Ambiente() {
    }

    public Ambiente(Integer id) {
        this.id = id;
    }

    public Ambiente(Integer id, String numeroAmbiente, String descripcion, String estado, String limitacion) {
        this.id = id;
        this.numeroAmbiente = numeroAmbiente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.limitacion = limitacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroAmbiente() {
        return numeroAmbiente;
    }

    public void setNumeroAmbiente(String numeroAmbiente) {
        this.numeroAmbiente = numeroAmbiente;
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

    public String getLimitacion() {
        return limitacion;
    }

    public void setLimitacion(String limitacion) {
        this.limitacion = limitacion;
    }

    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public LimitacionAmbiente getLimitacionAmbiente() {
        return limitacionAmbiente;
    }

    public void setLimitacionAmbiente(LimitacionAmbiente limitacionAmbiente) {
        this.limitacionAmbiente = limitacionAmbiente;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public TipoAmbiente getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
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
        if (!(object instanceof Ambiente)) {
            return false;
        }
        Ambiente other = (Ambiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.Ambiente[ id=" + id + " ]";
    }
    
}
