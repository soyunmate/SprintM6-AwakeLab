package cl.abpro.SecAbpro.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitaDTO {
    private Long id;
    private String name;

    private Long cliente;

    private String detalle;
}
