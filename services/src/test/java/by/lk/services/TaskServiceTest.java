package by.lk.services;

import by.lk.dto.TaskDto;
import by.lk.entity.Task;
import by.lk.repository.TaskRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;


public class TaskServiceTest extends CommonTest {
    private Long id;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void saveTaskTest() {
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Подсоединить картридж");
        taskDto.setText("Закончился старый картридж. Надо замена.");
        taskDto.setTypeOfJobId(1L);
        id = taskService.saveTask(taskDto);
    }

    @After
    public void finish() {
        taskRepository.delete(id);
        final Task one = taskRepository.findOne(id);
        assertNull(one);
    }
}
