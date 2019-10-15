package lesson07.builder2;

public class Empleado {
    private String nombre;
    private String color;
    private double salario;
    private String area;

    public Empleado(String nombre, String color, double salario, String area) {
        this.nombre = nombre;
        this.color = color;
        this.salario = salario;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", salario=" + salario +
                ", area='" + area + '\'' +
                '}';
    }
}
