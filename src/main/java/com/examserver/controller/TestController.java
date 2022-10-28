package com.examserver.controller;

import com.examserver.model.exam.Category;
import com.examserver.model.exam.Test;
import com.examserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/")
    public ResponseEntity<Test> addTest(@RequestBody Test test) {
        return ResponseEntity.ok(this.testService.addTest(test));
    }

    @PutMapping("/")
    public ResponseEntity<Test> updateTest(@RequestBody Test test) {
        return ResponseEntity.ok(this.testService.updateTest(test));
    }

    @GetMapping("/")
    public ResponseEntity<?> getTests() {
        return ResponseEntity.ok(this.testService.getTests());
    }

    @GetMapping("/{testId}")
    public Test getTest(@PathVariable("testId") Long testId) {
        return this.testService.getTest(testId);
    }

    @DeleteMapping("/{testId}")
    public void deleteTest(@PathVariable("testId") Long testId) {
        this.testService.deleteTest(testId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Test> getTestsOfCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return this.testService.getTestsOfCategory(category);
    }

    @GetMapping("/active")
    public List<Test> getActiveTests() {
        return this.testService.getActiveTests();
    }

    @GetMapping("/category/active/{categoryId}")
    public List<Test> getActiveTests(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return this.testService.getActiveTestsOfCategory(category);
    }
}
