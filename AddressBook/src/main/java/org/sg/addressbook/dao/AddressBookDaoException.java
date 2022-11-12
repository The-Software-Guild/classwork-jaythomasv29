package org.sg.addressbook.dao;

public class AddressBookDaoException  extends Exception {
    public AddressBookDaoException(String message) {
        super(message);
    }

    public AddressBookDaoException(String message, Throwable cause) { super(message, cause); }
}
