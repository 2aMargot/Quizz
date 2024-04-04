package org.example.quizz.controller;

import org.example.quizz.model.Question;
import org.example.quizz.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes("user")
public class QuizzController {

    @GetMapping("/question")
    public String showQuizz(Model model, @ModelAttribute("user") User user) {

        String pseudo = user.getPseudo();
        int index = user.getIndex();

        ArrayList<Question> questions = user.getListeQuestion();

        if (index >= 0 && index < questions.size()) {

            Question question = questions.get(index);
            model.addAttribute("pseudo", pseudo);
            model.addAttribute("question", question);
            return "question";

        } else {

            return "resultats";
        }
    }

    @PostMapping("/question/submit")
    public String submitAnswer(@RequestParam("answer") String answer,
                               @ModelAttribute("user") User user) {

        List<Question> questions = user.getListeQuestion();
        int index = user.getIndex();

        if (questions.get(index).getReponseCorrecte().equalsIgnoreCase(answer)) {
            user.setScore(user.getScore()+1);
        }

        index++;
        user.setIndex(index);

        return "redirect:/question";
    }
}
