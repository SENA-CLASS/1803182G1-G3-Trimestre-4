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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "lista_chequeo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaChequeo.findAll", query = "SELECT l FROM ListaChequeo l"),
    @NamedQuery(name = "ListaChequeo.findById", query = "SELECT l FROM ListaChequeo l WHERE l.id = :id"),
    @NamedQuery(name = "ListaChequeo.findByLista", query = "SELECT l FROM ListaChequeo l WHERE l.lista = :lista"),
    @NamedQuery(name = "ListaChequeo.findByEstado", query = "SELECT l FROM ListaChequeo l WHERE l.estado = :estado")})
public class ListaChequeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lista")
    private String lista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinTable(name = "lista_ficha", joinColumns = {
        @JoinColumn(name = "id_lista_chequeo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_ficha", referencedColumnName = "id"),
        @JoinColumn(name = "id_ficha", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Ficha> fichaList;
    @JoinColumns({
        @JoinColumn(name = "id_programa", referencedColumnName = "id"),
        @JoinColumn(name = "id_programa", referencedColumnName = "id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Programa programa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "listaChequeo", fetch = FetchType.LAZY)
    private ItemLista itemLista;

    public ListaChequeo() {
    }

    public ListaChequeo(Integer id) {
        this.id = id;
    }

    public ListaChequeo(Integer id, String lista, int estado) {
        this.id = id;
        this.lista = lista;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public ItemLista getItemLista() {
        return itemLista;
    }

    public void setItemLista(ItemLista itemLista) {
        this.itemLista = itemLista;
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
        if (!(object instanceof ListaChequeo)) {
            return false;
        }
        ListaChequeo other = (ListaChequeo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.ListaChequeo[ id=" + id + " ]";
    }
    
}
