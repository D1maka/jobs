package jobs.repository;

import jobs.entities.Employer;
import jobs.entities.Vacancy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {
    List<Vacancy> findAllByEmployer(Employer employer);
}
