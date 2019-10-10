package lesson03;

public class Ejemplo01 {
    public static void main(String[] args) {

        System.out.println(sumar(1,2,3,4));
        System.out.println(sumar(1,2));

    }

    public static int sumar(int... num){
        int suma =0;
        for (int i = 0; i <num.length ; i++) {
            suma+=num[i];
        }
        return suma;
    }
}
