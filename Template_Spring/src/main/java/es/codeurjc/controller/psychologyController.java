package es.codeurjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class psychologyController {
    @GetMapping("/psychology")
    public String personal_data(Model model) {
        return "psychology";
    }
}