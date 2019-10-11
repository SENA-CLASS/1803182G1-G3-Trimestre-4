package lesson04;

public class Radio {
    private String marca;
    private static String frecuencia;

    static {
        frecuencia="1-10000 hz";
        System.out.println("inicializando");
    }

    static {
        System.out.println("inicializando 2");
    }

    static {
        System.out.println("inicializando 3");
    }

    public Radio(String marca) {
        System.out.println("ejecuta el constructor");
        this.marca = marca;
    }

    public String mostrarMarca(){
        return this.marca;
    }
}
