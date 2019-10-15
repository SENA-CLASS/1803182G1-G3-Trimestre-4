package lesson07.builder2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ejemplo01 {
    public static void main(String[] args) {
        Persona p1 = Persona.builder()
                .nombres("Enrique")
                .apellidos("moreno")
                .direccion("avenida simpre viva 12345")
                .build();

        System.out.println(p1.toString());

        List<Persona> lista = new ArrayList<>();

        lista.add(Persona.builder().nombres("antonio").build());
        lista.add(Persona.builder().nombres("miguel").build());
        lista.add(Persona.builder().nombres("andres").build());

        System.out.println("resultado");
        System.out.println("andres: "+
        lista.stream().filter(p->{
           return p.getNombres().equals("andres");
        }).count());
        ;

        System.out.println("ordenador");
        lista.stream()
                .sorted((o1, o2) -> o1.getNombres().compareTo(o2.getNombres()))
                .forEach(x-> System.out.println(x));

        List<Integer> arreglito = new ArrayList<>();
        arreglito.add(1);
        arreglito.add(2);
        arreglito.add(3);
        arreglito.add(4);
        arreglito.add(5);

        arreglito.stream()
                .map(x->x*5)
                .forEach(y-> System.out.println(y));

        arreglito.forEach(x-> System.out.println(x));

        System.out.println(arreglito.stream().reduce(10, (integer, integer2) -> integer+integer2));

        List<Integer> lista34 = arreglito.stream()
                .map(x->x*5)
                .collect(Collectors.toList());
        System.out.println("lista nueva");
        lista34.forEach(x-> System.out.println(x));

        lista.stream()
                .sorted((o1, o2) -> o1.getNombres().compareTo(o2.getNombres()))
                .forEach(System.out::println);

        System.out.println("--ejemplo con arrays");
        String[] cadenas =
                 {"Rojo", "naranja", "Amarillo", "verde", "Azul", "indigo", "Violeta"};

        List<String> lsitaTexto =Arrays.asList(cadenas).stream()
            .map(String::toUpperCase)
                .collect(Collectors.toList());

        lsitaTexto.forEach(System.out::println);


        Empleado[] empleados = {
                 new Empleado("Jason", "Red", 5000, "TI"),
                 new Empleado("Ashley", "Green", 7600, "TI"),
                 new Empleado("Matthew", "Indigo", 3587.5, "Ventas"),
                 new Empleado("James", "Indigo", 4700.77, "Marketing"),
                 new Empleado("Luke", "Indigo", 6200, "TI"),
                 new Empleado("Luke", "Blue", 3200, "Ventas"),
                 new Empleado("Wendy", "Brown", 4236.4, "Marketing")};
        
         // obtiene vista List de los objetos Empleado ordenas con dos filtros
         List<Empleado> listaEmpleados = Arrays.asList(empleados);



         listaEmpleados.stream()
                 .sorted(Comparator.comparing(Empleado::getArea)
                         .thenComparing(Empleado::getNombre)
                         .thenComparing(Empleado::getColor))
         .forEach(x->System.out.println(x.toString()));










    }
}
