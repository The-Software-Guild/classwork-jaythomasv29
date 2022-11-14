package org.sg.dvdlibrary.controller;

import org.sg.dvdlibrary.dao.DVDLibraryDao;
import org.sg.dvdlibrary.dao.DVDLibraryDaoException;
import org.sg.dvdlibrary.dto.DVD;
import org.sg.dvdlibrary.ui.DVDLibraryView;

import java.util.List;

public class DVDLibraryController {
    private DVDLibraryView DVDLibraryView;
    private DVDLibraryDao DVDLibraryDao;

    public DVDLibraryController(DVDLibraryView DVDLibraryView, DVDLibraryDao DVDLibraryDao) {
        this.DVDLibraryView = DVDLibraryView;
        this.DVDLibraryDao = DVDLibraryDao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
try {

    while (keepGoing) {
        menuSelection = getMenuSelection();

        switch (menuSelection) {
            case 1:
                addDvdToLibrary();
                break;
            case 2:
                removeDvdFromCollection();
                break;
            case 3:
                editDvdInCollection();
                break;
            case 4:
                listDvdCollection();
                break;
            case 5:
                listDvdInfo();
                break;
            case 6:
//                Search DVD by Title
                listDvdSearchResults();
                break;
            case 7:
                keepGoing = false;
                break;
            default:
                unknownCommand();
        }
    }
    DVDLibraryView.displayGoodbyeBanner();
} catch (DVDLibraryDaoException e) {
    DVDLibraryView.displayErrorMessage(e.getMessage());
}
    }
private void unknownCommand() {
    DVDLibraryView.displayUnknownCommandBanner();
}

    private int getMenuSelection() {
        return DVDLibraryView.printMenuAndGetSelection();
    }

    private void addDvdToLibrary() throws DVDLibraryDaoException {
        DVDLibraryView.displayAddDVDBanner();
        DVD disk = DVDLibraryView.getDVDDetails();
        DVDLibraryDao.saveDvd(disk.getTitle(), disk);
        DVDLibraryView.displaySuccessfulAddBanner();
    }

    private void editDvdInCollection() throws DVDLibraryDaoException {
        DVDLibraryView.displayEditDVDBanner();
        String title = DVDLibraryView.getDvdTitle();
        DVD foundDVD = DVDLibraryDao.getDvd(title);
        DVD newDVDDetails = DVDLibraryView.getDVDDetails();
        DVDLibraryDao.overwriteDvd(foundDVD, newDVDDetails);
        DVDLibraryView.displayDvdDetails(newDVDDetails);
    }

    private void removeDvdFromCollection() throws DVDLibraryDaoException {
        DVDLibraryView.displayDeleteDVDBanner();
        String title = DVDLibraryView.getDvdTitle();
        DVD removedDVD = DVDLibraryDao.removeDvdByTitle(title);
        DVDLibraryView.displayRemoveResult(removedDVD);
    }

    private void listDvdInfo() throws DVDLibraryDaoException {
        DVDLibraryView.displayGetDVDBanner();
        String title = DVDLibraryView.getDvdTitle();
        DVD foundDVD = DVDLibraryDao.getDvd(title);
        DVDLibraryView.displayDvdDetails(foundDVD);
    }


    private void listDvdCollection() throws DVDLibraryDaoException {
        DVDLibraryView.displayDVDCollectionBanner();
        List<DVD> dvdCollection = DVDLibraryDao.getDvdCollection();
        DVDLibraryView.displayDvdCollection(dvdCollection);
    }

    private void listDvdSearchResults() throws DVDLibraryDaoException {
        DVDLibraryView.displayDVDSearchBanner();
        String titleQuery = DVDLibraryView.getDvdTitle();
        DVDLibraryView.displayDVDSearchCollectionBanner(titleQuery);
        List<DVD> potentialDvdSearchResults = DVDLibraryDao.getSearchResults(titleQuery);
        DVDLibraryView.displayDvdCollection(potentialDvdSearchResults);
    }


}
