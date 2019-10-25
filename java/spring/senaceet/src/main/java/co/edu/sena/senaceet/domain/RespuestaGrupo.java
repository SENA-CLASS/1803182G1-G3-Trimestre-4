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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "respuesta_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespuestaGrupo.findAll", query = "SELECT r FROM RespuestaGrupo r"),
    @NamedQuery(name = "RespuestaGrupo.findById", query = "SELECT r FROM RespuestaGrupo r WHERE r.id = :id"),
    @NamedQuery(name = "RespuestaGrupo.findByFecha", query = "SELECT r FROM RespuestaGrupo r WHERE r.fecha = :fecha")})
public class RespuestaGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "respuestaGrupo", fetch = FetchType.LAZY)
    private ObservacionRespuesta observacionRespuesta;
    @JoinColumns({
        @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id"),
        @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto grupoProyecto;
    @JoinColumns({
        @JoinColumn(name = "id_item_lista", referencedColumnName = "id"),
        @JoinColumn(name = "id_item_lista", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ItemLista itemLista;
    @JoinColumns({
        @JoinColumn(name = "id_valoracion", referencedColumnName = "id"),
        @JoinColumn(name = "id_valoracion", referencedColumnName = "id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Valoracion valoracion;

    public RespuestaGrupo() {
    }

    public RespuestaGrupo(Integer id) {
        this.id = id;
    }

    public RespuestaGrupo(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ObservacionRespuesta getObservacionRespuesta() {
        return observacionRespuesta;
    }

    public void setObservacionRespuesta(ObservacionRespuesta observacionRespuesta) {
        this.observacionRespuesta = observacionRespuesta;
    }

    public GrupoProyecto getGrupoProyecto() {
        return grupoProyecto;
    }

    public void setGrupoProyecto(GrupoProyecto grupoProyecto) {
        this.grupoProyecto = grupoProyecto;
    }

    public ItemLista getItemLista() {
        return itemLista;
    }

    public void setItemLista(ItemLista itemLista) {
        this.itemLista = itemLista;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
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
        if (!(object instanceof RespuestaGrupo)) {
            return false;
        }
        RespuestaGrupo other = (RespuestaGrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.RespuestaGrupo[ id=" + id + " ]";
    }
    
}
