package lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Archivo {
    public static void main(String[] args) {

        System.out.println("abrir un archivo");
        InputStream in = null;
        try {
            in = new FileInputStream("archivo.txt");
            System.out.println("el archivo se a encontrado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
