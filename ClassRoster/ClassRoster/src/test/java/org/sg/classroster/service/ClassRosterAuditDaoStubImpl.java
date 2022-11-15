package org.sg.classroster.service;

import org.sg.classroster.dao.ClassRosterAuditDao;
import org.sg.classroster.dao.ClassRosterPersistenceException;

public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        //do nothing . . .
    }
}
