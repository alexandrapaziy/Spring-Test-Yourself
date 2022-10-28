package com.examserver.model.exam;

import javax.persistence.*;

@Entity
public class ComplianceQuestion extends Question {
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    public ComplianceQuestion() {
    }

    @Transient
    private String givenAnswer1;

    @Transient
    private String givenAnswer2;

    @Transient
    private String givenAnswer3;

    @Transient
    private String givenAnswer4;

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getOptionE() {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getGivenAnswer1() {
        return givenAnswer1;
    }

    public void setGivenAnswer1(String givenAnswer1) {
        this.givenAnswer1 = givenAnswer1;
    }

    public String getGivenAnswer2() {
        return givenAnswer2;
    }

    public void setGivenAnswer2(String givenAnswer2) {
        this.givenAnswer2 = givenAnswer2;
    }

    public String getGivenAnswer3() {
        return givenAnswer3;
    }

    public void setGivenAnswer3(String givenAnswer3) {
        this.givenAnswer3 = givenAnswer3;
    }

    public String getGivenAnswer4() {
        return givenAnswer4;
    }

    public void setGivenAnswer4(String givenAnswer4) {
        this.givenAnswer4 = givenAnswer4;
    }
}

