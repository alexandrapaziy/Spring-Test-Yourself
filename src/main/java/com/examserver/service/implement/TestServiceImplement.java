package com.examserver.service.implement;

import com.examserver.model.exam.Category;
import com.examserver.model.exam.Test;
import com.examserver.repository.TestRepository;
import com.examserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TestServiceImplement implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test addTest(Test test) {
        return this.testRepository.save(test);
    }

    @Override
    public Test updateTest(Test test) {
        return this.testRepository.save(test);
    }

    @Override
    public Set<Test> getTests() {
        return new HashSet<>(this.testRepository.findAll());
    }

    @Override
    public Test getTest(Long testId) {
        return this.testRepository.findById(testId).get();
    }

    @Override
    public void deleteTest(Long testId) {
        this.testRepository.deleteById(testId);
    }

    @Override
    public List<Test> getTestsOfCategory(Category category) {
        return this.testRepository.findByCategory(category);
    }

    @Override
    public List<Test> getActiveTests() {
        return this.testRepository.findByActive(true);
    }

    @Override
    public List<Test> getActiveTestsOfCategory(Category category) {
        return this.testRepository.findByCategoryAndActive(category, true);
    }
}
