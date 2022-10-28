package com.examserver.model.exam;

import javax.persistence.*;

@Entity
public class OpenQuestion extends Question {

    private String answer;

    public OpenQuestion() {
    }

    @Transient
    private String givenAnswer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }
}
