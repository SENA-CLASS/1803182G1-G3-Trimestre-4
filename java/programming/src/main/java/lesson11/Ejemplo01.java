package lesson11;

import java.io.FileNotFoundException;

public class Ejemplo01 {
    public static void main(String[] args) throws PasswordException {

        if(false)
            throw new PasswordException("en el archivo paso algo");
        System.out.println("paso");
        int a=5;
        System.out.println("asdfasdsd");

        int i;
        for ( i = 0; i <10 ; i++) {
            assert i<10;
            System.out.println(i);

            assert i<10;
        }
        assert i<10: "i ya es 10";
        assert true : "este es el mansaje de assert";
    }
}
