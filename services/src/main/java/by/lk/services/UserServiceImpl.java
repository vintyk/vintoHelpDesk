package by.lk.services;

import by.lk.dto.SystemUserDto;
import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import by.lk.repository.SystemUserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final SystemUserRepository systemUserRepository;

    @Autowired
    public UserServiceImpl(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public Long saveUser(SystemUserDto systemUserDto) {

        Privilege privilege = new Privilege();
        privilege.setId(systemUserDto.getPrivilegeId());

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser(systemUserDto.getNameUser());
        systemUser.setFamilyUser(systemUserDto.getFamilyUser());
        systemUser.setPasswordUser(quickPasswordEncodingGenerator(systemUserDto.getPasswordUser()));
        systemUser.setEmail(systemUserDto.getEmail());
        systemUser.setPrivilege(privilege);

        SystemUser userFromDb = systemUserRepository.save(systemUser);
        return userFromDb.getId();
    }

    @Override
    public SystemUser findByEmail(String name) {
        return systemUserRepository.findByEmail(name);
    }

    @Override
    public List<SystemUser> findAll() {
        return systemUserRepository.findAll();
    }

    @Override
    public SystemUser findById(Long id) {
        return systemUserRepository.findOne(id);
    }

    private String quickPasswordEncodingGenerator(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
