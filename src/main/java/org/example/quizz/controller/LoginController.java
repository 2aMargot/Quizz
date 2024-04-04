package org.example.quizz.controller;


import org.example.quizz.model.Question;
import org.example.quizz.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("pseudo") String pseudo, Model model) {

        User user = new User();
        user.setPseudo(pseudo);
        user.setIndex(0);

        model.addAttribute("user", user);

        user.addQuestion(new Question(
                1,
                "Quelle est la capitale de la France ?",
                "Paris",
                new String[] {"Londres", "Berlin", "Lyon"},
                "facile"));
        user.addQuestion(new Question(
                2,
                "Quelle est la plus grande planète du système solaire ?",
                "Jupiter",
                new String[] {"Mars", "Saturne", "Neptune"},
                "facile"));
        user.addQuestion(new Question(
                3,
                "Qui a peint la Joconde ?",
                "Leonardo da Vinci",
                new String[] {"Pablo Picasso", "Vincent van Gogh", "Michel-Ange"},
                "facile"));
        user.addQuestion(new Question(
                4,
                "Quel est le plus haut sommet du monde ?",
                "Mont Everest",
                new String[] {"Mont Kilimandjaro", "Mont Blanc", "Mont Fuji"},
                "facile"));

        return "redirect:/question";
    }
}
