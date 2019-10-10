package co.edu.sena.fundamentals.lesson13;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Ejemplo01 {
    public static void main(String[] args) {
        String [] nombres = {"enrique","enrique", "pedro", "jose", "carlos"};
        List<String> listaNombres = new ArrayList<>(Arrays.asList(nombres));

        /*
        Iterator iterador = listaNombres.iterator();
        while (iterador.hasNext()){
            String nombre = (String)iterador.next();
            System.out.println(nombre);
        }
        */

        for (String nombre:listaNombres) {
            System.out.println(nombre);
        }


        listaNombres.replaceAll(s -> s.toUpperCase());

        listaNombres.forEach(x->System.out.println(x));











    }
}
