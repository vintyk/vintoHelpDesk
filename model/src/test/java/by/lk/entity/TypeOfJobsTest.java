package by.lk.entity;

import by.lk.config.RootConfig;
import by.lk.repository.TypeOfJobsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TypeOfJobsTest {

    @Autowired
    private TypeOfJobsRepository typeOfJobsRepository;

    @Test
    public void saveTest(){
        TypeOfJobs typeOfJobs = new TypeOfJobs();
        typeOfJobs.setName("Починка принтеров");
        TypeOfJobs type = typeOfJobsRepository.findOne(1L);
        System.out.println(type);
    }
}