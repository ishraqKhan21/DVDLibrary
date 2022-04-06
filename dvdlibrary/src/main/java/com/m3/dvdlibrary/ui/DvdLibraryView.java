package com.m3.dvdlibrary.ui;

import com.m3.dvdlibrary.dto.DVD;

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
    
    public void displayCreateDVDBanner() {
    io.print("=== Create DVD ===");
}
    
  public void displayCreateSuccessBanner() {
    io.readString(
            "DVD successfully created && Please hit enter to continue.");
}
}
