package by.lk.Starter;

import by.lk.dto.SystemUserDto;
import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import by.lk.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    public static void main(String[] args) {

        SystemUserRepository systemUserRepository = null;

        Privilege privilege = new Privilege();
        privilege.setId(1L);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser("Виталий");
        systemUser.setFamilyUser("Ушаков");
        systemUser.setPasswordUser("1");
        systemUser.setEmail("vinty@i.ua");
        systemUser.setPrivilege(privilege);

        systemUserRepository.save(systemUser);

    }

}
