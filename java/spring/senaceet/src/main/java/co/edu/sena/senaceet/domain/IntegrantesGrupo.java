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
@Table(name = "integrantes_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntegrantesGrupo.findAll", query = "SELECT i FROM IntegrantesGrupo i"),
    @NamedQuery(name = "IntegrantesGrupo.findById", query = "SELECT i FROM IntegrantesGrupo i WHERE i.id = :id")})
public class IntegrantesGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumns({
        @JoinColumn(name = "id_aprendiz", referencedColumnName = "id"),
        @JoinColumn(name = "id_aprendiz", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Aprendiz aprendiz;
    @JoinColumns({
        @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id"),
        @JoinColumn(name = "id_grupo_proyecto", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoProyecto grupoProyecto;

    public IntegrantesGrupo() {
    }

    public IntegrantesGrupo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
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
        if (!(object instanceof IntegrantesGrupo)) {
            return false;
        }
        IntegrantesGrupo other = (IntegrantesGrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.IntegrantesGrupo[ id=" + id + " ]";
    }
    
}
