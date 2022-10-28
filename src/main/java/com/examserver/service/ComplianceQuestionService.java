package com.examserver.service;

import com.examserver.model.exam.ComplianceQuestion;
import com.examserver.model.exam.Test;

import java.util.Set;

public interface ComplianceQuestionService {
    public ComplianceQuestion addComplianceQuestion(ComplianceQuestion question);

    public ComplianceQuestion updateComplianceQuestion(ComplianceQuestion question);

    public Set<ComplianceQuestion> getComplianceQuestions();

    public ComplianceQuestion getComplianceQuestion(Long questionId);

    public Set<ComplianceQuestion> getComplianceQuestionsOfTest(Test test);

    public void deleteComplianceQuestion(Long questionId);

    public ComplianceQuestion getComplianceQuestionsId(Long questionsId);
}
