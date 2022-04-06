package com.m3.dvdlibrary.dao;

import com.m3.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * @author Ishraq Khan && Ronald Gedeon && Brandon Turner; 
 * gitRepo: https://github.com/ishraqKhan21/DVDLibrary.git 
 * A class that implements the behavior of DAO interface for a File storage, on April 6, 2022
 */
public class DvdLibraryFileImpl implements DvdLibraryDao {

    public static final String DVDs_FILE = "dvdlibrary.txt";// a constant to hold the file
    public static final String DELIMITER = "::"; // a constant to hold the delimiter

// for virtual storage
    private Map<String, DVD> DVDs = new HashMap<>();

    /* Methods that specific to DvdLibrary*/
    // unMarshallDVD method as per pattern <title>::<release date>::<mpaa rating>::<director name>::<studio>::<review>
    private DVD unMarshallDVD(String DVDAsText) {
        String[] DVDTokens = DVDAsText.split(DELIMITER);

        String title = DVDTokens[0];
        DVD DVDFromFile = new DVD(title);

        DVDFromFile.setReleaseDate(DVDTokens[1]); // release date
        DVDFromFile.setMpaaRating(DVDTokens[2]); // mpaaRating
        DVDFromFile.setDirectorName(DVDTokens[3]); //director name
        DVDFromFile.setStudio(DVDTokens[4]); // studio
        DVDFromFile.setReview(DVDTokens[5]); // review

        return DVDFromFile; // return the newly created DVD from File
    }

    // Convert DVD info from virtual memory object into a line of text to be written later into a File
    // as per pattern <title>::<release date>::<mpaa rating>::<director name>::<studio>::<review>
    private String marshallDVD(DVD dvd) {
        String dvdAsText = dvd.getTitle() + DELIMITER; // title::
        dvdAsText += dvd.getReleaseDate() + DELIMITER; // title::relase date::
        dvdAsText += dvd.getMpaaRating() + DELIMITER; // title::relase date::mpaa rating::
        dvdAsText += dvd.getDirectorName() + DELIMITER; // title::relase date::mpaa rating::director name::
        dvdAsText += dvd.getStudio() + DELIMITER; // title::relase date::mpaa rating::studio::
        dvdAsText += dvd.getReview() + DELIMITER; // title::relase date::mpaa rating::review

        return dvdAsText; // return the fiinal built String/Text
    }

    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD previousDVD = DVDs.put(title, dvd); // previous Value of the key 
        return previousDVD;
    }

    @Override
    public void addDVDs(List<DVD> dvds) {
        for (DVD dvd : dvds) {
            addDVD(dvd.getTitle(), dvd);
        }
    }

    @Override
    public DVD removeDVD(String title) {
        DVD removedDVD = DVDs.remove(title);
        return removedDVD;
    }

    @Override
    public List<DVD> removeDVDs(String[] titles, DVD dvds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DVD updateDVD(String title, DVD dvd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateDVDs(List<DVD> dvds) {
        addDVDs(dvds);
    }

    @Override
    public DVD getDVD(String title) {
        return DVDs.get(title);
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<>(DVDs.values());
    }

    @Override
    public void displayDVDinfo(DVD dvd, String info) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

// Load DVD: Read the File and unmarshall it line by line to the virtual memory
    @Override
    public void loadDVDs() throws Exception {
        Scanner scanner;
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(DVDs_FILE)));

        String currentLine; // currentLine holds the most recent line read from the file
        DVD currentDVD;  // currentDVD holds the most recent DVD unmarshalled

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unMarshallDVD(currentLine);

            DVDs.put(currentDVD.getTitle(), currentDVD);
        }
        // releaseing ressources
        scanner.close();
    }

    // Save DVDs: iterate through the HashMap and marshall each object && write it to the File.
    @Override
    public void saveDVDs() throws Exception {
        PrintWriter out;
        out = new PrintWriter(new FileWriter(DVDs_FILE));

        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();

        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);  // turn a DVD into a String
            out.println(dvdAsText);  // write the DVD object to the file
            out.flush(); // force PrintWriter to write the line to the file as we don't know its buffer capacity
        }
        out.close(); // Releasing ressources / Clean up
    }
}
