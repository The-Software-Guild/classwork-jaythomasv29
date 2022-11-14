package org.sg.dvdlibrary.ui;

import org.sg.dvdlibrary.dto.DVD;

import java.util.List;

public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO io) { this.io = io; }

    public int printMenuAndGetSelection() {
        io.print("Initial Menu:");
        io.print("\t Please select the operation you with to perform:");
        io.print("\t 1. Add DVD to collection");
        io.print("\t 2. Remove DVD from collection");
        io.print("\t 3. Edit a stored DVD's details");
        io.print("\t 4. List all DVD's in the collection");
        io.print("\t 5. Show/Display a DVD within the collection");
        io.print("\t 6. Search for a DVD by title");
        io.print("\t 7. Exit");
        return io.readInt("Please select from the above choices", 1, 7);
    }

    public void displayAddDVDBanner() {
        io.print("Add DVD Menu:");
    }
    public void displaySuccessfulAddBanner() {
        io.readString("DVD saved successfully! Hit enter to continue");
    }
    public void displayDeleteDVDBanner() {
        io.print("Delete DVD Menu:");
    }
    public void displayGetDVDBanner() {
        io.print("Display DVD Details:");
    }
    public void displayDVDCountBanner() {
        io.print("List DVD Count Menu:");
    }
    public void displayDVDCollectionBanner() {
        io.print("List DVD Collection Menu:");
    }
    public void displayDVDNotFoundBanner() {
        io.readString("Address not found. Hit enter to go back to main menu");
    }
    public void displayEditDVDBanner() { io.print("Edit DVD"); }

    public void displayUnknownCommandBanner() { io.print("Please enter a valid command"); }
    public void displayGoodbyeBanner() { io.print("Goodbye"); }
    public void displayErrorMessage(String message) { io.print(message); }
    public void displayDVDSearchBanner() { io.print("Search for a DVD by title"); }
    public void displayDVDSearchCollectionBanner(String searchQuery) {
        String banner = "Getting your search results for " + searchQuery + ": ";
        io.print(banner);
    }

    public void displayRemoveResult(DVD dvd) {
        if(dvd != null) {
            io.print("Address successfully deleted");
        } else {
            io.print("No such address associated with this last name.");
        }
        io.readString("Hit enter to continue");
    }

    public DVD getDVDDetails() {
        String title = io.readString("\t Please Enter a Title:");
        String releaseDate = io.readString("\t Please Enter a Release Date:");
        String mpaaRating = io.readString("\t Please Enter a MPAA Rating:");
        String directorName = io.readString("\t Please Enter a Director's Name:");
        String studio = io.readString("\t Please Enter a Studio:");
        String userComment = io.readString("\t Please Enter a User Rating or Note:");
        return new DVD(title, releaseDate, mpaaRating, directorName, studio, userComment);
    }



    public String getDvdTitle() {
        String dvdTitle = io.readString("Please Enter DVD Title:");
        return dvdTitle;
    }

    public void displayDvdDetails(DVD dvd) {
        if(dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserComment());
        } else {
            io.print("No such dvd associated with this title.");
        }
        io.readString("Hit enter to continue");
    }


    public void displayDvdCollection(List<DVD> dvdCollection) {
        if(dvdCollection.size() == 0) {
            io.readString("0 DVDs in collection, Hit enter to continue");
            return;
        }
        for(DVD dvd : dvdCollection) {
            System.out.println("******** MOVIE ********");
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserComment());
            System.out.println("********************");
        }
        io.readString("Hit enter to continue");
    }

}
