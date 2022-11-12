package org.sg.studentquizscores.dao;

import org.sg.studentquizscores.dto.Student;

import java.util.List;

public interface StudentQuizScoreDao {
    List<Student> getAllStudents();
    Student saveStudent(String studentId, Student student);
    Student getStudent(String studentId);
    Student removeStudent(String studentId);
}
