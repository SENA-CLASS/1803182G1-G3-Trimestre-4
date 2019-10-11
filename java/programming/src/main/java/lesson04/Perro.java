package lesson04;

public class Perro {

    private String nombre;
    private String raza;

    private static final Perro instancia = new Perro();

    private Perro(){
    }

    public static Perro ofSingleton(){
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
