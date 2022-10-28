package com.examserver.service;

import com.examserver.model.exam.OpenQuestion;
import com.examserver.model.exam.Test;

import java.util.Set;

public interface OpenQuestionService {

    public OpenQuestion addOpenQuestion(OpenQuestion question);

    public OpenQuestion updateOpenQuestion(OpenQuestion question);

    public Set<OpenQuestion> getOpenQuestions();

    public OpenQuestion getOpenQuestion(Long questionId);

    public Set<OpenQuestion> getOpenQuestionsOfTest(Test test);

    public void deleteOpenQuestion(Long questionId);

    public OpenQuestion getOpenQuestionsId(Long questionsId);
}
