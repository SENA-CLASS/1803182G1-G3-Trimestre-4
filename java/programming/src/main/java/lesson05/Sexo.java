package lesson05;

public enum Sexo {
    MASCULINO("es un machito"),
    FEMENINO("es una embrita"),
    OTRO("este no se ha definido");

    private String descripcion;

    private Sexo(String s) {
        this.descripcion= s;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
