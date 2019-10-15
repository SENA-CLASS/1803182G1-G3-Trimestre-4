package lesson06;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.xml.bind.annotation.XmlType;
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

        Collections.sort(arreglo);

        // lista con las caracterisitca de una lista enlazada
        List<String> listaEnlazada = new LinkedList<>();
        listaEnlazada.add("1");
        listaEnlazada.add("2");
        listaEnlazada.add("3");

        listaEnlazada.add(1,"8");
        listaEnlazada.forEach(x-> System.out.println(x));
        System.out.println("conjunto ---------------------------");
        // HashSet
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



        // TreeSet
        System.out.println("treeset-------------------");
        Set<Cliente> clientesSet2 = new TreeSet<>();
        clientesSet2.add(new Cliente("Enrique","Moreno"));
        clientesSet2.add(new Cliente("Antonio","Moreno"));
        clientesSet2.add(new Cliente("Enrique","Moreno"));

        clientesSet2.forEach(x-> System.out.println(x.toString()));

        // LinkedHashSet
        System.out.println("linkehashed-------------------");
        Set<Cliente> clientesSet3 = new LinkedHashSet<>();
        clientesSet3.add(new Cliente("Enrique","Moreno"));
        clientesSet3.add(new Cliente("Antonio","Moreno"));
        clientesSet3.add(new Cliente("Enrique","Moreno"));

        clientesSet3.forEach(x-> System.out.println(x.toString()));

        //HashMap
        Map<Coordenada, Informacion> googleMaps = new HashMap<>();
        googleMaps.put(new Coordenada(4.5950654,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));
        googleMaps.put(new Coordenada(4.5950654,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));
        googleMaps.put(new Coordenada(4.5950654,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));

        for (Map.Entry<Coordenada, Informacion>  c : googleMaps.entrySet()
                ) {
            System.out.println(c.getKey().toString());
            System.out.println(c.getValue().toString());
        }
        System.out.println("-----------------------------------------------------");
        Informacion busqueda = googleMaps.get(new Coordenada(4.5950654,74.1153883));
        System.out.println(busqueda.toString());


        //HashMap
        Map<Coordenada, Informacion> googleMaps2 = new Hashtable<>();
        googleMaps2.put(new Coordenada(4.5950654,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));
        googleMaps2.put(new Coordenada(4.5950654,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));
        googleMaps2.put(new Coordenada(4.5950654,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));

        System.out.println("");

        for (Map.Entry<Coordenada, Informacion>  c : googleMaps2.entrySet()
        ) {
            System.out.println(c.getKey().toString());
            System.out.println(c.getValue().toString());
        }
        System.out.println("-----------------------------------------------------");
        Informacion busqueda2 = googleMaps2.get(new Coordenada(4.5950654,74.1153883));
        System.out.println(busqueda.toString());


        //HashMap
        Map<Coordenada, Informacion> googleMaps3 = new TreeMap<>();
        googleMaps3.put(new Coordenada(4.5950654,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));
        googleMaps3.put(new Coordenada(9,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));
        googleMaps3.put(new Coordenada(6,74.1153883), new Informacion("SENA","Escuela","asdfasdfasdf"));

        System.out.println("--treemap");

        for (Map.Entry<Coordenada, Informacion>  c : googleMaps3.entrySet()
        ) {
            System.out.println(c.getKey().toString());
            System.out.println(c.getValue().toString());
        }

        //
        Deque<Integer> pila = new ArrayDeque<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        pila.pop();

        for (Integer i:pila
             ) {
            System.out.println(i);
        }

        System.out.println(pila.getFirst());
        System.out.println(pila.getLast());

        System.out.println("----- como una cola");
        Deque<Integer> cola = new ArrayDeque<>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.poll();
        cola.addFirst(67);





        for (Integer c:cola
             ) {
            System.out.println(c);
        }















    }
}
