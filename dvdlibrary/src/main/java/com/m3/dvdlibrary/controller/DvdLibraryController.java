package com.m3.dvdlibrary.controller;

import com.m3.dvdlibrary.dao.DvdLibraryFileImpl;
import com.m3.dvdlibrary.dto.DVD;
import com.m3.dvdlibrary.ui.DvdLibraryView;
import com.m3.dvdlibrary.ui.UserIO;
import com.m3.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 * @author Ronald Gedeon; email: gedemarcel0002@hotmail.com; gitRepo:
 * https://github.com/gedegithub/C223-JavaDev.git Design of a class ... on month
 * day, year
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
                    createDVDs();
                    break;
                case 3:
                    removeDVD();
                    break;
                case 4:
                    io.print("REMOVE A LIST OF DVDs FROM THE COLLECTION");
                    break;
                case 5:
                    io.print("UPDATE/EDIT ONE DVDs INFO IN THE COLLECTION");
                    break;
                case 6:
                    updateDVDs();
                    break;
                case 7:
                    listDVDs();
                    break;
                case 8:
                    viewDVD();
                    break;
                case 9:
                    searchDVD();
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
        view.displayCreateDVDSuccessBanner();
    }

    private void createDVDs() {
        view.displayCreateCollectionDVDsBanner();
        List<DVD> newDVDs = view.getCollectionDVDInfo();
        dao.addDVDs(newDVDs);
        view.displayCreateCollectionDVDsSuccessBanner();
    }

    private void updateDVDs() {
        view.displayUpdateCollectionDVDsBanner();
        List<DVD> newDVDs = view.getCollectionDVDInfo();
        dao.updateDVDs(newDVDs);
        view.displayUpdateCollectionDVDsSuccessBanner();
    }
        private void listDVDs() {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }
    
    private void removeDVD() {
    view.displayRemoveDVDBanner();
    String title = view.getDVDTitle();
    DVD removedDVD = dao.removeDVD(title);
    view.displayRemoveResult(removedDVD);
}
    
    private void searchDVD() {
        view.displaySearchDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displaySearchDVD(dvd);
    }
}
