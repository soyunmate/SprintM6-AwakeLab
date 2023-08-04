package cl.abpro.SecAbpro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visita_checklist")
public class CheckListVisita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(targetEntity = Visita.class)
    @JoinColumn(name = "visita_id")
    private Visita visita;

    private boolean visitaExitosa;
    private boolean cumpleQuorum;
    private boolean superPresente;
    private boolean cumpleProtocolo;
    private boolean entregaInforme;
}
