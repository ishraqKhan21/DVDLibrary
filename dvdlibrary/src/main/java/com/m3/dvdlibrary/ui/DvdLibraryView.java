package com.m3.dvdlibrary.ui;

import com.m3.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronald Gedeon; email: gedemarcel0002@hotmail.com; gitRepo:
 * https://github.com/gedegithub/C223-JavaDev.git Design of a class ... on month
 * day, year
 */
public class DvdLibraryView {

    private UserIO io = new UserIOConsoleImpl();

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

    public List<DVD> getCollectionDVDInfo() {
        List<DVD> dvds = new ArrayList<>();
        for (int i = getUserNbrOfDVDs(); i > 0; i--) {
            DVD singleDVD = getNewDVDInfo();
            dvds.add(singleDVD);
        }
        return dvds;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateDVDSuccessBanner() {
        io.readString(
                "DVD successfully created && Please hit enter to continue.");
    }

    public void displayCreateCollectionDVDsBanner() {
        io.print("=== Create Collection of DVDs ===");
    }

    public void displayCreateCollectionDVDsSuccessBanner() {
        io.readString(
                "Collection of DVDs successfully created && Please hit enter to continue.");
    }

    public void displayUpdateCollectionDVDsBanner() {
        io.print("=== Update Collection of DVDs ===");
    }

    public void displayUpdateCollectionDVDsSuccessBanner() {
        io.readString(
                "Collection of DVDs successfully updated && Please hit enter to continue.");
    }

    public int getUserNbrOfDVDs() {
        return io.readInt("Please enter the number of DVDs you wish to add", 1, 5);
    }
    
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

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDVDTitle() {
        return io.readString("Please enter the DVD title.");
    }

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

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) {
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("There's no DVD by this title");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displaySearchDVDBanner() {
        io.print("=== Search if DVD in Library ===");
    }

    public void displaySearchDVD(DVD dvd) {
        if (dvd != null) {
            io.print("Yes, DVD is in the library.");
        } else {
            io.print("No, DVD is not in the library.");
        }
        io.readString("Please hit enter to continue.");
    }
}
