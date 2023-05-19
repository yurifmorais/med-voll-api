package med.voll.api.medico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//as interfaces respository substituem as classes DAO. sao utilizadas para salvar os dados no bd. isso e coisa do spring data, ele implementa tudo
public interface MedicoRepository extends JpaRepository<Medico, Long> { //primeiro passa o tipo da entidade e o segundo argumento 'e o tipo do atributo da pk dessa entidade
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
