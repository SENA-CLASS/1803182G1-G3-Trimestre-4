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
@Table(name = "limitacion_ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LimitacionAmbiente.findAll", query = "SELECT l FROM LimitacionAmbiente l"),
    @NamedQuery(name = "LimitacionAmbiente.findById", query = "SELECT l FROM LimitacionAmbiente l WHERE l.id = :id")})
public class LimitacionAmbiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumns({
        @JoinColumn(name = "id_ambiente", referencedColumnName = "id"),
        @JoinColumn(name = "id_ambiente", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Ambiente ambiente;
    @JoinColumns({
        @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id"),
        @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoAprendizaje resultadoAprendizaje;

    public LimitacionAmbiente() {
    }

    public LimitacionAmbiente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
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
        if (!(object instanceof LimitacionAmbiente)) {
            return false;
        }
        LimitacionAmbiente other = (LimitacionAmbiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.LimitacionAmbiente[ id=" + id + " ]";
    }
    
}
