package jobs.repository;

import jobs.entities.Vacancy;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {
}
