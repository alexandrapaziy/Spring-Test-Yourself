package com.examserver.repository;

import com.examserver.model.exam.Category;
import com.examserver.model.exam.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    public List<Test> findByCategory(Category category);

    public List<Test> findByActive(Boolean b);

    public List<Test> findByCategoryAndActive(Category category, Boolean b);
}
