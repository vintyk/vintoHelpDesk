package by.lk.services;

import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import by.lk.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public SystemUser findByEmail(String name) {
        return systemUserRepository.findByEmail(name);
    }

    @Override
    public void saveUser(
            String nameUser,
            String family,
            String eMail,
            String pass,
            Privilege privilege
            ) {
        final SystemUser systemUser = new SystemUser();
        systemUser.setNameUser(nameUser);
        systemUser.setFamilyUser(family);
        systemUser.setEmail(eMail);
        systemUser.setPasswordUser(quickPasswordEncodingGenerator(pass));
        systemUser.setPrivilege(privilege);
        systemUserRepository.save(systemUser);
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
