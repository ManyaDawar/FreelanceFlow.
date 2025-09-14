package com.freelanceflow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "freelancer_count")
    private int freelancerCount;

    @Column(name = "budget")
    private double budget;

    @Column(name = "progress_percent")
    private int progressPercent;

    // Getters
    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getFreelancerCount() {
        return freelancerCount;
    }

    public double getBudget() {
        return budget;
    }

    public int getProgressPercent() {
        return progressPercent;
    }

    // Setters (optional, useful for JPA)
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setFreelancerCount(int freelancerCount) {
        this.freelancerCount = freelancerCount;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setProgressPercent(int progressPercent) {
        this.progressPercent = progressPercent;
    }
}

