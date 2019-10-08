package co.edu.sena.fundamentals.lesson10;

import java.util.Objects;
import java.util.stream.DoubleStream;

public class Ejemplo01 {
    public static void main(String[] args) {
        String a = new String("hola");
        String b = new String("hola");

        class Persona{
            String nombre;

            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Persona persona = (Persona) o;
                return Objects.equals(nombre, persona.nombre);
            }

            @Override
            public int hashCode() {
                return Objects.hash(nombre);
            }
        }

        Persona p1 = new Persona();
        p1.setNombre("enrique");
        Persona p2 = new Persona();
        p2.setNombre("enrique");

        System.out.println(a.equals(b));
        System.out.println(p1.equals(p2));


        // operador ternario
        System.out.println((5>5 && 5>10)?"verdad":"falso");// mal usado es peligroso
        if(5>5){
            System.out.println("verdad");
        }else{
            System.out.println("falso");
        }
        int day=1;
        switch (day){
            case 1:
            case 2:
            case 3:
                System.out.println("del 1 al 3");
                break;
            default:
                break;
        }
    }
}
