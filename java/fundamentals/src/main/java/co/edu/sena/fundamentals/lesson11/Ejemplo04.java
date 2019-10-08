package co.edu.sena.fundamentals.lesson11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo04 {
    public static void main(String[] args) {

        List lista = new ArrayList(); // lista que puede puede tener cualquier cosa

        lista.add(1);
        lista.add("hola mundo");
        lista.add(LocalDateTime.now());

        for (int i = 0; i <lista.size() ; i++) {
            if(lista.get(i) instanceof Integer){
                System.out.println("en la posicion hay integer"+i);
            }else if(lista.get(i) instanceof String){
                System.out.println("es un string el que esta en la posicion"+i);
            }else if(lista.get(i) instanceof LocalDateTime){
                System.out.println("es un localdatetime"+i);
            }
        }


    }
}
