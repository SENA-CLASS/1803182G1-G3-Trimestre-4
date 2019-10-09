package co.edu.sena.fundamentals.lesson13;

import co.edu.sena.fundamentals.lesson07.Clase;

public class Clase01 implements Interface01 {

    public static void main(String[] args) {
        System.out.println(factorialNormal(0));
        System.out.println(factoriaRecursivo(5));
        System.out.println(factoriaRecursivo(0));
        System.out.printf("-----------------------------------------");
        imprimirNumero(10, 1);
        System.out.println("--------------------------------");
        imprimirNumeroInverso(5);
        System.out.println("--------------------------------------");
        System.out.println(fibonaci(9));
    }


    public static void sumar(int a, int b){
        System.out.println(a+b);
    }


    public static int factoriaRecursivo(int numero){
        if(numero ==0){
            return 1;
        }else{
            return numero* factoriaRecursivo(numero-1);
        }
    }

    public static int factorialNormal(int numero){
        int f =1;
        for (int i = 0; i <= numero ; i++) {
            if(i>0){
                f*=i;
            }
        }
        return f;
    }

    public static void imprimirNumero(int numero, int numeroInicial){
        if(numeroInicial<=numero){
            System.out.println(numeroInicial);
            numeroInicial++;
            imprimirNumero(numero, numeroInicial);
        }
    }

    public static void imprimirNumeroInverso(int numero){

        if(numero>0){
            System.out.println(numero);
            imprimirNumeroInverso(numero-1);
        }
    }

    public static int fibonaci(int n){
        if(n<2){
            return n;
        }else{
            return fibonaci(n-1)+fibonaci(n-2);
        }
    }
}
