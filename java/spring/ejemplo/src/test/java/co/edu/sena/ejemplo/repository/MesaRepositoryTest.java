package co.edu.sena.ejemplo.repository;

import co.edu.sena.ejemplo.domain.Mesa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MesaRepositoryTest {

    @Autowired
    MesaRepository mesaRepository;


    @Test
    void insertar(){
        Mesa m = new Mesa();
        m.setId(1L);
        m.setMarca("mesitas el vidrio roto");
        mesaRepository.deleteAll();
    }


}