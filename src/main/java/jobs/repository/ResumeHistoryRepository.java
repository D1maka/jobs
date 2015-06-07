package jobs.repository;

import jobs.entities.Resume;
import jobs.entities.ResumeHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dmytro_veres on 07.06.2015.
 */
public interface ResumeHistoryRepository extends CrudRepository<ResumeHistory, Long> {
    List<ResumeHistory> findAllByResume(Resume resume);
}
