package com.examserver.service.implement;

import com.examserver.model.exam.Test;
import com.examserver.repository.QuestionMembershipRepository;
import com.examserver.service.QuestionMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionMembershipServiceImplement implements QuestionMembershipService {

    @Autowired
    private QuestionMembershipRepository questionMembershipRepository;

    public Long count() {
        return questionMembershipRepository.count();
    }

    @Override
    public int countQuestionMembership(Test testId) {
        return questionMembershipRepository.countQuestionMembership(testId);
    }
}
