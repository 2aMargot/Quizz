package org.example.quizz.model;
import lombok.Data;
import org.example.quizz.model.Question;

import java.util.ArrayList;

@Data
public class User {

    protected String pseudo;
    protected int index;
    protected int score = 0;
    protected ArrayList<Question> listeQuestion = new ArrayList<>();


    public void addQuestion (Question question){
        listeQuestion.add(question);
    }



}
