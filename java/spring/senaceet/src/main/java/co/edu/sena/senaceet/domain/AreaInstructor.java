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
@Table(name = "area_instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaInstructor.findAll", query = "SELECT a FROM AreaInstructor a"),
    @NamedQuery(name = "AreaInstructor.findById", query = "SELECT a FROM AreaInstructor a WHERE a.id = :id"),
    @NamedQuery(name = "AreaInstructor.findByEstado", query = "SELECT a FROM AreaInstructor a WHERE a.estado = :estado")})
public class AreaInstructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_area", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Area idArea;
    @JoinColumns({
        @JoinColumn(name = "id_instructor", referencedColumnName = "id"),
        @JoinColumn(name = "id_instructor", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Instructor instructor;

    public AreaInstructor() {
    }

    public AreaInstructor(Integer id) {
        this.id = id;
    }

    public AreaInstructor(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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
        if (!(object instanceof AreaInstructor)) {
            return false;
        }
        AreaInstructor other = (AreaInstructor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.AreaInstructor[ id=" + id + " ]";
    }
    
}
