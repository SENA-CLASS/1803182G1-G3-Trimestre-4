package lesson07.builder2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Persona {
    private String nombres;
    private String apellidos;
    private String direccion;
}
