/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.senaceet.domain;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "resultados_vistos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadosVistos.findAll", query = "SELECT r FROM ResultadosVistos r"),
    @NamedQuery(name = "ResultadosVistos.findById", query = "SELECT r FROM ResultadosVistos r WHERE r.id = :id")})
public class ResultadosVistos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumns({
        @JoinColumn(name = "id_ficha_has_trimestre", referencedColumnName = "id"),
        @JoinColumn(name = "id_ficha_has_trimestre", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private FichaHasTrimestre fichaHasTrimestre;
    @JoinColumns({
        @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id"),
        @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoAprendizaje resultadoAprendizaje;

    public ResultadosVistos() {
    }

    public ResultadosVistos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FichaHasTrimestre getFichaHasTrimestre() {
        return fichaHasTrimestre;
    }

    public void setFichaHasTrimestre(FichaHasTrimestre fichaHasTrimestre) {
        this.fichaHasTrimestre = fichaHasTrimestre;
    }

    public ResultadoAprendizaje getResultadoAprendizaje() {
        return resultadoAprendizaje;
    }

    public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
        this.resultadoAprendizaje = resultadoAprendizaje;
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
        if (!(object instanceof ResultadosVistos)) {
            return false;
        }
        ResultadosVistos other = (ResultadosVistos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ResultadosVistos[ id=" + id + " ]";
    }
    
}
