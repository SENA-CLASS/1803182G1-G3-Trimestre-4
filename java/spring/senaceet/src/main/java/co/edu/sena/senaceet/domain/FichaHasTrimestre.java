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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "ficha_has_trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaHasTrimestre.findAll", query = "SELECT f FROM FichaHasTrimestre f"),
    @NamedQuery(name = "FichaHasTrimestre.findById", query = "SELECT f FROM FichaHasTrimestre f WHERE f.id = :id")})
public class FichaHasTrimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaHasTrimestre", fetch = FetchType.LAZY)
    private List<Horario> horarioList;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha idFicha;
    @JoinColumns({
        @JoinColumn(name = "id_trimestre", referencedColumnName = "id"),
        @JoinColumn(name = "id_trimestre", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Trimestre trimestre;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fichaHasTrimestre", fetch = FetchType.LAZY)
    private ResultadosVistos resultadosVistos;

    public FichaHasTrimestre() {
    }

    public FichaHasTrimestre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    public ResultadosVistos getResultadosVistos() {
        return resultadosVistos;
    }

    public void setResultadosVistos(ResultadosVistos resultadosVistos) {
        this.resultadosVistos = resultadosVistos;
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
        if (!(object instanceof FichaHasTrimestre)) {
            return false;
        }
        FichaHasTrimestre other = (FichaHasTrimestre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.FichaHasTrimestre[ id=" + id + " ]";
    }
    
}
