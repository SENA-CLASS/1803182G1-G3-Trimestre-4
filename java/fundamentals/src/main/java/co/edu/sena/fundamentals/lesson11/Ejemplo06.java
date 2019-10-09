package co.edu.sena.fundamentals.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ejemplo06 {
    public static void main(String[] args) {
        int [] a ={2,3,4,5,20,7,9,1,70,5};

        Arrays.sort(a);

        System.out.println();
        List<Integer> lista = new ArrayList<>(20);
        lista.add(24);
        lista.add(23);
        lista.add(2);
        lista.add(10);
        lista.add(8);
        lista.add(6);
        lista.add(4);
        lista.add(9);


        Collections.sort(lista);
        System.out.println();





    }
}
