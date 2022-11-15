package org.sg.classroster.dao;

public interface ClassRosterAuditDao {
//    method that writes an entry to the log file
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
