package co.edu.sena.dao.modelo.dto;

import java.io.Serializable;

public class TipoDocumentoDTO implements Serializable {
    private static long serialVersionUID = 43L;
    private String sigla;
    private String nombre;
    private String estado;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
