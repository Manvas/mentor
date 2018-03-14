package com.manvydas.mentor.Entity;

public class User {

    private int userId;
    private String name;
    private String jobDescription;

    public User(int userId, String name, String jobDescription) {
        this.userId = userId;
        this.name = name;
        this.jobDescription = jobDescription;
    }

    public User(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
