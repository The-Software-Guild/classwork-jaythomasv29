package org.sg.dvdlibrary.dao;

import org.sg.dvdlibrary.dto.DVD;

import java.util.List;

public interface DVDLibraryDao {
     DVD saveDvd(String title, DVD dvd) throws DVDLibraryDaoException;

     DVD removeDvdByTitle(String title) throws DVDLibraryDaoException;
     DVD getDvd(String title) throws DVDLibraryDaoException;
     DVD overwriteDvd(DVD foundDvd, DVD newDvd) throws  DVDLibraryDaoException;
     List<DVD> getDvdCollection() throws DVDLibraryDaoException;
     List<DVD> getSearchResults(String titleQuery) throws DVDLibraryDaoException;
}