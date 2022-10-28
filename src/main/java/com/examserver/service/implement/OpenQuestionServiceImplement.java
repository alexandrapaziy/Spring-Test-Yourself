package com.examserver.service.implement;

import com.examserver.model.exam.OpenQuestion;
import com.examserver.model.exam.Test;
import com.examserver.repository.OpenQuestionRepository;
import com.examserver.service.OpenQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OpenQuestionServiceImplement implements OpenQuestionService {

    @Autowired
    private OpenQuestionRepository openQuestionRepository;

    @Override
    public OpenQuestion addOpenQuestion(OpenQuestion question) {
        return this.openQuestionRepository.save(question);
    }

    @Override
    public OpenQuestion updateOpenQuestion(OpenQuestion question) {
        return this.openQuestionRepository.save(question);
    }

    @Override
    public Set<OpenQuestion> getOpenQuestions() {
        return new HashSet<>(this.openQuestionRepository.findAll());
    }

    @Override
    public OpenQuestion getOpenQuestion(Long questionId) {
        return this.openQuestionRepository.findById(questionId).get();
    }

    @Override
    public Set<OpenQuestion> getOpenQuestionsOfTest(Test test) {
        return this.openQuestionRepository.findByTest(test);
    }

    @Override
    public void deleteOpenQuestion(Long questionId) {
        OpenQuestion openQuestion = new OpenQuestion();
        openQuestion.setQuestionId(questionId);
        this.openQuestionRepository.delete(openQuestion);
    }

    @Override
    public OpenQuestion getOpenQuestionsId(Long questionsId) {
        return this.openQuestionRepository.getOne(questionsId);
    }
}
