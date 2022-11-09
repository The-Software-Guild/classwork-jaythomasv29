package org.sg.classroster.controller;

import org.sg.classroster.dao.ClassRosterDao;
import org.sg.classroster.dao.ClassRosterDaoException;
import org.sg.classroster.dao.ClassRosterDaoFileImpl;
import org.sg.classroster.dto.Student;
import org.sg.classroster.ui.ClassRosterView;
import org.sg.classroster.ui.UserIO;
import org.sg.classroster.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {
  private ClassRosterView view;
  private ClassRosterDao dao;

  public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
    this.dao = dao;
    this.view = view;
  }

  public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
    try {


      while (keepGoing) {
        menuSelection = getMenuSelection();

        switch (menuSelection) {
          case 1:
            listStudents();
            break;
          case 2:
            createStudent();
            break;
          case 3:
            viewStudent();
            break;
          case 4:
            removeStudent();
            break;
          case 5:
            keepGoing = false;
            break;
          default:
            unknownCommand();
        }
      }
      exitMessage();
    } catch (ClassRosterDaoException e) {
      view.displayErrorMessage(e.getMessage());
    }
  }

  private int getMenuSelection() {
    return view.printMenuAndGetSelection();
  }
  private void createStudent() throws ClassRosterDaoException {
    view.displayCreateStudentBanner();
    Student newStudent = view.getNewStudentInfo();
    dao.addStudent(newStudent.getStudentId(), newStudent);
    view.displayCreateSuccessBanner();
  }

  private void listStudents() throws ClassRosterDaoException {
    view.displayDisplayAllBanner();
    List<Student> studentList = dao.getAllStudents();
    view.displayStudentList(studentList);
  }

  private void viewStudent() throws ClassRosterDaoException {
    view.displayDisplayStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student student = dao.getStudent(studentId);
    view.displayStudent(student);
  }

  private void removeStudent() throws ClassRosterDaoException {
    view.displayRemoveStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student removedStudent = dao.removeStudent(studentId);
    view.displayRemoveResult(removedStudent);
  }

  private void unknownCommand() {
    view.displayUnknownCommandBanner();
  }

  private void exitMessage() {
    view.displayExitBanner();
  }
}
