package co.edu.sena.fundamentals.lesson14;

import java.util.ArrayList;

public class Ejemplo01 {
    public static void main(String[] args) throws Exception {
        Clase01 obj1 = new Clase01();
        obj1.metodoClase01();


        try {
            int [] o = new int[10];
            o[10]=4;

            int a=1/0;
        }catch (ArithmeticException | IndexOutOfBoundsException e){
            System.out.println("error"+e.getCause());
        }

        


    }

}
