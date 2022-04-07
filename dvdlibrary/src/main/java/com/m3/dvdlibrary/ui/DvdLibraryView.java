package com.m3.dvdlibrary.ui;

import com.m3.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ishraq Khan && Ronald Gedeon && Brandon Turner; 
 * gitRepo: https://github.com/ishraqKhan21/DVDLibrary.git 
 * Class View that delegates responsibility to the user interface class, on April 6, 2022
 */
public class DvdLibraryView {

    // Private field to be injected as a dependency
    private final UserIO io;

    // Constructor dependency
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    /**
     * This method shows the Menu and return the user choice as an int
     *
     * @return int
     */
    public int printMenuAndGetSelection() {
        io.print("\nMain Menu");
        io.print("1. Add One DVD to the Collection");
        io.print("2. Add a List of DVDs to Collection");
        io.print("3. Remove One DVD from the Collection");
        io.print("4. Remove a List of DVDs to Collection");
        io.print("5. Update/Edit One DVD info in the Collection");
        io.print("6. Update/Edit a List of DVDs to Collection");
        io.print("7. List all the DVDs in the Collection");
        io.print("8. Display one DVD Info");
        io.print("9. Search for a DVD by Title");
        io.print("10. Load DVD Library from the File");
        io.print("11. Save DVD Library back to the File when program completes");
        io.print("12. Exit\n");

        return io.readInt("Please select from the"
                + " above choices.", 1, 12);
    }

    /**
     * This method get the DVDs fields from the user to construct DVD object
     *
     * @return DVD
     */
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter DVD releaseDate");
        String mpaaRating = io.readString("Please enter DVD mpaaRating");
        String directorName = io.readString("Please enter DVD directorName");
        String studio = io.readString("Please enter DVD studio");
        String review = io.readString("Please enter DVD review");

        DVD dvd = new DVD(title);
        dvd.setReleaseDate(releaseDate);
        dvd.setMpaaRating(mpaaRating);
        dvd.setDirectorName(directorName);
        dvd.setStudio(studio);
        dvd.setReview(review);

        return dvd;
    }

    /**
     * This method get a collection of DVDs fields from the user to construct a
     * list of DVD objects
     *
     * @return List<DVD>
     */
    public List<DVD> getCollectionDVDInfo() {
        List<DVD> dvds = new ArrayList<>();
        for (int i = getUserNbrOfDVDsToAdd(); i > 0; i--) { // side effects
            io.print("\nPlease enter Info for DVD #" + i);
            io.print("______________________________");
            DVD singleDVD = getNewDVDInfo();
            dvds.add(singleDVD);
        }
        return dvds;
    }

    /**
     * This method going gets the number of DVDs that the user want to add or
     * update
     *
     * @return int
     */
    public int getUserNbrOfDVDsToAdd() {
        return io.readInt("Please enter the number of DVDs you wish to add or update", 1, 10);
    }

    /**
     * This method going gets the number of DVDs that the user want to remove
     *
     * @return
     */
    public int getUserNbrOfDvdsToRemove() {
        return io.readInt("Please enter the number of DVDs you wish to remove", 1, 10);
    }

    /**
     * This method get a collection of DVDs titles to be removed
     *
     * @return
     */
    public List<String> getCollectionDVDsTitleToRemove() {
        List<String> dvdsTitles = new ArrayList<>();
        for (int i = getUserNbrOfDvdsToRemove(); i > 0; i--) { // side effects
            io.print("\nPlease enter Title #" + i);
            io.print("______________________________");
            String title = getDVDTitle();
            dvdsTitles.add(title);
        }
        return dvdsTitles;
    }

    /**
     * This method just displays all the info of a DVD
     *
     * @param dvd
     */
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMpaaRating());
            io.print("Director's Name: " + dvd.getDirectorName());
            io.print("Studio: " + dvd.getStudio());
            io.print("Review: " + dvd.getReview());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    /**
     * This method just displays a list of DVDs
     *
     * @param dvdList
     */
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDvd : dvdList) {
            String studentInfo = String.format("%s : %s : %s : %s : %s : %s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getReview());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    /**
     * This method just return a DVD title
     *
     * @return
     */
    public String getDVDTitle() {
        return io.readString("Please enter the DVD title.");
    }

    /**
     * This method is a helper for removing a DVD in collection
     *
     * @param dvdRecord
     */
    public void displayRemoveResult(DVD dvdRecord) {
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("There's no DVD by this title");
        }
        io.readString("Please hit enter to continue.");
    }

    /**
     * This method is a helper for searching a DVD in collection
     *
     * @param dvd
     */
    public void displaySearchDVD(DVD dvd) {
        if (dvd != null) {
            io.print("Yes, DVD is in the library.");
        } else {
            io.print("No, DVD is not in the library.");
        }
        io.readString("Please hit enter to continue.");
    }

    /* A bunch of Banner methods that are for good presentation only */
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateDVDSuccessBanner() { // Banner of success
        io.readString(
                "DVD successfully created && Please hit enter to continue.");
    }

    public void displayCreateCollectionDVDsBanner() {
        io.print("=== Create Collection of DVDs ===");
    }

    public void displayCreateCollectionDVDsSuccessBanner() { // Banner
        io.readString(
                "Collection of DVDs successfully created && Please hit enter to continue.");
    }

    public void displayUpdateCollectionDVDsBanner() {
        io.print("=== Update Collection of DVDs ===");
    }

    public void displayUpdateCollectionDVDsSuccessBanner() { // Banner
        io.readString(
                "Collection of DVDs successfully updated && Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displaySearchDVDBanner() {
        io.print("=== Search if DVD in Library ===");
    }

    public void displayUpdateBanner() {
        io.print("=== Update one DVD identified by its title ===");
    }

    public void displayUpdateSuccessBanner() { // Banner
        io.readString(
                "DVD successfully updated && Please hit enter to continue.");
    }

    public void displayRemoveCollectionDVDsBanner() {
        io.print("=== Remove Collection of DVDs");
    }

    public void displayRemoveCollectionDVDsSuccessBanner() { // Banner
        io.readString("DVD's successfully removed && Please hit enter to continue.");
    }

    public void displayLoadingDVDBanner() {
        io.print("=== Loading DVDs ===");
    }

    public void displayLoadingDVDSuccessBanner() { // Banner
        io.readString(
                "DVD successfully loaded && Please hit enter to continue.");
    }

    public void displaySavingDVDBanner() {
        io.print("=== Loading DVDs ===");
    }

    public void displaySavingDVDSuccessBanner() { // Banner
        io.readString(
                "DVD successfully loaded && Please hit enter to continue.");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
}
