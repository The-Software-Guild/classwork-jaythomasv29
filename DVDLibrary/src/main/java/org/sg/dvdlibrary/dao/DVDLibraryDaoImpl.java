package org.sg.dvdlibrary.dao;

import org.sg.dvdlibrary.dto.DVD;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DVDLibraryDaoImpl implements DVDLibraryDao {
    public static final String DVD_COLLECTION_FILE = "dvd-collection.txt";
    public static final String DELIMITER = "::";

    HashMap<String, DVD> dvdCollection = new HashMap<>();
    @Override
    public DVD saveDvd(String title, DVD dvd) throws DVDLibraryDaoException {
        loadDvdCollection();
        DVD addedDVD = dvdCollection.put(title, dvd);
        writeToDvdCollection();
        return addedDVD;
    }

    @Override
    public DVD removeDvdByTitle(String title) throws DVDLibraryDaoException {
        loadDvdCollection();
        DVD deletedDVD = dvdCollection.remove(title);
        writeToDvdCollection();
        return deletedDVD;
    }
    @Override
    public DVD overwriteDvd(DVD foundDvd, DVD newDvd) throws DVDLibraryDaoException {
        loadDvdCollection();
        // if the title (key) is changed
        if(!foundDvd.getTitle().equals(newDvd.getTitle())) {
            // delete the current dvd in collection and save newDvd
            dvdCollection.remove(foundDvd.getTitle());
            writeToDvdCollection();
            return dvdCollection.put(newDvd.getTitle(), newDvd);
        } else {
            // set the other fields of the dvd to foundDvd and return
            foundDvd.setReleaseDate(newDvd.getReleaseDate());
            foundDvd.setMpaaRating(newDvd.getMpaaRating());
            foundDvd.setDirectorName(newDvd.getDirectorName());
            foundDvd.setStudio(newDvd.getStudio());
            foundDvd.setUserComment(newDvd.getUserComment());
            writeToDvdCollection();
            return foundDvd;
        }
    }

    @Override
    public DVD getDvd(String title) throws DVDLibraryDaoException {
        loadDvdCollection();
        return dvdCollection.get(title); }

    @Override
    public List<DVD> getDvdCollection() throws DVDLibraryDaoException {
        loadDvdCollection();
        return new ArrayList<>(dvdCollection.values());
    }

    @Override
    public List<DVD> getSearchResults(String titleQuery) throws DVDLibraryDaoException {
        List<DVD> dvdWithMatchedQuery = new ArrayList<>();
        List<String> titles = new ArrayList<>(dvdCollection.keySet());
        for(String t : titles) {
            if(t.startsWith(titleQuery)) {
                dvdWithMatchedQuery.add(dvdCollection.get(t));
            }
        }
    return dvdWithMatchedQuery;
    }



    private DVD unmarshallAddress(String dvdAsTxt) {
        // title::releaseDate::mpaaRating::directorName::studio::userComment
        String[] addressTokens = dvdAsTxt.split(DELIMITER);
        String title = addressTokens[0];
        String releaseDate = addressTokens[1];
        String mpaaRating = addressTokens[2];
        String directorName = addressTokens[3];
        String studio = addressTokens[4];
        String userComment = addressTokens[5];
        DVD DVDFromFile = new DVD(title, releaseDate, mpaaRating, directorName, studio, userComment);
        return DVDFromFile;
    }

    private void loadDvdCollection() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_COLLECTION_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("Could not load addresses from memory.", e);
        }
        String currentLine;
        DVD currentDVD;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallAddress(currentLine);
            dvdCollection.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDvd(DVD dvd) {
        StringBuilder dvdAsText = new StringBuilder(dvd.getTitle() + DELIMITER);
        dvdAsText.append(dvd.getReleaseDate() + DELIMITER);
        dvdAsText.append(dvd.getMpaaRating() + DELIMITER);
        dvdAsText.append(dvd.getDirectorName() + DELIMITER);
        dvdAsText.append(dvd.getStudio() + DELIMITER);
        dvdAsText.append(dvd.getUserComment());
        return dvdAsText.toString();
    }

    private void writeToDvdCollection() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_COLLECTION_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save dvd data.", e);
        }
        String dvdAsText;
        List<DVD> DVDList = this.getDvdCollection();
        for(DVD currentDVD : DVDList) {
            dvdAsText = marshallDvd(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
    out.close();
    }

}
