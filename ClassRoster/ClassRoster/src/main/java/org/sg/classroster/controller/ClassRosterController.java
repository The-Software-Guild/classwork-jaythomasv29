package org.sg.classroster.controller;

import org.sg.classroster.dao.ClassRosterDao;
import org.sg.classroster.dao.ClassRosterPersistenceException;
import org.sg.classroster.dto.Student;
import org.sg.classroster.service.ClassRosterDataValidationException;
import org.sg.classroster.service.ClassRosterDuplicateIdException;
import org.sg.classroster.service.ClassRosterServiceLayer;
import org.sg.classroster.ui.ClassRosterView;

import java.util.List;

public class ClassRosterController {
  private ClassRosterView view;
  private ClassRosterServiceLayer service;


  public ClassRosterController(ClassRosterView view, ClassRosterServiceLayer service) {
    this.service = service;
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
    } catch (ClassRosterPersistenceException e) {
      view.displayErrorMessage(e.getMessage());
    }
  }

  private int getMenuSelection() {
    return view.printMenuAndGetSelection();
  }

  private void createStudent() throws ClassRosterPersistenceException {
    view.displayCreateStudentBanner();
    boolean hasErrors = false;
    do {
      Student currentStudent = view.getNewStudentInfo();
      try {
        service.createStudent(currentStudent);
        view.displayCreateSuccessBanner();
        hasErrors = false;
      } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
        hasErrors = true;
        view.displayErrorMessage(e.getMessage());
      }
    } while (hasErrors);
  }

  private void listStudents() throws ClassRosterPersistenceException {
    view.displayDisplayAllBanner();
    List<Student> studentList = service.getAllStudents();
    view.displayStudentList(studentList);
  }

  private void viewStudent() throws ClassRosterPersistenceException {
    view.displayDisplayStudentBanner();
    String studentId = view.getStudentIdChoice();
    Student student = service.getStudent(studentId);
    view.displayStudent(student);
  }

  private void removeStudent() throws ClassRosterPersistenceException {
    view.displayRemoveStudentBanner();
    String studentId = view.getStudentIdChoice();
    service.removeStudent(studentId);
    view.displayRemoveSuccessBanner();
  }

  private void unknownCommand() {
    view.displayUnknownCommandBanner();
  }

  private void exitMessage() {
    view.displayExitBanner();
  }
}
