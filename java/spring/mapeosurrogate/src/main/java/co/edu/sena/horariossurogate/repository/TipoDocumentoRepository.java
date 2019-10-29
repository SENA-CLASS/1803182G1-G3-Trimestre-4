package co.edu.sena.horariossurogate.repository;

import co.edu.sena.horariossurogate.domain.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {

    TipoDocumento findBySigla(String sigla);

    List<TipoDocumento> findBySiglaLike(String search);

    @Query("select u from TipoDocumento u where u.sigla = ?1")
    TipoDocumento findBySiglaJPQL(String sigla);

    //select * from tipo_documento where sigla = ? and estado_tipo_documento = ?;
    List<TipoDocumento> findBySiglaAndEstadoTipoDocumento(String siglaSearch, String estadoSearch);



}
