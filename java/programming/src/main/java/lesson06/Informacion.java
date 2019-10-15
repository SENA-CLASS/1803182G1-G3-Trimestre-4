package lesson06;

public class Informacion {
    private String nombre;
    private String typo;
    private String direccion;

    public Informacion(String nombre, String typo, String direccion) {
        this.nombre = nombre;
        this.typo = typo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTypo() {
        return typo;
    }

    public void setTypo(String typo) {
        this.typo = typo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Informacion{" +
                "nombre='" + nombre + '\'' +
                ", typo='" + typo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

