package org.sg.dvdlibrary.dao;

public class DVDLibraryDaoException extends Exception {
    public DVDLibraryDaoException(String message) {
        super(message);
    }

    public DVDLibraryDaoException(String message, Throwable cause) { super(message, cause); }
}
