/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m3.dvdlibrary.ui;

import com.m3.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author andri
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

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created && Please hit enter to continue.");
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

    public void displayUpdateBanner() {
        io.print("=== Update DVD ===");
    }

    public void displayUpdateSuccessBanner() {
        io.readString(
                "DVD successfully updated && Please hit enter to continue.");
    }

}
