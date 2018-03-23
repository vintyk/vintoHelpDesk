package by.lk.repository;

import by.lk.entity.TypeOfJobs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TypeOfJobsRepository extends CrudRepository<TypeOfJobs, Long> {
}
