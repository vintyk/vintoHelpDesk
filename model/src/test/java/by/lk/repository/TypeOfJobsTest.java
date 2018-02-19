package by.lk.repository;

import by.lk.config.RootConfig;
import by.lk.entity.TypeOfJobs;
import by.lk.repository.TypeOfJobsRepository;
import org.junit.Assert;
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
        TypeOfJobs newTypeOfJobs = new TypeOfJobs();
        newTypeOfJobs.setName("Починка принтеров");
        TypeOfJobs id = typeOfJobsRepository.save(newTypeOfJobs);

        TypeOfJobs typeOfJobFromDb = typeOfJobsRepository.findOne(id.getId());
        Assert.assertEquals(id.getId(), typeOfJobFromDb.getId());
    }
}