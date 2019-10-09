package co.edu.sena.fundamentals.lesson11;

import com.sun.corba.se.impl.encoding.CDROutputObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio51 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Integer> arreglo = new ArrayList<>();

        for (int i = 0; i <5 ; i++) {
            arreglo.add(teclado.nextInt());
        }

        for (int i = 0; i <arreglo.size() ; i++) {
            System.out.println(arreglo.get(i));
        }


    }
}
