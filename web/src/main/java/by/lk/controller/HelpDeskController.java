package by.lk.controller;

import by.lk.dto.TaskDto;
import by.lk.entity.SystemUser;
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

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vinty on 22.02.2018
 */
@Controller
public class HelpDeskController {
    private final TaskService taskService;
    private final UserService userService;
    private Long userId;

    @Autowired
    public HelpDeskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @ModelAttribute("taskDto")
    public TaskDto taskDto() {
        return new TaskDto();
    }

    @GetMapping(path = "/HelpDesk")
    public String showHelpDesk(Model model, HttpSession httpSession) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String systemUserEmail = user.getUsername();
        model.addAttribute("systemUsername", systemUserEmail);
        SystemUser systemUser = userService.findByEmail(systemUserEmail);

        userId = systemUser.getId();
        List<TaskDto> allTasks = taskService.findBySystemUserId(userId);
        model.addAttribute("taskDtoList", allTasks);

        httpSession.setAttribute("httpUserId", systemUser.getId());
        httpSession.setAttribute("httpBranch", systemUser.getBranch());
        httpSession.setAttribute("httpSubdivision", systemUser.getSubdivision());
        httpSession.setAttribute("httpEmail", systemUser.getEmail());
        Collection<GrantedAuthority> priveleges = user.getAuthorities();
        if (priveleges.iterator().hasNext()) {
            httpSession.setAttribute("httpUserAuthority", priveleges.iterator().next().getAuthority().toString());
            model.addAttribute("userAuthority", priveleges.iterator().next().getAuthority().toString());
//            model.addAttribute("userAuthority", httpSession.getAttribute("httpUserAuthority"));
        }
        return "HelpDesk";
    }

    @PostMapping(path = "/HelpDesk")
    public String taskDto(TaskDto taskDtoFromView, Model model, HttpSession httpSession) {
        taskDtoFromView.setSystemUser((Long) httpSession.getAttribute("httpUserId"));
        taskService.saveTask(taskDtoFromView);
        model.addAttribute("systemUsername", httpSession.getAttribute("httpEmail"));
        model.addAttribute("userAuthority", httpSession.getAttribute("httpUserAuthority"));
        return "redirect:/HelpDesk";
    }
}
