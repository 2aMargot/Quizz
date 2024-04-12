package org.example.quizz.controller;

import jakarta.servlet.http.HttpSession;
import org.example.quizz.model.Question;
import org.example.quizz.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class QuizzController {

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam("selectedAnswer") String answer,
                               HttpSession session,
                               Model model) {

        User user = (User) session.getAttribute("user");

        List<Question> questions = user.getListeQuestion();
        int index = user.getIndex();

        if (index >= 0 && index < questions.size()){
            if (questions.get(index).getReponseCorrecte().equalsIgnoreCase(answer)) {
                user.setScore(user.getScore()+1);
            }

            index++;
            user.setIndex(index);
            model.addAttribute("user", user);
            session.setAttribute("user", user);

            return "question";
        } else {

            model.addAttribute("user", user);
            session.setAttribute("user", user);

            return "result";
        }


    }


}
