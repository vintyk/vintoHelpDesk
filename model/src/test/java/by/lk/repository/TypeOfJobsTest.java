package by.lk.repository;

import by.lk.config.RootConfig;
import by.lk.entity.TypeOfJobs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TypeOfJobsTest {
    private TypeOfJobs id;
    @Autowired
    private TypeOfJobsRepository typeOfJobsRepository;

    @Test
    public void saveTest() {
        TypeOfJobs newTypeOfJobs = new TypeOfJobs();
        newTypeOfJobs.setName("Починка принтеров");
        id = typeOfJobsRepository.save(newTypeOfJobs);

        TypeOfJobs typeOfJobFromDb = typeOfJobsRepository.findOne(id.getId());
        Assert.assertEquals(id.getId(), typeOfJobFromDb.getId());
    }

    @After
    public void finish() {
        typeOfJobsRepository.delete(id);
    }
}