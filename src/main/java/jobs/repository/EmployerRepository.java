package jobs.repository;

import jobs.entities.Employer;
import jobs.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
public interface EmployerRepository extends CrudRepository<Employer, Long> {
    Employer findOneByUser(User user);
}
