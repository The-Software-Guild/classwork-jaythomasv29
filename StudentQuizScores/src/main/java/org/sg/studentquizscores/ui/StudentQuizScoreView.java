package org.sg.studentquizscores.ui;

import org.sg.studentquizscores.dto.Student;

import java.util.List;

public class StudentQuizScoreView {
    private UserIO io;

    public StudentQuizScoreView(UserIO io) { this.io = io; }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. View List of Students");
        io.print("2. Create & Add New Student");
        io.print("3. Remove a Student");
        io.print("4. Add a Quiz Score to Student");
        io.print("5. View List of Scores of a Student");
        io.print("6. View Average Scores of a Student");
        io.print("7. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 8);
    }

    public void displayAllStudentsBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s ",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }
    public void displayAddScoreToStudentBanner() {
        io.print("=== Add Score to Student ===");
    }
    public void displayRemoveSuccessBanner(Student student) {
        if(student != null) {
            io.print("Student successfully removed.");

        } else {
            io.print("Cannot remove. No such student in records.");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayStudentAverageBanner() {
        io.print("=== Student Average Score ===");

    }
    public void displayStudentBanner () {
        io.print("=== Display Student ===");
    }
    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }
    public void displayUnknownCommandBanner() { io.print("Unknown Command..."); }

    public String getStudentIdChoice() {
        String studentId = io.readString("Please enter Student ID to proceed");
        return studentId;
    }

    public int getStudentQuizScore() {
        int quizScore = io.readInt("Please enter a quiz score to add ");
        return quizScore;
    }
    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");

        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        return currentStudent;
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print("ID: " + student.getStudentId());
            io.print("First name: " + student.getFirstName());
            io.print("Last name: " + student.getLastName());
            io.print("Score(s): " + student.getScores().toString());
        } else {
            io.print("No such student in records.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayStudentScores(Student student) {
        if (student != null) {
            io.print(student.getFirstName() + " " + student.getLastName() + "'s Score(s): " + student.getScores().toString());
        } else {
            io.print("No such student in records.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayStudentAverage(Student student) {
        if (student != null) {
            io.print(student.getFirstName() + " " + student.getLastName() + "'s Avg Score: " + student.getAverageScore());
        } else {
            io.print("No such student in records.");
        }
        io.readString("Please hit enter to continue.");

    }

    public void displayExitBanner() {
        io.print("Goodbye!");
    }

    public void displayStudentNotFoundBanner() {
        io.print("Student not found in record");
        io.readString("Please hit enter to continue.");
    }

}
