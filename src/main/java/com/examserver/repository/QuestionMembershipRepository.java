package com.examserver.repository;

import com.examserver.model.exam.Question;
import com.examserver.model.exam.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionMembershipRepository extends JpaRepository<Question, Long> {

    @Query("SELECT COUNT(i) FROM Question i WHERE i.test = :testId")
    int countQuestionMembership(@Param("testId") Test testId);
}
