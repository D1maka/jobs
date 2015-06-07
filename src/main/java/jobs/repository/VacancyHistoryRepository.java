package jobs.repository;

import jobs.entities.Vacancy;
import jobs.entities.VacancyHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dmytro_veres on 07.06.2015.
 */
public interface VacancyHistoryRepository extends CrudRepository<VacancyHistory, Long> {
    List<VacancyHistory> findAllByVacancy(Vacancy vacancy);
}
