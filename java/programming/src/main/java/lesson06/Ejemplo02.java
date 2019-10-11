package lesson06;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class Ejemplo02 {
    public static void main(String[] args) {

        // lista con las caracteristicas de un arerglo
        List<String> arreglo = new ArrayList<>();
        arreglo.add("1");
        arreglo.add("2");
        arreglo.add("3");
        arreglo.add("4");
        arreglo.add(2,"8");
        arreglo.forEach(x-> System.out.println(x));

        // lista con las caracterisitca de una lista enlazada
        List<String> listaEnlazada = new LinkedList<>();
        listaEnlazada.add("1");
        listaEnlazada.add("2");
        listaEnlazada.add("3");

        listaEnlazada.add(1,"8");
        listaEnlazada.forEach(x-> System.out.println(x));
        System.out.println("conjunto ---------------------------");
        // conjunto
        Set<String> conjunto = new HashSet<>();
        conjunto.add("1");
        conjunto.add("1");
        conjunto.add("1");
        conjunto.add("1");

        conjunto.forEach(x-> System.out.println(x));

        Set<Cliente> clientesSet = new HashSet<>();
        clientesSet.add(new Cliente("Enrique","Moreno"));
        clientesSet.add(new Cliente("Enrique","Moreno"));
        clientesSet.add(new Cliente("Enrique","Moreno"));

        clientesSet.forEach(x-> System.out.println(x.toString()));

        // treeset
        System.out.println("treeset-------------------");
        Set<Cliente> clientesSet2 = new TreeSet<>();
        clientesSet2.add(new Cliente("Enrique","Moreno"));
        clientesSet2.add(new Cliente("Antonio","Moreno"));
        clientesSet2.add(new Cliente("Enrique","Moreno"));

        clientesSet2.forEach(x-> System.out.println(x.toString()));

        // linkedhas
        System.out.println("linkehashed-------------------");
        Set<Cliente> clientesSet3 = new LinkedHashSet<>();
        clientesSet3.add(new Cliente("Enrique","Moreno"));
        clientesSet3.add(new Cliente("Antonio","Moreno"));
        clientesSet3.add(new Cliente("Enrique","Moreno"));

        clientesSet3.forEach(x-> System.out.println(x.toString()));













    }
}
