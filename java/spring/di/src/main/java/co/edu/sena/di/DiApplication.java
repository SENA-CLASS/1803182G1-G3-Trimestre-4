package co.edu.sena.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DiApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DiApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(DiApplication.class);

        Perro p1 = context.getBean(Perro.class);
        Perro p2 = context.getBean(Perro.class);

        System.out.println(p1);
        System.out.println(p2);

    }

}
