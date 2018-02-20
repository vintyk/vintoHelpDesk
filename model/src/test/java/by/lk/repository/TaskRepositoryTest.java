package by.lk.repository;

import by.lk.entity.Task;
import by.lk.entity.TypeOfJobs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;

public class TaskRepositoryTest extends CommonTest {
    private Task id;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void saveTest() {
        TypeOfJobs typeOfJobs = new TypeOfJobs();
        typeOfJobs.setId(1L);

        Task task = new Task();
        task.setName("Виталий");
        task.setTypeOfJobId(typeOfJobs);
        id = taskRepository.save(task);

        Task myTask = taskRepository.findOne(id.getId());
        Assert.assertEquals(id.getId(), myTask.getId());
    }

    @Test
    public void findByNameTest() {
        final String NAME = "Виталий";
        TypeOfJobs typeOfJobs = new TypeOfJobs();
        typeOfJobs.setId(1L);
        typeOfJobs.setName("Наладка");

        Task task = new Task();
        task.setName(NAME);
        task.setTypeOfJobId(typeOfJobs);
        id = taskRepository.save(task);

        List<Task> actual = Arrays.asList(task);
        List<Task> expected = taskRepository.findByName(NAME);

        Assert.assertEquals(actual.get(0).getName(), expected.get(0).getName());
    }

    @After
    public void finish() {
        taskRepository.delete(id);
        final Task one = taskRepository.findOne(id.getId());
        assertNull(one);
    }
}