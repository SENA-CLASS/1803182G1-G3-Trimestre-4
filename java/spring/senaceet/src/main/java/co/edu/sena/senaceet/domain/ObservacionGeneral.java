/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.domain;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "observacion_general")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionGeneral.findAll", query = "SELECT o FROM ObservacionGeneral o"),
    @NamedQuery(name = "ObservacionGeneral.findById", query = "SELECT o FROM ObservacionGeneral o WHERE o.id = :id"),
    @NamedQuery(name = "ObservacionGeneral.findByNumero", query = "SELECT o FROM ObservacionGeneral o WHERE o.numero = :numero"),
    @NamedQuery(name = "ObservacionGeneral.findByObservacion", query = "SELECT o FROM ObservacionGeneral o WHERE o.observacion = :observacion"),
    @NamedQuery(name = "ObservacionGeneral.findByJurado", query = "SELECT o FROM ObservacionGeneral o WHERE o.jurado = :jurado"),
    @NamedQuery(name = "ObservacionGeneral.findByFecha", query = "SELECT o FROM ObservacionGeneral o WHERE o.fecha = :fecha")})
public class ObservacionGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "jurado")
    private String jurado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumns({
        @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id"),
        @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto grupoProyecto;

    public ObservacionGeneral() {
    }

    public ObservacionGeneral(Integer id) {
        this.id = id;
    }

    public ObservacionGeneral(Integer id, int numero, String observacion, String jurado, Date fecha) {
        this.id = id;
        this.numero = numero;
        this.observacion = observacion;
        this.jurado = jurado;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getJurado() {
        return jurado;
    }

    public void setJurado(String jurado) {
        this.jurado = jurado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public GrupoProyecto getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
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
        if (!(object instanceof ObservacionGeneral)) {
            return false;
        }
        ObservacionGeneral other = (ObservacionGeneral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ObservacionGeneral[ id=" + id + " ]";
    }
    
}
