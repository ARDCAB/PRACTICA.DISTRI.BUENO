package es.codeurjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class allBooksController {
    @GetMapping("/allBooks")
    public String personal_data(Model model) {
        return "allBooks.html";
    }
}

