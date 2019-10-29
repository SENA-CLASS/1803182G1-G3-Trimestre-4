package co.edu.sena.horariossurogate.repository;

import co.edu.sena.horariossurogate.domain.Cliente;
import co.edu.sena.horariossurogate.domain.TipoDocumento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    @Test
    void insert(){
        Cliente cliente = new Cliente();
        cliente.setNumeroDocumento("898989");
        cliente.setPrimerNombre("juan");
        cliente.setPrimerApellido("morales");
        cliente.setTipoDocumento(tipoDocumentoRepository.findBySigla("CC"));
        clienteRepository.save(cliente);

        Cliente cliente2 = clienteRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumentoRepository.findBySigla("CC"),"898989");

        assertEquals(cliente, cliente2);


    }

    @Test
    void findByTipoDocumentoAndNumeroDocumento() {
    }

    @Test
    void findByTipoDocumento() {
    }
}