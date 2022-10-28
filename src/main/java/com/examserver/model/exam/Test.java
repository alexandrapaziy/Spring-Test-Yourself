package com.examserver.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long testId;

    private String title;

    @Column(length = 5000)
    private String description;

    @Column(length = 5000)
    private String abstraction;

    private String maxMark;
    private String numberOfCommonQuestions;
    private String numberOfOpenQuestions;
    private String numberOfComplianceQuestions;

    private boolean active = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CommonQuestion> commonQuestions = new HashSet<>();

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OpenQuestion> openQuestions = new HashSet<>();

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ComplianceQuestion> complianceQuestions = new HashSet<>();

    public Test() {
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbstraction() {
        return abstraction;
    }

    public void setAbstraction(String abstraction) {
        this.abstraction = abstraction;
    }

    public String getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(String maxMark) {
        this.maxMark = maxMark;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<CommonQuestion> getCommonQuestions() {
        return commonQuestions;
    }

    public void setCommonQuestions(Set<CommonQuestion> questions) {
        commonQuestions = questions;
    }

    public Set<OpenQuestion> getOpenQuestions() {
        return openQuestions;
    }

    public void setOpenQuestions(Set<OpenQuestion> questions) {
        openQuestions = questions;
    }

    public Set<ComplianceQuestion> getComplianceQuestions() {
        return complianceQuestions;
    }

    public void setComplianceQuestions(Set<ComplianceQuestion> complianceQuestions) {
        this.complianceQuestions = complianceQuestions;
    }

    public String getNumberOfOpenQuestions() {
        return numberOfOpenQuestions;
    }

    public void setNumberOfOpenQuestions(String numberOfOpenQuestions) {
        this.numberOfOpenQuestions = numberOfOpenQuestions;
    }

    public String getNumberOfCommonQuestions() {
        return numberOfCommonQuestions;
    }

    public void setNumberOfCommonQuestions(String numberOfCommonQuestions) {
        this.numberOfCommonQuestions = numberOfCommonQuestions;
    }

    public String getNumberOfComplianceQuestions() {
        return numberOfComplianceQuestions;
    }

    public void setNumberOfComplianceQuestions(String numberOfComplianceQuestions) {
        this.numberOfComplianceQuestions = numberOfComplianceQuestions;
    }
}
