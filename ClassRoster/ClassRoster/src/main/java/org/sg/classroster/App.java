package org.sg.classroster;

import org.sg.classroster.controller.ClassRosterController;
import org.sg.classroster.dao.ClassRosterDao;
import org.sg.classroster.dao.ClassRosterDaoFileImpl;
import org.sg.classroster.ui.ClassRosterView;
import org.sg.classroster.ui.UserIO;
import org.sg.classroster.ui.UserIOConsoleImpl;

public class App {
  public static void main(String[] args) {
    UserIO myIo = new UserIOConsoleImpl();
    ClassRosterView myView = new ClassRosterView(myIo);
    ClassRosterDao myDao = new ClassRosterDaoFileImpl();
    ClassRosterController controller = new ClassRosterController(myDao, myView);
    controller.run();

  }
}