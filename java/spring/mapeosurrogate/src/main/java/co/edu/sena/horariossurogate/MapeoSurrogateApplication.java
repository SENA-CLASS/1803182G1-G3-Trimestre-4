package co.edu.sena.horariossurogate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MapeoSurrogateApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MapeoSurrogateApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(MapeoSurrogateApplication.class, args);
	}

    @RequestMapping(value = "/")
    public String hello() {
        return "Funciona el servidor con REST";
    }

}
