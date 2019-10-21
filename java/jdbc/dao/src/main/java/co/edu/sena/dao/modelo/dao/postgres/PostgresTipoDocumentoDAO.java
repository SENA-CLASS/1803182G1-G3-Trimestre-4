package co.edu.sena.dao.modelo.dao.postgres;

import co.edu.sena.dao.modelo.dao.TipoDocumentoDAO;
import co.edu.sena.dao.modelo.dao.util.ResourceManager;
import co.edu.sena.dao.modelo.dto.TipoDocumentoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class PostgresTipoDocumentoDAO implements TipoDocumentoDAO {

    private Connection conexion;
    static final Logger logger = Logger.getLogger(PostgresTipoDocumentoDAO.class.getName());

    /**
     * metodo insert de la tabla tipo documento
     * @param tipoDocumentoDTO objeto de tipo documento
     * @return numero de registros que se inserto
     */
    @Override
    public int insert(TipoDocumentoDTO tipoDocumentoDTO) {
        int resultado=0;
        String sql = "INSERT INTO public.tipo_documento(" +
                "sigla, nombre, estado) " +
                "VALUES (?, ?, ?);";
        PreparedStatement sentencia =null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia= conexion.prepareStatement(sql);
            sentencia.setString(1,tipoDocumentoDTO.getSigla());
            sentencia.setString(2,tipoDocumentoDTO.getNombre());
            sentencia.setString(3,tipoDocumentoDTO.getEstado());
            resultado= sentencia.executeUpdate();
        } catch (SQLException e) {
           logger.info(e.getMessage());
        }finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }

    @Override
    public int update(TipoDocumentoDTO tipoDocumentoDTO, String primaryKey) {
        int resultado=0;
        String sql = "UPDATE public.tipo_documento\n" +
                "\tSET sigla=?, nombre=?, estado=?\n" +
                "\tWHERE sigla = ?;";
        PreparedStatement sentencia =null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia= conexion.prepareStatement(sql);
            sentencia.setString(1,tipoDocumentoDTO.getSigla());
            sentencia.setString(2,tipoDocumentoDTO.getNombre());
            sentencia.setString(3,tipoDocumentoDTO.getEstado());
            sentencia.setString(4,primaryKey);
            resultado= sentencia.executeUpdate();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }

    @Override
    public int delete(String primaryKey) {
        int resultado=0;
        String sql = "DELETE FROM tipo_documento\n" +
                "\tWHERE sigla=?;";
        PreparedStatement sentencia =null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia= conexion.prepareStatement(sql);
            sentencia.setString(1,primaryKey);
            resultado= sentencia.executeUpdate();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }

    @Override
    public Collection<TipoDocumentoDTO> findAll() {
        String sql = "SELECT sigla, nombre, estado " +
                "FROM tipo_documento;";
        PreparedStatement sentencia =null;
        ResultSet resultado = null;
        List<TipoDocumentoDTO> lista = new ArrayList<>();
        try {
            conexion = ResourceManager.getConnection();
            sentencia= conexion.prepareStatement(sql);
            resultado= sentencia.executeQuery();


            while (resultado.next()){
                TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
                tipoDocumentoDTO.setSigla(resultado.getString("sigla"));
                tipoDocumentoDTO.setNombre(resultado.getString("nombre"));
                tipoDocumentoDTO.setEstado(resultado.getString("estado"));
                lista.add(tipoDocumentoDTO);
            }

        } catch (SQLException e) {
            logger.info(e.getMessage());
        }finally {
            ResourceManager.close(resultado);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return lista;
    }

    @Override
    public TipoDocumentoDTO findPk(String primaryKey) {
        String sql = "SELECT sigla, nombre, estado " +
                "FROM tipo_documento where sigla = ?;";
        PreparedStatement sentencia =null;
        ResultSet resultado = null;
        TipoDocumentoDTO tipoDocumentoDTO = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia= conexion.prepareStatement(sql);
            sentencia.setString(1,primaryKey);
            resultado= sentencia.executeQuery();


            while (resultado.next()){
                tipoDocumentoDTO = new TipoDocumentoDTO();
                tipoDocumentoDTO.setSigla(resultado.getString("sigla"));
                tipoDocumentoDTO.setNombre(resultado.getString("nombre"));
                tipoDocumentoDTO.setEstado(resultado.getString("estado"));
            }

        } catch (SQLException e) {
            logger.info(e.getMessage());
        }finally {
            ResourceManager.close(resultado);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return tipoDocumentoDTO;
    }
}
