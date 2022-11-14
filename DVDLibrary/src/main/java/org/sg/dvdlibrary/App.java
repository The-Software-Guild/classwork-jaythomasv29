package org.sg.dvdlibrary;

import org.sg.dvdlibrary.controller.DVDLibraryController;
import org.sg.dvdlibrary.dao.DVDLibraryDao;
import org.sg.dvdlibrary.dao.DVDLibraryDaoImpl;
import org.sg.dvdlibrary.ui.DVDLibraryView;
import org.sg.dvdlibrary.ui.UserIO;
import org.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
     UserIO userIo = new UserIOConsoleImpl();
     DVDLibraryView DVDLibraryView = new DVDLibraryView(userIo);
     DVDLibraryDao DVDLibraryDao = new DVDLibraryDaoImpl();
     DVDLibraryController DVDLibraryController = new DVDLibraryController(DVDLibraryView, DVDLibraryDao);
     DVDLibraryController.run();

    }


}
