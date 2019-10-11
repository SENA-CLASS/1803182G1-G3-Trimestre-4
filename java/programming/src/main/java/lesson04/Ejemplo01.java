package lesson04;

import java.time.LocalDate;

import static java.lang.Math.random;

public class Ejemplo01 {
    public static void main(String[] args) {
        Radio radio = new Radio("sony");
        Billetera billetera = new Billetera();

        System.out.println(random());

        Perro p = Perro.ofSingleton();
        System.out.println(p);
        Perro p1 = Perro.ofSingleton();
        System.out.println(p1);
        Perro p2 = Perro.ofSingleton();
        System.out.println(p2);



    }
}
