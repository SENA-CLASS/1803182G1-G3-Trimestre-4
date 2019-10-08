package co.edu.sena.fundamentals.lesson07;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class App {
    public static void main(String[] args) {
        System.out.println("estatico"+Clase05.getNombreStatic());
        Clase05 clase05 = new Clase05();
        System.out.println("objeto"+clase05.getNombre());

        System.out.println();

        boolean var = true;
        boolean var2 = Boolean.TRUE;

        Double var3 = new Double(5);
        double var4 = var3.parseDouble("67"); // ojo se puede pero no se debe por que no tiene sentido
        System.out.println(var4);

        System.out.println("asdf".charAt(3));

    }
}
