package co.edu.sena.fundamentals.lesson11;

import java.util.Arrays;
import java.util.List;

public class Ejemplo02 {
    public static void main(String[] args) {
        for (int i = 0; i <args.length ; i++) {
            switch (args[i]){
                case "-version":
                    System.out.println("version 1.0");
                    break;
                case "c":
                    System.out.println("build succes");
                    break;
                default:
                    System.out.println("el comando no se reconoce");
            }

            int [] arreglo = new int[10];

            List lista = Arrays.asList(arreglo);
            int a=0;
            for(;a<10;){
                System.out.println("hola mundo");
                a++;
            }

        }

    }
}
