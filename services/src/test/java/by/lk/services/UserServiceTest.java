package by.lk.services;

import by.lk.dto.SystemUserDto;
import by.lk.entity.SystemUser;
import by.lk.repository.SystemUserRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class UserServiceTest extends CommonTest {
    private Long id;
    @Autowired
    private UserService userService;
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void saveUserTest() {
        SystemUserDto systemUserDto = new SystemUserDto();
        systemUserDto.setNameUser("Виталий");
        systemUserDto.setFamilyUser("Ушаков");
        systemUserDto.setEmail("v");
        systemUserDto.setPasswordUser("1");
        systemUserDto.setPrivilegeId(1L);
        id = userService.saveUser(systemUserDto);
    }
    @After
    public void finish() {
        systemUserRepository.delete(id);
        final SystemUser one = systemUserRepository.findOne(id);
        assertNull(one);
    }
}
