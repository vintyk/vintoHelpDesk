package by.lk.repository;

import by.lk.config.RootConfig;
import by.lk.entity.Task;


import by.lk.entity.TypeOfJobs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void save() {
        TypeOfJobs typeOfJobs = new TypeOfJobs();
        typeOfJobs.setId(1L);

        Task task = new Task();
        task.setName("Коля");
        task.setTypeOfJobId(typeOfJobs);
        taskRepository.save(task);

        Task myTask = taskRepository.findOne(1L);
        System.out.println(myTask.getName());
        System.out.println(myTask.getTypeOfJobId().getName());



    }
}