package cl.abpro.SecAbpro.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CapacitacionDTO {
    private String nombre;
    private String detalle;
}
