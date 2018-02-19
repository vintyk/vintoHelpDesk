package by.lk.services;

import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {

    void saveUser(String name,
                  String family,
                  String eMail,
                  String password,
                  Privilege privilege
    );

    SystemUser findByEmail(String name);

    List<SystemUser> findAll();

    SystemUser findById(Long id);
}
