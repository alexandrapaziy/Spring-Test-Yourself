package com.examserver.repository;

import com.examserver.model.exam.CommonQuestion;
import com.examserver.model.exam.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommonQuestionRepository extends JpaRepository<CommonQuestion, Long> {
    Set<CommonQuestion> findByTest(Test test);
}
