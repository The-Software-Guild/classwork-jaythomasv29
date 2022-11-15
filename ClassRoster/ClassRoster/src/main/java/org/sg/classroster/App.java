package org.sg.classroster;

import org.sg.classroster.controller.ClassRosterController;
import org.sg.classroster.dao.ClassRosterAuditDao;
import org.sg.classroster.dao.ClassRosterAuditDaoFileImpl;
import org.sg.classroster.dao.ClassRosterDao;
import org.sg.classroster.dao.ClassRosterDaoFileImpl;
import org.sg.classroster.service.ClassRosterServiceLayer;
import org.sg.classroster.service.ClassRosterServiceLayerImpl;
import org.sg.classroster.ui.ClassRosterView;
import org.sg.classroster.ui.UserIO;
import org.sg.classroster.ui.UserIOConsoleImpl;

public class App {
  public static void main(String[] args) {
    UserIO myIo = new UserIOConsoleImpl();
    ClassRosterView myView = new ClassRosterView(myIo);
    ClassRosterDao myDao = new ClassRosterDaoFileImpl();
    ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
    ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
    ClassRosterController controller = new ClassRosterController(myView, myService);
    controller.run();

  }
}