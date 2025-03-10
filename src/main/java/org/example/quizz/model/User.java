package org.example.quizz.model;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class User implements Serializable {

    protected String pseudo;
    protected int index;
    protected int score = 0;
    protected List<Question> listeQuestion = new ArrayList<>();


    public void addQuestion (Question question){
        listeQuestion.add(question);
    }



}
