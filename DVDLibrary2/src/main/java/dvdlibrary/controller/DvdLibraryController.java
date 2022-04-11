/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dvdlibrary.controller;

import dvdlibrary.dao.DvdLibraryFileImpl;
import dvdlibrary.dto.DVD;
import dvdlibrary.ui.DvdLibraryView;
import dvdlibrary.ui.UserIO;
import dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author andri
 */
public class DvdLibraryController {

    private final DvdLibraryFileImpl dao = new DvdLibraryFileImpl();
    private final DvdLibraryView view = new DvdLibraryView();
    private final UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();
            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    io.print("ADD A LIST OF DVDs TO THE COLLECTION");
                    break;
                case 3:
                    io.print("REMOVE ONE DVD FROM THE COLLECTION");
                    break;
                case 4:
                    io.print("REMOVE A LIST OF DVDs FROM THE COLLECTION");
                    break;
                case 5:
                    io.print("UPDATE/EDIT ONE DVDs INFO IN THE COLLECTION");
                    break;
                case 6:
                    io.print("UPDATE/EDIT A LIST OF DVDs INFO IN THE COLLECTION");
                    break;
                case 7:
                    listDVDs();
                    break;
                case 8:
                    io.print("DISPLAY ONE DVD INFO");
                    break;
                case 9:
                    io.print("SEARCH FOR ONE DVD BY TITLE");
                    break;
                case 10:
                    io.print("LOAD DVD LIBRARY FROM THE FILE");
                    break;
                case 11:
                    io.print("SAVE DVD LIBRARY BACK TO THE FILE WHEN PROGRAM COMPLETES");
                    break;
                case 12:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }

    private void createDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }
    
     private void listDVDs() {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
}