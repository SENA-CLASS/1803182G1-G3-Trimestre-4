package co.edu.sena.horariossurogate.repository;

import co.edu.sena.horariossurogate.domain.Cliente;
import co.edu.sena.horariossurogate.domain.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // select * from cliente where tipo_documento = ? and numero_documento = ?;
    Cliente findByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);

    List<Cliente> findByTipoDocumento(String tipoDocumento);

}
