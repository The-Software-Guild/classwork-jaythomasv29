package org.sg.studentquizscores;

import org.sg.studentquizscores.controller.StudentQuizScoreController;
import org.sg.studentquizscores.dao.StudentQuizScoreDao;
import org.sg.studentquizscores.dao.StudentQuizScoreDaoImpl;
import org.sg.studentquizscores.ui.StudentQuizScoreView;
import org.sg.studentquizscores.ui.UserIO;
import org.sg.studentquizscores.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO userIo = new UserIOConsoleImpl();
        StudentQuizScoreView studentQuizScoreView = new StudentQuizScoreView(userIo);
        StudentQuizScoreDao studentQuizScoreDao = new StudentQuizScoreDaoImpl();
        StudentQuizScoreController studentQuizScoreController = new StudentQuizScoreController(studentQuizScoreView, studentQuizScoreDao);
        studentQuizScoreController.run();
    }
}
