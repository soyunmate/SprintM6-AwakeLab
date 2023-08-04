package cl.abpro.SecAbpro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visitas")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(targetEntity = ClientEntity.class)

    @JoinColumn(name = "cliente_id")
    private ClientEntity cliente;

    private String detalle;
    @OneToOne(targetEntity = CheckListVisita.class)

    @JoinColumn(name = "checklist_id")
    private CheckListVisita checklist;
}
