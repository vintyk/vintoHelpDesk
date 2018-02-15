package by.lk.repository;

import by.lk.entity.Task;
import org.springframework.data.repository.Repository;

public interface TaskRepository extends Repository<Task, Long> {

    Task findOne(Long id);

    void save(Task task);
}
