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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findById", query = "SELECT f FROM Ficha f WHERE f.id = :id"),
    @NamedQuery(name = "Ficha.findByNumeroFicha", query = "SELECT f FROM Ficha f WHERE f.numeroFicha = :numeroFicha"),
    @NamedQuery(name = "Ficha.findByFechaInicio", query = "SELECT f FROM Ficha f WHERE f.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Ficha.findByFechaFin", query = "SELECT f FROM Ficha f WHERE f.fechaFin = :fechaFin"),
    @NamedQuery(name = "Ficha.findByRuta", query = "SELECT f FROM Ficha f WHERE f.ruta = :ruta")})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_ficha")
    private String numeroFicha;
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
    @Column(name = "ruta")
    private String ruta;
    @ManyToMany(mappedBy = "fichaList", fetch = FetchType.LAZY)
    private List<ListaChequeo> listaChequeoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha", fetch = FetchType.LAZY)
    private List<FichaHasTrimestre> fichaHasTrimestreList;
    @JoinColumns({
        @JoinColumn(name = "id_estado_ficha", referencedColumnName = "id"),
        @JoinColumn(name = "id_estado_ficha", referencedColumnName = "id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoFicha estadoFicha;
    @JoinColumn(name = "id_jornada", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jornada idJornada;
    @JoinColumns({
        @JoinColumn(name = "id_programa", referencedColumnName = "id"),
        @JoinColumn(name = "id_programa", referencedColumnName = "id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programa programa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha", fetch = FetchType.LAZY)
    private List<GrupoProyecto> grupoProyectoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ficha", fetch = FetchType.LAZY)
    private Aprendiz aprendiz;

    public Ficha() {
    }

    public Ficha(Integer id) {
        this.id = id;
    }

    public Ficha(Integer id, String numeroFicha, Date fechaInicio, Date fechaFin, String ruta) {
        this.id = id;
        this.numeroFicha = numeroFicha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ruta = ruta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @XmlTransient
    public List<ListaChequeo> getListaChequeoList() {
        return listaChequeoList;
    }

    public void setListaChequeoList(List<ListaChequeo> listaChequeoList) {
        this.listaChequeoList = listaChequeoList;
    }

    @XmlTransient
    public List<FichaHasTrimestre> getFichaHasTrimestreList() {
        return fichaHasTrimestreList;
    }

    public void setFichaHasTrimestreList(List<FichaHasTrimestre> fichaHasTrimestreList) {
        this.fichaHasTrimestreList = fichaHasTrimestreList;
    }

    public EstadoFicha getEstadoFicha() {
        return estadoFicha;
    }

    public void setEstadoFicha(EstadoFicha estadoFicha) {
        this.estadoFicha = estadoFicha;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @XmlTransient
    public List<GrupoProyecto> getGrupoProyectoList() {
        return grupoProyectoList;
    }

    public void setGrupoProyectoList(List<GrupoProyecto> grupoProyectoList) {
        this.grupoProyectoList = grupoProyectoList;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
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
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.Ficha[ id=" + id + " ]";
    }
    
}
