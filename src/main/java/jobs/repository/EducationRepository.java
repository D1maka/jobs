package jobs.repository;

import jobs.entities.Education;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dmytro_veres on 07.06.2015.
 */
public interface EducationRepository extends CrudRepository<Education, Long> {
}
