package com.examserver.controller;

import com.examserver.model.exam.CommonQuestion;
import com.examserver.model.exam.Question;
import com.examserver.model.exam.Test;
import com.examserver.service.CommonQuestionService;
import com.examserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/common-question")
@CrossOrigin("*")
public class CommonQuestionController {

    @Autowired
    private CommonQuestionService commonQuestionService;

    @PostMapping("/")
    public ResponseEntity<Question> addCommonQuestion(@RequestBody CommonQuestion question) {
        return ResponseEntity.ok(this.commonQuestionService.addCommonQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateCommonQuestion(@RequestBody CommonQuestion question) {
        return ResponseEntity.ok(this.commonQuestionService.updateCommonQuestion(question));
    }

    @GetMapping("/test/{testId}")
    public ResponseEntity<?> getCommonQuestionsOfTest(@PathVariable("testId") Long testId) {
        Test test = new Test();
        test.setTestId(testId);
        Set<CommonQuestion> commonQuestionsOfTest = this.commonQuestionService.getCommonQuestionsOfTest(test);
        List<CommonQuestion> list = new ArrayList(commonQuestionsOfTest);
        if (list.size() > commonQuestionsOfTest.size()) {
            list = list.subList(0, commonQuestionsOfTest.size() + 1);
        }

        list.forEach((q) -> {
            q.setAnswer("");
        });

        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/test/all/{testId}")
    public ResponseEntity<?> getCommonQuestionsOfTestAdmin(@PathVariable("testId") Long testId) {
        Test test = new Test();
        test.setTestId(testId);
        Set<CommonQuestion> commonQuestionsOfTest = this.commonQuestionService.getCommonQuestionsOfTest(test);
        return ResponseEntity.ok(commonQuestionsOfTest);
    }

    @GetMapping("/{questionId}")
    public CommonQuestion getCommonQuestion(@PathVariable("questionId") Long questionId) {
        return this.commonQuestionService.getCommonQuestion(questionId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteCommonQuestion(@PathVariable("questionId") Long questionId) {
        this.commonQuestionService.deleteCommonQuestion(questionId);
    }

    @PostMapping("/evaluation-test")
    public ResponseEntity<?> evaluationTest(@RequestBody List<CommonQuestion> commonQuestions) {
        System.out.println(commonQuestions);

        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;

        for (CommonQuestion q : commonQuestions) {
            CommonQuestion commonQuestion = this.commonQuestionService.getCommonQuestionsId(q.getQuestionId());
            if (commonQuestion.getAnswer().equals(q.getGivenAnswer())) {
                correctAnswers++;
                double markSingle = Double.parseDouble(commonQuestions.get(0).getTest().getMaxMark()) / commonQuestions.size();
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
