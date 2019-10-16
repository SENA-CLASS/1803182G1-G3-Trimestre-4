package lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Archivo02 {
    public static void main(String[] args) {

        System.out.println("abrir un archivo");

        try (InputStream in = new FileInputStream("archivo.txt")) {

            System.out.println("el archivo se a encontrado");
            in.close();
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
