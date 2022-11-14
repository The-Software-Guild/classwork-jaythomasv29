package org.sg.classroster.dto;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    // Programming Language + cohort month/year
    private String cohort;

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

    public String getCohort() {
      return cohort;
    }

    public void setCohort(String cohort) {
      this.cohort = cohort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return firstName.equals(student.firstName) && lastName.equals(student.lastName) && studentId.equals(student.studentId) && cohort.equals(student.cohort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, studentId, cohort);
    }
}
