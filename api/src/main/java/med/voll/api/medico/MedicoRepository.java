package med.voll.api.medico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> { //primeiro passa o tipo da entidade e o segundo argumento eh o tipo do atributo da pk dessa entidade
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
