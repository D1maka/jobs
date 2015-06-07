package jobs.repository;

import jobs.entities.Resume;
import jobs.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dmytro_veres on 07.06.2015.
 */
public interface ResumeRepository extends CrudRepository<Resume, Long> {
    List<Resume> findAllByUser(User user);
}
