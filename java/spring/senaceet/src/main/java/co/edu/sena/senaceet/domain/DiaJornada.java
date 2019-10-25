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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name = "dia_jornada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaJornada.findAll", query = "SELECT d FROM DiaJornada d"),
    @NamedQuery(name = "DiaJornada.findById", query = "SELECT d FROM DiaJornada d WHERE d.id = :id"),
    @NamedQuery(name = "DiaJornada.findByHoraInicio", query = "SELECT d FROM DiaJornada d WHERE d.horaInicio = :horaInicio"),
    @NamedQuery(name = "DiaJornada.findByHoraFin", query = "SELECT d FROM DiaJornada d WHERE d.horaFin = :horaFin")})
public class DiaJornada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_inicio")
    private int horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fin")
    private int horaFin;
    @JoinColumn(name = "id_dia", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dia idDia;
    @JoinColumn(name = "id_jornada_Instructores", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private JornadaInstructor idjornadaInstructores;

    public DiaJornada() {
    }

    public DiaJornada(Integer id) {
        this.id = id;
    }

    public DiaJornada(Integer id, int horaInicio, int horaFin) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public Dia getIdDia() {
        return idDia;
    }

    public void setIdDia(Dia idDia) {
        this.idDia = idDia;
    }

    public JornadaInstructor getIdjornadaInstructores() {
        return idjornadaInstructores;
    }

    public void setIdjornadaInstructores(JornadaInstructor idjornadaInstructores) {
        this.idjornadaInstructores = idjornadaInstructores;
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
        if (!(object instanceof DiaJornada)) {
            return false;
        }
        DiaJornada other = (DiaJornada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.horarios.model.entities.DiaJornada[ id=" + id + " ]";
    }
    
}
