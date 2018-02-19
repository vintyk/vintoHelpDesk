package by.lk.repository;

import by.lk.entity.TypeOfJobs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface TypeOfJobsRepository extends CrudRepository<TypeOfJobs, Long> {

    TypeOfJobs findOne (Long id);

}
