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
@Table(name = "observacion_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionRespuesta.findAll", query = "SELECT o FROM ObservacionRespuesta o"),
    @NamedQuery(name = "ObservacionRespuesta.findById", query = "SELECT o FROM ObservacionRespuesta o WHERE o.id = :id"),
    @NamedQuery(name = "ObservacionRespuesta.findByNumeroObservacion", query = "SELECT o FROM ObservacionRespuesta o WHERE o.numeroObservacion = :numeroObservacion"),
    @NamedQuery(name = "ObservacionRespuesta.findByObsevacion", query = "SELECT o FROM ObservacionRespuesta o WHERE o.obsevacion = :obsevacion"),
    @NamedQuery(name = "ObservacionRespuesta.findByJurados", query = "SELECT o FROM ObservacionRespuesta o WHERE o.jurados = :jurados"),
    @NamedQuery(name = "ObservacionRespuesta.findByFecha", query = "SELECT o FROM ObservacionRespuesta o WHERE o.fecha = :fecha")})
public class ObservacionRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_observacion")
    private int numeroObservacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "obsevacion")
    private String obsevacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "jurados")
    private String jurados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumns({
        @JoinColumn(name = "id_respuesta_grupo", referencedColumnName = "id"),
        @JoinColumn(name = "id_respuesta_grupo", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private RespuestaGrupo respuestaGrupo;

    public ObservacionRespuesta() {
    }

    public ObservacionRespuesta(Integer id) {
        this.id = id;
    }

    public ObservacionRespuesta(Integer id, int numeroObservacion, String obsevacion, String jurados, Date fecha) {
        this.id = id;
        this.numeroObservacion = numeroObservacion;
        this.obsevacion = obsevacion;
        this.jurados = jurados;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroObservacion() {
        return numeroObservacion;
    }

    public void setNumeroObservacion(int numeroObservacion) {
        this.numeroObservacion = numeroObservacion;
    }

    public String getObsevacion() {
        return obsevacion;
    }

    public void setObsevacion(String obsevacion) {
        this.obsevacion = obsevacion;
    }

    public String getJurados() {
        return jurados;
    }

    public void setJurados(String jurados) {
        this.jurados = jurados;
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
        if (!(object instanceof ObservacionRespuesta)) {
            return false;
        }
        ObservacionRespuesta other = (ObservacionRespuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ObservacionRespuesta[ id=" + id + " ]";
    }
    
}
