package by.lk.repository;

import by.lk.config.RootConfig;
import by.lk.entity.Task;
import by.lk.entity.TypeOfJobs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TaskRepositoryTest {
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
    }
}