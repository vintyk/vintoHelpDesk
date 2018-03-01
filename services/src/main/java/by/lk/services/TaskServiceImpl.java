package by.lk.services;

import by.lk.dto.TaskDto;
import by.lk.entity.SystemUser;
import by.lk.entity.Task;
import by.lk.entity.TypeOfJobs;
import by.lk.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Long saveTask(TaskDto taskDto) {
        TypeOfJobs typeOfJobs = new TypeOfJobs();
        typeOfJobs.setId(taskDto.getTypeOfJobId());
        SystemUser systemUser = new SystemUser();
        systemUser.setId(taskDto.getSystemUser());

        Task task = new Task();
        task.setName(taskDto.getName());
        task.setText(taskDto.getText());
        task.setTypeOfJobId(typeOfJobs);
        task.setSystemUser(systemUser);
        Task saveId = taskRepository.save(task);
        return saveId.getId();
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task findById(Long id) {
        return null;
    }
}
