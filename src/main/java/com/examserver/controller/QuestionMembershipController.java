package com.examserver.controller;

import com.examserver.model.exam.Test;
import com.examserver.service.QuestionMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
@CrossOrigin("*")
public class QuestionMembershipController {

    @Autowired
    private QuestionMembershipService questionMembershipService;

    @GetMapping("/")
    public Long countQuestionMembership() {
        return questionMembershipService.count();
    }

    @GetMapping("/test/{testId}")
    public int countQuestionMembershipOfTest(@PathVariable("testId") Test testId) {
        return questionMembershipService.countQuestionMembership(testId);
    }
}
