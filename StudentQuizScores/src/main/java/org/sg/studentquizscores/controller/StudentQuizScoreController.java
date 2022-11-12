package org.sg.studentquizscores.controller;

import org.sg.studentquizscores.dao.StudentQuizScoreDao;
import org.sg.studentquizscores.dto.Score;
import org.sg.studentquizscores.dto.Student;
import org.sg.studentquizscores.ui.StudentQuizScoreView;

import java.util.List;

public class StudentQuizScoreController {
    private StudentQuizScoreView studentQuizScoreView;
    private StudentQuizScoreDao studentQuizScoreDao;
    public StudentQuizScoreController(StudentQuizScoreView studentQuizScoreView, StudentQuizScoreDao studentQuizScoreDao) {
        this.studentQuizScoreView = studentQuizScoreView;
        this.studentQuizScoreDao = studentQuizScoreDao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while(keepGoing) {
            menuSelection = getMenuSelection();
            switch(menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    addScoreToStudent();
                    break;
                case 5:
                    viewStudentScore();
                    break;
                case 6:
                    viewAverageScoreOfStudent();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    System.out.println("Unknown command please try again");
            }
        }
        exitMessage();
    }


    private int getMenuSelection() {
        return studentQuizScoreView.printMenuAndGetSelection();
    }

    private void listStudents() {
        studentQuizScoreView.displayAllStudentsBanner();
        List<Student> studentList = studentQuizScoreDao.getAllStudents();
        studentQuizScoreView.displayStudentList(studentList);
    }

    public void createStudent() {
        studentQuizScoreView.displayCreateStudentBanner();
        Student student = studentQuizScoreView.getNewStudentInfo();
        studentQuizScoreDao.saveStudent(student.getStudentId(), student);
        studentQuizScoreView.displayCreateSuccessBanner();
    }

    public void viewStudentScore() {
        studentQuizScoreView.displayStudentBanner();
        String studentId = studentQuizScoreView.getStudentIdChoice();
        Student foundStudent = studentQuizScoreDao.getStudent(studentId);
        studentQuizScoreView.displayStudentScores(foundStudent);
    }

    public void viewAverageScoreOfStudent() {
        studentQuizScoreView.displayStudentAverageBanner();
        String studentId = studentQuizScoreView.getStudentIdChoice();
        Student foundStudent = studentQuizScoreDao.getStudent(studentId);
        studentQuizScoreView.displayStudentAverage(foundStudent);

    }

    public void removeStudent() {
        studentQuizScoreView.displayRemoveStudentBanner();
        String studentId = studentQuizScoreView.getStudentIdChoice();
        Student removedStudent = studentQuizScoreDao.removeStudent(studentId);
        studentQuizScoreView.displayRemoveSuccessBanner(removedStudent);
    }

    public void addScoreToStudent() {
        studentQuizScoreView.displayAddScoreToStudentBanner();
        String studentId = studentQuizScoreView.getStudentIdChoice();
        Student foundStudent = studentQuizScoreDao.getStudent(studentId);
        if(foundStudent != null) {
        Score score =  new Score(studentQuizScoreView.getStudentQuizScore());
        foundStudent.getScores().add(score);
        studentQuizScoreView.displayStudent(foundStudent);
        } else {
            studentQuizScoreView.displayStudentNotFoundBanner();
        }

    }
    private void unknownCommand() {
        studentQuizScoreView.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        studentQuizScoreView.displayExitBanner();
    }

}
