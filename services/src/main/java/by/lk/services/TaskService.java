package by.lk.services;

import by.lk.dto.TaskDto;
import by.lk.entity.Task;

import java.util.List;

public interface TaskService {

    Long saveTask(TaskDto taskDto);

    List<Task> findAll();

    Task findById(Long id);
}
