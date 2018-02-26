package by.lk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Vinty on 22.02.2018
 */
@Controller
public class HelpDeskController {

    @GetMapping(path = "/HelpDesk")
    public String showHelpDesk() {
        return "HelpDesk";
    }
}
