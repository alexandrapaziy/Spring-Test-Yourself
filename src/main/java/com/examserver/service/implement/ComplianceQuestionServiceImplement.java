package com.examserver.service.implement;

import com.examserver.model.exam.ComplianceQuestion;
import com.examserver.model.exam.Test;
import com.examserver.repository.ComplianceQuestionRepository;
import com.examserver.service.ComplianceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ComplianceQuestionServiceImplement implements ComplianceQuestionService {

    @Autowired
    private ComplianceQuestionRepository complianceQuestionRepository;

    @Override
    public ComplianceQuestion addComplianceQuestion(ComplianceQuestion question) {
        return this.complianceQuestionRepository.save(question);
    }

    @Override
    public ComplianceQuestion updateComplianceQuestion(ComplianceQuestion question) {
        return this.complianceQuestionRepository.save(question);
    }

    @Override
    public Set<ComplianceQuestion> getComplianceQuestions() {
        return new HashSet<>(this.complianceQuestionRepository.findAll());
    }

    @Override
    public ComplianceQuestion getComplianceQuestion(Long questionId) {
        return this.complianceQuestionRepository.findById(questionId).get();
    }

    @Override
    public Set<ComplianceQuestion> getComplianceQuestionsOfTest(Test test) {
        return this.complianceQuestionRepository.findByTest(test);
    }

    @Override
    public void deleteComplianceQuestion(Long questionId) {
        ComplianceQuestion complianceQuestion = new ComplianceQuestion();
        complianceQuestion.setQuestionId(questionId);
        this.complianceQuestionRepository.delete(complianceQuestion);
    }

    @Override
    public ComplianceQuestion getComplianceQuestionsId(Long questionsId) {
        return this.complianceQuestionRepository.getOne(questionsId);
    }
}

