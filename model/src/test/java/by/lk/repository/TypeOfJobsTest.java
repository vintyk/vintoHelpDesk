package by.lk.repository;

import by.lk.entity.TypeOfJobs;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeOfJobsTest extends CommonTest {
    private TypeOfJobs id;
    @Autowired
    private TypeOfJobsRepository typeOfJobsRepository;

    @Test
    public void saveTest() {
        TypeOfJobs newTypeOfJobs = new TypeOfJobs();
        newTypeOfJobs.setName("Починка принтеров");
        id = typeOfJobsRepository.save(newTypeOfJobs);

        TypeOfJobs typeOfJobFromDb = typeOfJobsRepository.findOne(id.getId());
        assertEquals(id.getId(), typeOfJobFromDb.getId());
    }

    @After
    public void finish() {
        typeOfJobsRepository.delete(id);
        final TypeOfJobs one = typeOfJobsRepository.findOne(id.getId());
        assertNull(one);
    }
}