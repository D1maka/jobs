package jobs.repository;

import jobs.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dmytro_veres on 06.06.2015.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail(String email);
}
