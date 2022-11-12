package org.sg.studentquizscores.dto;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    // Student quiz scores
    private List<Score> scores = new ArrayList<>();

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Score> getScores() {
        return scores;
    }

    public double getAverageScore() {
        int total = 0;
        for(Score s: this.scores) {
            total += s.getScore();
        }
        return (double)total/this.scores.size();
    }

}
