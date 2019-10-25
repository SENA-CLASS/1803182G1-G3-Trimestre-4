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
@Table(name = "resultado_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoAprendizaje.findAll", query = "SELECT r FROM ResultadoAprendizaje r"),
    @NamedQuery(name = "ResultadoAprendizaje.findById", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.id = :id"),
    @NamedQuery(name = "ResultadoAprendizaje.findByCodigoResultado", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.codigoResultado = :codigoResultado"),
    @NamedQuery(name = "ResultadoAprendizaje.findByDenominacion", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.denominacion = :denominacion")})
public class ResultadoAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "codigo_resultado")
    private String codigoResultado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "denominacion")
    private String denominacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje", fetch = FetchType.LAZY)
    private List<ProgramacionTrimestre> programacionTrimestreList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "resultadoAprendizaje", fetch = FetchType.LAZY)
    private ResultadosVistos resultadosVistos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "resultadoAprendizaje", fetch = FetchType.LAZY)
    private LimitacionAmbiente limitacionAmbiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultadoAprendizaje", fetch = FetchType.LAZY)
    private List<ItemLista> itemListaList;
    @JoinColumns({
        @JoinColumn(name = "id_competencia", referencedColumnName = "id"),
        @JoinColumn(name = "id_competencia", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Competencia competencia;

    public ResultadoAprendizaje() {
    }

    public ResultadoAprendizaje(Integer id) {
        this.id = id;
    }

    public ResultadoAprendizaje(Integer id, String codigoResultado, String denominacion) {
        this.id = id;
        this.codigoResultado = codigoResultado;
        this.denominacion = denominacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(String codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @XmlTransient
    public List<ProgramacionTrimestre> getProgramacionTrimestreList() {
        return programacionTrimestreList;
    }

    public void setProgramacionTrimestreList(List<ProgramacionTrimestre> programacionTrimestreList) {
        this.programacionTrimestreList = programacionTrimestreList;
    }

    public ResultadosVistos getResultadosVistos() {
        return resultadosVistos;
    }

    public void setResultadosVistos(ResultadosVistos resultadosVistos) {
        this.resultadosVistos = resultadosVistos;
    }

    public LimitacionAmbiente getLimitacionAmbiente() {
        return limitacionAmbiente;
    }

    public void setLimitacionAmbiente(LimitacionAmbiente limitacionAmbiente) {
        this.limitacionAmbiente = limitacionAmbiente;
    }

    @XmlTransient
    public List<ItemLista> getItemListaList() {
        return itemListaList;
    }

    public void setItemListaList(List<ItemLista> itemListaList) {
        this.itemListaList = itemListaList;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
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
        if (!(object instanceof ResultadoAprendizaje)) {
            return false;
        }
        ResultadoAprendizaje other = (ResultadoAprendizaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ResultadoAprendizaje[ id=" + id + " ]";
    }
    
}
