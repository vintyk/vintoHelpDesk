package by.lk.controller;

import by.lk.dto.SystemUserDto;
import by.lk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Vinty on 02.07.2017.
 */
@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("systemUsersDto")
    public SystemUserDto systemUsersDto() {
        return new SystemUserDto();
    }

    @GetMapping(path = "/registration")
    public String showRegistrationForm() {
        return "Registration";
    }

    @PostMapping(path = "/registration")
    public String tempSystemUsersDto(SystemUserDto systemUsersDto, Model model) {
        SystemUserDto systemUserDtoForDB = new SystemUserDto();
        systemUserDtoForDB.setNameUser(systemUsersDto.getNameUser());
        systemUserDtoForDB.setFamilyUser(systemUsersDto.getFamilyUser());
        systemUserDtoForDB.setEmail(systemUsersDto.getEmail());
        systemUserDtoForDB.setPasswordUser(systemUsersDto.getPasswordUser());
        systemUserDtoForDB.setPrivilegeId(1L);
        userService.saveUser(systemUserDtoForDB);
        return "/Registration";
    }
}
