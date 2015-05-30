package jobs.repository;

import jobs.entities.Employer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
public interface EmployerRepository extends CrudRepository<Employer, Long> {
}
