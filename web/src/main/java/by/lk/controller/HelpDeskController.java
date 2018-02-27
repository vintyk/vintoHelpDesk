package by.lk.controller;

import by.lk.dto.TaskDto;
import by.lk.entity.Privilege;
import by.lk.repository.PrivilegeRepository;
import by.lk.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by Vinty on 22.02.2018
 */
@Controller
public class HelpDeskController {
    private final TaskService taskService;
    private final PrivilegeRepository privilegeRepository;

    @Autowired
    public HelpDeskController(TaskService taskService, PrivilegeRepository privilegeRepository) {
        this.taskService = taskService;
        this.privilegeRepository = privilegeRepository;
    }

    @ModelAttribute("taskDto")
    public TaskDto taskDto(){
        return new TaskDto();
    }
    @ModelAttribute("privileges")
    public List<Privilege> privilege(){
        return privilegeRepository.findAll();
    }

    @GetMapping(path = "/HelpDesk")
    public String showHelpDesk() {
        return "HelpDesk";
    }

    @PostMapping(path = "/HelpDesk")
    public String taskDto(TaskDto taskDto, Model model) {
        taskDto.setTypeOfJobId(1L);
        taskService.saveTask(taskDto);
        return "HelpDesk";
    }
}
