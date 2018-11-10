package by.lk.repository;

import by.lk.entity.Branch;
import by.lk.entity.Privilege;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BranchRepository extends CrudRepository<Branch, Long> {

    List<Branch> findAll();

    List<Branch> findAllByNameContains(String nameBranche);

}
