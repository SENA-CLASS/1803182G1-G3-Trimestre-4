package lesson05;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Ejemplo01 {
    public static void main(String[] args) {
        System.out.println(Sexo.FEMENINO);
        System.out.println(Sexo.FEMENINO.ordinal());
        Cliente cliente = new Cliente();
        cliente.setNombre("enrique");
        cliente.setSexo(Sexo.MASCULINO);
        System.out.println(cliente.getSexo().name());


        List<String> lista = new ArrayList<>();
        lista.add("");
        lista.add("mama");
        lista.add("papa");
        lista.add("casa");
        lista.add("carro");

        lista.forEach(s -> {
            if(s.equals("casa")){
                System.out.println("casa esta contenida en la collection");
            }
        });


        List<Integer> lista2 = new ArrayList<>();
        lista2.add(4);
        lista2.add(5);
        lista2.add(6);
        lista2.add(7);
        lista2.add(8);

        System.out.println(lista2.stream().reduce(10,(integer, integer2) -> integer- integer2));







    }

}
