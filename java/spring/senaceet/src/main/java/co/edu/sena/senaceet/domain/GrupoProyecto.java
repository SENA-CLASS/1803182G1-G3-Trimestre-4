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
import javax.persistence.ManyToOne;
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
@Table(name = "grupo_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoProyecto.findAll", query = "SELECT g FROM GrupoProyecto g"),
    @NamedQuery(name = "GrupoProyecto.findById", query = "SELECT g FROM GrupoProyecto g WHERE g.id = :id"),
    @NamedQuery(name = "GrupoProyecto.findByNumeroGrupo", query = "SELECT g FROM GrupoProyecto g WHERE g.numeroGrupo = :numeroGrupo"),
    @NamedQuery(name = "GrupoProyecto.findByNombreProyecto", query = "SELECT g FROM GrupoProyecto g WHERE g.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "GrupoProyecto.findByEstado", query = "SELECT g FROM GrupoProyecto g WHERE g.estado = :estado")})
public class GrupoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_grupo")
    private int numeroGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "grupoProyecto", fetch = FetchType.LAZY)
    private IntegrantesGrupo integrantesGrupo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "grupoProyecto", fetch = FetchType.LAZY)
    private ObservacionGeneral observacionGeneral;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha idFicha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "grupoProyecto", fetch = FetchType.LAZY)
    private RespuestaGrupo respuestaGrupo;

    public GrupoProyecto() {
    }

    public GrupoProyecto(Integer id) {
        this.id = id;
    }

    public GrupoProyecto(Integer id, int numeroGrupo, String nombreProyecto, String estado) {
        this.id = id;
        this.numeroGrupo = numeroGrupo;
        this.nombreProyecto = nombreProyecto;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public IntegrantesGrupo getIntegrantesGrupo() {
        return integrantesGrupo;
    }

    public void setIntegrantesGrupo(IntegrantesGrupo integrantesGrupo) {
        this.integrantesGrupo = integrantesGrupo;
    }

    public ObservacionGeneral getObservacionGeneral() {
        return observacionGeneral;
    }

    public void setObservacionGeneral(ObservacionGeneral observacionGeneral) {
        this.observacionGeneral = observacionGeneral;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    public RespuestaGrupo getRespuestaGrupo() {
        return respuestaGrupo;
    }

    public void setRespuestaGrupo(RespuestaGrupo respuestaGrupo) {
        this.respuestaGrupo = respuestaGrupo;
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
        if (!(object instanceof GrupoProyecto)) {
            return false;
        }
        GrupoProyecto other = (GrupoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.GrupoProyecto[ id=" + id + " ]";
    }
    
}
