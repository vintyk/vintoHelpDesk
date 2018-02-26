package by.lk.services;

import by.lk.dto.SystemUserDto;
import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import by.lk.repository.SystemUserRepository;
import org.junit.Test;
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
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        SystemUser foundSystemUser = systemUserRepository.findByEmail(userEmail);
        if (foundSystemUser == null) {
            throw new UsernameNotFoundException("Такой E-Mail не найден в Базе Данных!");
        }
        return new User(foundSystemUser.getEmail(),
                foundSystemUser.getPasswordUser(),
                getUserAuthorities(foundSystemUser));
    }

    private Set<GrantedAuthority> getUserAuthorities(SystemUser systemUser) {
        Set<Privilege> roles = systemUser.getPrivilege();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Privilege role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNamePrivilege()));
        }
        return grantedAuthorities;
    }

    @Override
    public Long saveUser(SystemUserDto systemUserDto) {

        Set<Privilege> privileges = new HashSet<>();
        Privilege privilege = new Privilege();
        privilege.setId(systemUserDto.getPrivilegeId());
        privileges.add(privilege);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser(systemUserDto.getNameUser());
        systemUser.setFamilyUser(systemUserDto.getFamilyUser());
        systemUser.setPasswordUser(quickPasswordEncodingGenerator(systemUserDto.getPasswordUser()));
        systemUser.setEmail(systemUserDto.getEmail());
        systemUser.setPrivilege(privileges);
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
}
