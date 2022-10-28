package com.examserver.service;

import com.examserver.model.exam.Category;
import com.examserver.model.exam.Test;

import java.util.List;
import java.util.Set;

public interface TestService {

    public Test addTest(Test test);

    public Test updateTest(Test test);

    public Set<Test> getTests();

    public Test getTest(Long testId);

    public void deleteTest(Long testId);

    public List<Test> getTestsOfCategory(Category category);

    public List<Test> getActiveTests();

    public List<Test> getActiveTestsOfCategory(Category category);
}
