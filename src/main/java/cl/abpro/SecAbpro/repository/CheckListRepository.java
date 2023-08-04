package cl.abpro.SecAbpro.repository;

import cl.abpro.SecAbpro.model.CheckListVisita;
import org.springframework.data.repository.CrudRepository;

public interface CheckListRepository extends CrudRepository<CheckListVisita, Long> {
}
