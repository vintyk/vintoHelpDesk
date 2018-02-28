package by.lk.controller;

import by.lk.dto.TaskDto;
import by.lk.entity.SystemUser;
import by.lk.entity.TypeOfJobs;
import by.lk.repository.TypeOfJobsRepository;
import by.lk.services.TaskService;
import by.lk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

/**
 * Created by Vinty on 22.02.2018
 */
@Controller
public class HelpDeskController {
    private final TaskService taskService;
    private final TypeOfJobsRepository typeOfJobsRepository;
    private final UserService userService;

    @Autowired
    public HelpDeskController(TaskService taskService, TypeOfJobsRepository typeOfJobsRepository, UserService userService) {
        this.taskService = taskService;
        this.typeOfJobsRepository = typeOfJobsRepository;
        this.userService = userService;
    }

    @ModelAttribute("taskDto")
    public TaskDto taskDto() {
        return new TaskDto();
    }

    @ModelAttribute("typeOfJobs")
    public List<TypeOfJobs> typeOfJobs() {
        return typeOfJobsRepository.findAll();
    }

    @GetMapping(path = "/HelpDesk")
    public String showHelpDesk(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String systemUserEmail = user.getUsername();
        String branch = "";
        Collection<GrantedAuthority> priveleges = user.getAuthorities();
        if (priveleges.iterator().hasNext()){
            model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
        }
        model.addAttribute("systemUsername", systemUserEmail);
        model.addAttribute("Branch", systemUserEmail);
        return "HelpDesk";
    }

    @PostMapping(path = "/HelpDesk")
    public String taskDto(TaskDto taskDto, Model model) {
        taskDto.setTypeOfJobId(1L);
        taskService.saveTask(taskDto);
        return "HelpDesk";
    }
}
