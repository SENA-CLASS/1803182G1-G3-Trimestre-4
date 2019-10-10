package co.edu.sena.fundamentals.lesson14;

import co.edu.sena.fundamentals.lesson07.Clase;

public class Clase01 {

    public void metodoClase01() {
        Clase02 clase02 = new Clase02();
        try {
            clase02.metodoErrorCompilacion();
        }catch (Exception e){
            System.err.println( e.getMessage());
        }
        System.out.printf("termino el aplicativo");


    }

}
