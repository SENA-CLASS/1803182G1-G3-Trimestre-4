package co.edu.sena.fundamentals.lesson11;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ejemplo03 {
    public static void main(String[] args) {
        int [] arreglo = {1,2,3,4,5,6,7,8,9};

        for (int i = 0; i <arreglo.length ; i++) {
            if(arreglo[i]== 5){
                System.out.println(i);
                continue;
            }
            System.out.println("este no es "+i);
        }

        LocalTime [] horas = {LocalTime.now(),LocalTime.now()};

        for (int i = 0; i <horas.length ; i++) {
            System.out.println(horas[i]);
        }



    }
}
