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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a"),
    @NamedQuery(name = "Aprendiz.findById", query = "SELECT a FROM Aprendiz a WHERE a.id = :id")})
public class Aprendiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "aprendiz", fetch = FetchType.LAZY)
    private IntegrantesGrupo integrantesGrupo;
    @JoinColumns({
        @JoinColumn(name = "id_cliente", referencedColumnName = "id"),
        @JoinColumn(name = "id_cliente", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumns({
        @JoinColumn(name = "id_estado_formacion", referencedColumnName = "id"),
        @JoinColumn(name = "id_estado_formacion", referencedColumnName = "id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoFormacion estadoFormacion;
    @JoinColumns({
        @JoinColumn(name = "id_ficha", referencedColumnName = "id"),
        @JoinColumn(name = "id_ficha", referencedColumnName = "id")})
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Ficha ficha;

    public Aprendiz() {
    }

    public Aprendiz(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IntegrantesGrupo getIntegrantesGrupo() {
        return integrantesGrupo;
    }

    public void setIntegrantesGrupo(IntegrantesGrupo integrantesGrupo) {
        this.integrantesGrupo = integrantesGrupo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoFormacion getEstadoFormacion() {
        return estadoFormacion;
    }

    public void setEstadoFormacion(EstadoFormacion estadoFormacion) {
        this.estadoFormacion = estadoFormacion;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
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
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.Aprendiz[ id=" + id + " ]";
    }
    
}
