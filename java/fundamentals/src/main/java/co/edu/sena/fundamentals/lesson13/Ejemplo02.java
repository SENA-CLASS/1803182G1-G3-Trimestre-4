package co.edu.sena.fundamentals.lesson13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Ejemplo02 {
    public static void main(String[] args) {
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente(1,"Pedro","Morales"));
        lista.add(new Cliente(2,"Juan","Morales"));
        lista.add(new Cliente(3,"Antonio","Hernandez"));
        lista.add(new Cliente(4,"Miguel","Diaz"));
        lista.add(new Cliente(5,"Laura","Gomez"));
        lista.add(new Cliente(6,"Carlos","Silva"));
        lista.add(new Cliente(7,"Marlon","Moreno"));
        lista.add(new Cliente(8,"Jessica","Sotelo"));

        Collections.sort(lista, (o1, o2) -> o1.getApellidos().compareTo(o2.getApellidos()));

        lista.forEach((Cliente cliente)->{
            System.out.println(cliente.toString());
        });

        lista.removeIf(cliente -> cliente.getNombres().equals("Carlos"));

        System.out.println("--------------------------");
        lista.forEach((Cliente cliente)->{
            System.out.println(cliente.toString());
        });





    }
}
