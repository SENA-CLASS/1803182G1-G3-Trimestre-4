package co.edu.sena.horariossurogate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ComponenteTest {
    @Autowired
    private Componente componente1;

    @Autowired
    private Componente componente2;

    @Autowired
    private Componente componente3;

    @Test
    void prueba(){
        System.out.println(componente1.hashCode());
        System.out.println(componente2.hashCode());
        System.out.println(componente3.hashCode());



    }


}