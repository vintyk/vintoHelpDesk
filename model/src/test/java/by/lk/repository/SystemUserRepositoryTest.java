package by.lk.repository;

import by.lk.config.RootConfig;
import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SystemUserRepositoryTest {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void findByEmailTest() {
        Privilege privilege = new Privilege();
        privilege.setId(1L);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser("Виталий");
        systemUser.setFamilyUser("Ушаков");
        systemUser.setPasswordUser("1");
        systemUser.setEmail("vinty@i.ua");
        systemUser.setPrivilege(privilege);
        final SystemUser id = systemUserRepository.save(systemUser);
        final SystemUser userFromDb = systemUserRepository.findOne(id.getId());
        Assert.assertEquals(id.getId(), userFromDb.getId());

        systemUserRepository.delete(id.getId());
    }
}