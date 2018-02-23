package by.lk.services;

import by.lk.dto.SystemUserDto;
import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import by.lk.repository.SystemUserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.*;


public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;
    @Autowired
    private SystemUserRepository systemUserRepository;

//    @Test
//    public void findByEmail() {
//
//    }

    @Test
    public void saveUserTest() {
        SystemUserDto systemUserDto = new SystemUserDto();
        systemUserDto.setNameUser("Виталий");
        systemUserDto.setFamilyUser("Ушаков");
        systemUserDto.setEmail("v");
        systemUserDto.setPasswordUser("1");
        systemUserDto.setPrivilegeId(1L);
        Long userId = userService.saveUser(systemUserDto);
        System.out.println(userId);
//        systemUserRepository.delete(userId);
    }
}

//    @Test
//    public void findAll() {
//    }
//
//    @Test
//    public void findById() {
//    }
//
//    @Test
//    public void loadUserByUsername() {
//    }
//}