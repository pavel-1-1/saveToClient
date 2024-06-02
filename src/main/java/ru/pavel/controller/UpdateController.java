package ru.pavel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pavel.service.UpdateService;

@Controller
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @GetMapping("/update")
    public String update(Model model) {
        model.addAttribute("outFiles", updateService.update());
        return "index";
    }
}
