package lesson04;

import java.util.List;
import java.util.Objects;

public class Gerente extends Empleado {
    private String departamento;
    private String sexo;
    private List<Empleado> empleadoList;

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gerente gerente = (Gerente) o;

        if (departamento != null ? !departamento.equals(gerente.departamento) : gerente.departamento != null)
            return false;
        return sexo != null ? sexo.equals(gerente.sexo) : gerente.sexo == null;
    }

    @Override
    public int hashCode() {
        int result = departamento != null ? departamento.hashCode() : 0;
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        return result;
    }
}
