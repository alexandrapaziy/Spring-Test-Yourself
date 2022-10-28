package com.examserver.service;

import com.examserver.model.exam.Test;

public interface QuestionMembershipService {

    public Long count();

    public int countQuestionMembership(Test testId);
}
