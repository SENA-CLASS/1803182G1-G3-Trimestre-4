package lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Archivo03 {
    public static void main(String[] args) {

        System.out.println("abrir un archivo");
        InputStream in = null;
        try {
            in = new FileInputStream("archivo.txt");
            System.out.println("el archivo se a encontrado");
            in.close();
        } catch (IOException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
