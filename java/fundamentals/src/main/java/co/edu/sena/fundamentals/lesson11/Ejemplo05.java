package co.edu.sena.fundamentals.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejemplo05 {
    public static void main(String[] args) {
        int [] a ={2,3,4,5,6,7,8,9,1};

        int cont=0;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]==5)
                cont++;
        }

        int [] at = new int[a.length-cont];

        int cont2=0;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]!=5){
                at[cont2]=a[i];
                cont2++;
            }
        }
        a =at;


        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(5);




        List<Integer> listaEliminar = new ArrayList<>();
        listaEliminar.add(5);

        lista.removeAll(listaEliminar);
        System.out.println();







    }
}
