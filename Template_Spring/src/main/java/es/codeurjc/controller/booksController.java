package es.codeurjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class booksController {
    @GetMapping("/books")
    public String personal_data(Model model) {
        return "books.html";
    }
}

