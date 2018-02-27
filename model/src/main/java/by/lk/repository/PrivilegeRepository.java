package by.lk.repository;

import by.lk.entity.Privilege;
import by.lk.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

//    Privilege findOne(Long id);

    List<Privilege> findAll();
}
