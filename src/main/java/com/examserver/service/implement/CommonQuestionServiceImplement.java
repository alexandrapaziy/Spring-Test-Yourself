package com.examserver.service.implement;

import com.examserver.model.exam.CommonQuestion;
import com.examserver.model.exam.Test;
import com.examserver.repository.CommonQuestionRepository;
import com.examserver.service.CommonQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CommonQuestionServiceImplement implements CommonQuestionService {

    @Autowired
    private CommonQuestionRepository commonQuestionRepository;

    @Override
    public CommonQuestion addCommonQuestion(CommonQuestion question) {
        return this.commonQuestionRepository.save(question);
    }

    @Override
    public CommonQuestion updateCommonQuestion(CommonQuestion question) {
        return this.commonQuestionRepository.save(question);
    }

    @Override
    public Set<CommonQuestion> getCommonQuestions() {
        return new HashSet<>(this.commonQuestionRepository.findAll());
    }

    @Override
    public CommonQuestion getCommonQuestion(Long questionId) {
        return this.commonQuestionRepository.findById(questionId).get();
    }

    @Override
    public Set<CommonQuestion> getCommonQuestionsOfTest(Test test) {
        return this.commonQuestionRepository.findByTest(test);
    }

    @Override
    public void deleteCommonQuestion(Long questionId) {
        CommonQuestion commonQuestion = new CommonQuestion();
        commonQuestion.setQuestionId(questionId);
        this.commonQuestionRepository.delete(commonQuestion);
    }

    @Override
    public CommonQuestion getCommonQuestionsId(Long questionsId) {
        return this.commonQuestionRepository.getOne(questionsId);
    }
}
