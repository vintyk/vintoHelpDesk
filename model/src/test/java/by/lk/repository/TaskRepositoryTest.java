package by.lk.repository;

import by.lk.entity.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNull;

public class TaskRepositoryTest extends CommonTest {
    private Task taskId;
    private SystemUser userId;

    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void saveTest() {
        TypeOfJobs typeOfJobs = new TypeOfJobs();
        typeOfJobs.setId(1L);

        Set<Privilege> privileges = new HashSet<>();
        Privilege privilege = new Privilege();
        privilege.setId(1L);
        privileges.add(privilege);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser("Тестовое Имя");
        systemUser.setFamilyUser("Тестовая фамилия");
        systemUser.setPasswordUser("какойто пароль");
        systemUser.setEmail("vvv@testMail.com");
        systemUser.setPrivilege(privileges);
        userId = systemUserRepository.save(systemUser);

        Task task = new Task();
        task.setName("Виталий");
        task.setTypeOfJobId(typeOfJobs);
        task.setText("Это заявка в свободной форме.");

        task.setSystemUser(systemUser);
        taskId = taskRepository.save(task);

        Task myTask = taskRepository.findOne(taskId.getId());
        Assert.assertEquals(taskId.getId(), myTask.getId());
        systemUserRepository.delete(userId);
    }

    @Test
    public void findByNameTest() {
        String NAME = "Виталий";
        TypeOfJobs typeOfJobs = new TypeOfJobs();
        typeOfJobs.setId(1L);
        typeOfJobs.setName("Наладка");


        Task task = new Task();
        task.setName(NAME);
        task.setTypeOfJobId(typeOfJobs);
        task.setText("Это заявка в свободной форме 2.");

        taskId = taskRepository.save(task);

        List<Task> actual = Arrays.asList(task);
        List<Task> expected = taskRepository.findByName(NAME);
        Assert.assertEquals(actual.get(0).getName(), expected.get(0).getName());
    }

    @After
    public void finish() {
        taskRepository.delete(taskId);
        final Task one = taskRepository.findOne(taskId.getId());
        assertNull(one);
    }
}