package com.examserver.repository;

import com.examserver.model.exam.OpenQuestion;
import com.examserver.model.exam.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OpenQuestionRepository extends JpaRepository<OpenQuestion, Long> {
    Set<OpenQuestion> findByTest(Test test);
}
