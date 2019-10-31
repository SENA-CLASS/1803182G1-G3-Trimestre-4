package co.edu.sena.optional;

import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {

        Perro perro= null;

        if(perro!=null){
            perro.ladra();
        }


        Optional<Perro> perro1 = Optional.ofNullable(perro);

        perro1.ifPresent(Perro::ladra);

        Optional<List<Perro>> lista;


        Caballo caballo = new Caballo(null);


    }
}
