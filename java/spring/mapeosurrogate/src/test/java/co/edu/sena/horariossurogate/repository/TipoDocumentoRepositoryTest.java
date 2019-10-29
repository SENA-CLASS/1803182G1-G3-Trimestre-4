package co.edu.sena.horariossurogate.repository;

import co.edu.sena.horariossurogate.domain.TipoDocumento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TipoDocumentoRepositoryTest {

    @Autowired
    TipoDocumentoRepository tipoDocumentoDAO;


    @Test
    void save(){
        TipoDocumento t = new TipoDocumento();
        t.setSigla("CC");
        t.setNombreDocuento("cedula de ciudadania");
        t.setEstadoTipoDocumento("Activo");
        tipoDocumentoDAO.save(t);
        TipoDocumento tipoDocumento = tipoDocumentoDAO.findBySigla("CC");
        assertEquals(t.getSigla(), tipoDocumento.getSigla());
        assertEquals(t.getNombreDocuento(), tipoDocumento.getNombreDocuento());
        assertEquals(t.getEstadoTipoDocumento(), tipoDocumento.getEstadoTipoDocumento());
    }


    @Test
    void findBySigla() {
        TipoDocumento t = tipoDocumentoDAO.findBySigla("CC");
        assertNotNull(t);
    }

    @Test
    void findBySiglaLike() {
        List<TipoDocumento> tipoDocumentoList = tipoDocumentoDAO.findBySiglaLike("C%");
        assertNotNull(tipoDocumentoList);
    }

    @Test
    void findBySiglaJPQL() {
    }

    @Test
    void findBySiglaAndEstadoTipoDocumento() {
    }
}