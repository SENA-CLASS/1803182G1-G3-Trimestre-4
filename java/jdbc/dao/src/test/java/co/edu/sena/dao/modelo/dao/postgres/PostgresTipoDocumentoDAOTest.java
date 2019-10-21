package co.edu.sena.dao.modelo.dao.postgres;

import co.edu.sena.dao.modelo.dao.TipoDocumentoDAO;
import co.edu.sena.dao.modelo.dto.TipoDocumentoDTO;
import co.edu.sena.dao.modelo.factory.TipoDocumentoDAOFactory;
import co.edu.sena.dao.modelo.factory.postgres.PostgresTipoDocuentoDAOFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostgresTipoDocumentoDAOTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    void insert() {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setSigla("CC");
        tipoDocumentoDTO.setNombre("cédula de ciudadanía");
        tipoDocumentoDTO.setEstado("activo");
        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocuentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertEquals(daoTipoDocumento.insert(tipoDocumentoDTO),1);
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    void update() {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setSigla("CCC");
        tipoDocumentoDTO.setNombre("cédula de ciudadanía C");
        tipoDocumentoDTO.setEstado("activo");
        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocuentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertEquals(daoTipoDocumento.update(tipoDocumentoDTO,"CC"),1);
    }

    @org.junit.jupiter.api.Test
    @Order(10)
    void delete() {
        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocuentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertEquals(daoTipoDocumento.delete("CCC"),1);
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    void findAll() {
        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocuentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertFalse(daoTipoDocumento.findAll().isEmpty());
    }

    @org.junit.jupiter.api.Test
    @Order(4)
    void findPk() {
        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocuentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertNotEquals(daoTipoDocumento.findPk("CCC"),null);
    }
}