package com.sg.classroster.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sg.classroster.dao.ClassRosterAuditDaoFileImpl;
import org.sg.classroster.dao.ClassRosterDao;
import org.sg.classroster.dao.ClassRosterPersistenceException;
import org.sg.classroster.dao.ClassRosterDaoFileImpl;
import org.sg.classroster.dto.Student;

import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClassRosterDaoFileImplTest {
    ClassRosterDao testDao;

    public ClassRosterDaoFileImplTest() {}

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testroster.txt";
        // Use FileWriter to quickly blank the file
        new FileWriter(testFile);
        // Initialize a dao using the testFile provided
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @Test
    public void testAddStudent() throws ClassRosterPersistenceException {
        // Test inputs
        String studentId = "0001";
        Student firstStudent = new Student(studentId);
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May--1845");
        // Add the student to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        //Check the data is equal
        Student resultStudent = testDao.getStudent("0001");

        assertEquals(firstStudent.hashCode(), resultStudent.hashCode(), "Checking hashCode");
        assertEquals(firstStudent.getStudentId(), resultStudent.getStudentId(), "Checking student id.");
        assertEquals(firstStudent.getFirstName(), resultStudent.getFirstName(), "Checking student first name.");
        assertEquals(firstStudent.getLastName(), resultStudent.getLastName(), "Checking student last name");
        assertEquals(firstStudent.getCohort(), resultStudent.getCohort(), "Checking student cohort");
    }

    @Test
    public void testGetAllStudents() throws Exception {
        // Create our first student
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        // Create our second student
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");

        // Add both our students to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // Retrieve the list of all students within the DAO
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull(allStudents, "The list of students must not null");
        assertEquals(2, allStudents.size(),"List of students should have 2 students.");

        // Then the specifics
        assertTrue(testDao.getAllStudents().contains(firstStudent),
                "The list of students should include Ada.");
        assertTrue(testDao.getAllStudents().contains(secondStudent),
                "The list of students should include Charles.");

    }

    @Test
    public void testRemoveStudent() throws Exception {
        // Create two new students
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1945");

        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1945");

        // Add both to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // remove the first student - Ada
        Student removedStudent = testDao.removeStudent(firstStudent.getStudentId());

        // Check that the correct object was removed.
        assertEquals(removedStudent, firstStudent, "The removed student should be Ada.");

        // Get all the students
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull( allStudents, "All students list should be not null.");
        assertEquals( 1, allStudents.size(), "All students should only have 1 student.");

        // Then the specifics
        assertFalse( allStudents.contains(firstStudent), "All students should NOT include Ada.");
        assertTrue( allStudents.contains(secondStudent), "All students should NOT include Charles.");

        // Remove the second student
        removedStudent = testDao.removeStudent(secondStudent.getStudentId());
        // Check that the correct object was removed.
        assertEquals( removedStudent, secondStudent, "The removed student should be Charles.");

        // retrieve all of the students again, and check the list.
        allStudents = testDao.getAllStudents();

        // Check the contents of the list - it should be empty
        assertTrue( allStudents.isEmpty(), "The retrieved list of students should be empty.");

        // Try to 'get' both students by their old id - they should be null!
        Student retrievedStudent = testDao.getStudent(firstStudent.getStudentId());
        assertNull(retrievedStudent, "Ada was removed, should be null.");

        retrievedStudent = testDao.getStudent(secondStudent.getStudentId());
        assertNull(retrievedStudent, "Charles was removed, should be null.");

    }


}
