package org.example.quizz.model;

import lombok.Data;

import java.util.List;

@Data
public class Question {

    private int index;
    private String enonce;
    private String reponseCorrecte;
    private String[] reponsesFausses;
    private String difficulte;

    public Question(int index, String enonce, String reponseCorrecte, String[] reponsesFausses, String difficulte) {
        this.index = index;
        this.enonce = enonce;
        this.reponseCorrecte = reponseCorrecte;
        this.reponsesFausses = reponsesFausses;
        this.difficulte = difficulte;
    }

    // Getters et setters
}
