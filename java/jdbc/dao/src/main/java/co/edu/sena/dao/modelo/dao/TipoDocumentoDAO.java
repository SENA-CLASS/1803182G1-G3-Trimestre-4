package co.edu.sena.dao.modelo.dao;

import co.edu.sena.dao.modelo.dto.TipoDocumentoDTO;

import java.util.Collection;

public interface TipoDocumentoDAO {
    public int insert(TipoDocumentoDTO tipoDocumentoDTO);
    public int update(TipoDocumentoDTO tipoDocumentoDTO, String primaryKey);
    public int delete(String primaryKey);
    public Collection<TipoDocumentoDTO> findAll();
    public TipoDocumentoDTO findPk(String primaryKey);
}