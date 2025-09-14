package com.freelanceflow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "worker_log")
public class WorkLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "hours_spent")
    private int hoursSpent;

    @Column(name = "earnings")
    private double earnings;

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getHoursSpent() {
        return hoursSpent;
    }

    public double getEarnings() {
        return earnings;
    }

    // --- Setters ---
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setHoursSpent(int hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }
}


