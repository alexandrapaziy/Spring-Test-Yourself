package com.examserver.controller;

import com.examserver.model.exam.OpenQuestion;
import com.examserver.model.exam.Question;
import com.examserver.model.exam.Test;
import com.examserver.service.OpenQuestionService;
import com.examserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/open-question")
@CrossOrigin("*")
public class OpenQuestionsController {

    @Autowired
    private OpenQuestionService openQuestionService;

    @PostMapping("/")
    public ResponseEntity<Question> addOpenQuestion(@RequestBody OpenQuestion question) {
        return ResponseEntity.ok(this.openQuestionService.addOpenQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateOpenQuestion(@RequestBody OpenQuestion question) {
        return ResponseEntity.ok(this.openQuestionService.updateOpenQuestion(question));
    }

    @GetMapping("/test/{testId}")
    public ResponseEntity<?> getOpenQuestionsOfTest(@PathVariable("testId") Long testId) {
        Test test = new Test();
        test.setTestId(testId);
        Set<OpenQuestion> openQuestionsOfTest = this.openQuestionService.getOpenQuestionsOfTest(test);
        List<OpenQuestion> list = new ArrayList(openQuestionsOfTest);
        if (list.size() > openQuestionsOfTest.size()) {
            list = list.subList(0, openQuestionsOfTest.size() + 1);
        }

        list.forEach((q) -> {
            q.setAnswer("");
        });

        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/test/all/{testId}")
    public ResponseEntity<?> getOpenQuestionsOfTestAdmin(@PathVariable("testId") Long testId) {
        Test test = new Test();
        test.setTestId(testId);
        Set<OpenQuestion> openQuestionsOfTest = this.openQuestionService.getOpenQuestionsOfTest(test);
        return ResponseEntity.ok(openQuestionsOfTest);
    }

    @GetMapping("/{questionId}")
    public OpenQuestion getOpenQuestion(@PathVariable("questionId") Long questionId) {
        return this.openQuestionService.getOpenQuestion(questionId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteOpenQuestion(@PathVariable("questionId") Long questionId) {
        this.openQuestionService.deleteOpenQuestion(questionId);
    }

    @PostMapping("/evaluation-test")
    public ResponseEntity<?> evaluationTest(@RequestBody List<OpenQuestion> openQuestions) {
        System.out.println(openQuestions);

        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;

        for (OpenQuestion q : openQuestions) {
            OpenQuestion openQuestion = this.openQuestionService.getOpenQuestionsId(q.getQuestionId());
            if (openQuestion.getAnswer().equals(q.getGivenAnswer())) {
                correctAnswers++;
                double markSingle = Double.parseDouble(openQuestions.get(0).getTest().getMaxMark()) / openQuestions.size();
                marksGot += markSingle;
            }

            if (q.getGivenAnswer() != null) {
                attempted++;
            }
        }

        Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted", attempted);
        return ResponseEntity.ok(map);
    }
}
