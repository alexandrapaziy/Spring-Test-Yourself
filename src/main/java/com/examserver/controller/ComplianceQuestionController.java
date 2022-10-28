package com.examserver.controller;

import com.examserver.model.exam.ComplianceQuestion;
import com.examserver.model.exam.Question;
import com.examserver.model.exam.Test;
import com.examserver.service.ComplianceQuestionService;
import com.examserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/compliance-question")
@CrossOrigin("*")
public class ComplianceQuestionController {
    @Autowired
    private ComplianceQuestionService complianceQuestionService;

    @PostMapping("/")
    public ResponseEntity<Question> addComplianceQuestion(@RequestBody ComplianceQuestion question) {
        return ResponseEntity.ok(this.complianceQuestionService.addComplianceQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateComplianceQuestion(@RequestBody ComplianceQuestion question) {
        return ResponseEntity.ok(this.complianceQuestionService.updateComplianceQuestion(question));
    }

    @GetMapping("/test/{testId}")
    public ResponseEntity<?> getComplianceQuestionsOfTest(@PathVariable("testId") Long testId) {
        Test test = new Test();
        test.setTestId(testId);
        Set<ComplianceQuestion> complianceQuestionsOfTest = this.complianceQuestionService.getComplianceQuestionsOfTest(test);
        List<ComplianceQuestion> list = new ArrayList(complianceQuestionsOfTest);
        if (list.size() > complianceQuestionsOfTest.size()) {
            list = list.subList(0, complianceQuestionsOfTest.size() + 1);
        }

        list.forEach((q) -> {
            q.setAnswer1("");
            q.setAnswer2("");
            q.setAnswer3("");
            q.setAnswer4("");
        });

        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/test/all/{testId}")
    public ResponseEntity<?> getComplianceQuestionsOfTestAdmin(@PathVariable("testId") Long testId) {
        Test test = new Test();
        test.setTestId(testId);
        Set<ComplianceQuestion> complianceQuestionsOfTest = this.complianceQuestionService.getComplianceQuestionsOfTest(test);
        return ResponseEntity.ok(complianceQuestionsOfTest);
    }

    @GetMapping("/{questionId}")
    public ComplianceQuestion getComplianceQuestion(@PathVariable("questionId") Long questionId) {
        return this.complianceQuestionService.getComplianceQuestion(questionId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteComplianceQuestion(@PathVariable("questionId") Long questionId) {
        this.complianceQuestionService.deleteComplianceQuestion(questionId);
    }

    @PostMapping("/evaluation-test")
    public ResponseEntity<?> evaluationTest(@RequestBody List<ComplianceQuestion> complianceQuestions) {
        System.out.println(complianceQuestions);

        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;

        for (ComplianceQuestion q : complianceQuestions) {
            ComplianceQuestion complianceQuestion = this.complianceQuestionService.getComplianceQuestionsId(q.getQuestionId());
            if (complianceQuestion.getAnswer1().equals(q.getGivenAnswer1())
                    && complianceQuestion.getAnswer2().equals(q.getGivenAnswer2())
                    && complianceQuestion.getAnswer3().equals(q.getGivenAnswer3())
                    && complianceQuestion.getAnswer4().equals(q.getGivenAnswer4())) {
                correctAnswers++;
                double markSingle = Double.parseDouble(complianceQuestions.get(0).getTest().getMaxMark()) / complianceQuestions.size();
                marksGot += markSingle;
            }

            if (q.getGivenAnswer1() != null
                    && q.getGivenAnswer2() != null
                    && q.getGivenAnswer3() != null
                    && q.getGivenAnswer4() != null) {
                attempted++;
            }
        }

        Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted", attempted);
        return ResponseEntity.ok(map);
    }
}

