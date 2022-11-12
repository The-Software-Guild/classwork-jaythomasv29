package org.sg.studentquizscores.dao;

import org.sg.studentquizscores.dto.Score;
import org.sg.studentquizscores.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentQuizScoreDaoImpl implements StudentQuizScoreDao {
    private Map<String, Student> students = new HashMap<>();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student saveStudent(String studentId, Student student) {
        Student savedStudent = students.put(studentId, student);
        return savedStudent;
    }

    public Student addGradeToStudent(String studentId, Score score) {
        return null;
    }

    @Override
    public Student getStudent(String studentId) {
      return students.get(studentId);
    }
    @Override
    public Student removeStudent(String studentId) {
        return students.remove(studentId);
    }
}
