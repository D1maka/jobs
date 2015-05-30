package jobs.repository;

import jobs.entities.Region;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dmytro_veres on 30.05.2015.
 */
public interface RegionRepository extends CrudRepository<Region, Long> {
}
