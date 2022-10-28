package com.examserver.service;

import com.examserver.model.exam.CommonQuestion;
import com.examserver.model.exam.Test;

import java.util.Set;

public interface CommonQuestionService {

    public CommonQuestion addCommonQuestion(CommonQuestion question);

    public CommonQuestion updateCommonQuestion(CommonQuestion question);

    public Set<CommonQuestion> getCommonQuestions();

    public CommonQuestion getCommonQuestion(Long questionId);

    public Set<CommonQuestion> getCommonQuestionsOfTest(Test test);

    public void deleteCommonQuestion(Long questionId);

    public CommonQuestion getCommonQuestionsId(Long questionsId);
}
