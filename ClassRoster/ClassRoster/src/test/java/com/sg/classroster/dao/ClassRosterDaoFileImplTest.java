package com.sg.classroster.dao;

import org.junit.jupiter.api.Test;
import org.sg.classroster.dao.ClassRosterDao;
import org.sg.classroster.dao.ClassRosterDaoException;
import org.sg.classroster.dao.ClassRosterDaoFileImpl;
import org.sg.classroster.dto.Student;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassRosterDaoFileImplTest {
    ClassRosterDao classRosterDao = new ClassRosterDaoFileImpl();

    @Test
    public void testAddStudent() throws ClassRosterDaoException {
        Student firstStudent = new Student("01");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("c289");

        classRosterDao.addStudent(firstStudent.getStudentId(), firstStudent);
        Student resultStudent = classRosterDao.getStudent("01");
        assertTrue(firstStudent.getFirstName().equals(resultStudent.getFirstName()));
    }

    @Test
    public void testGetStudent() {

    }
}
