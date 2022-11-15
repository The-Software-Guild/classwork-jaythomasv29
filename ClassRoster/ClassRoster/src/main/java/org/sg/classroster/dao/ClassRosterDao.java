package org.sg.classroster.dao;

import org.sg.classroster.dto.Student;

import java.util.List;

public interface ClassRosterDao {
    /**
     * Adds the given Student to the roster and associates it with the given
     * student id. If there is already a student associated with the given
     * student id it will return that student object, otherwise it will
     * return null.
     *
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given
     * student id if it exists, null otherwise
     * @throws ClassRosterPersistenceException
     */
    Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException;

    /**
     * Returns a List of all Students on the roster.
     *
     * @return Student List containing all students on the roster.
     * @throws ClassRosterPersistenceException
     */
    List<Student> getAllStudents()
            throws ClassRosterPersistenceException;

    /**
     * Returns the student object associated with the given student id.
     * Returns null if no such student exists
     *
     * @param studentId ID of the student to retrieve
     * @return the Student object associated with the given student id,
     * null if no such student exists
     * @throws ClassRosterPersistenceException
     */
    Student getStudent(String studentId)
            throws ClassRosterPersistenceException;

    /**
     * Removes from the roster the student associated with the given id.
     * Returns the student object that is being removed or null if
     * there is no student associated with the given id
     *
     * @param studentId id of student to be removed
     * @return Student object that was removed or null if no student
     * was associated with the given student id
     * @throws ClassRosterPersistenceException
     */
    Student removeStudent(String studentId)
            throws ClassRosterPersistenceException;

}
