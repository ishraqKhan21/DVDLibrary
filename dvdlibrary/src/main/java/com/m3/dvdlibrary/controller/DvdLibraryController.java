package com.m3.dvdlibrary.controller;

import com.m3.dvdlibrary.dao.DvdLibraryFileImpl;
import com.m3.dvdlibrary.dto.DVD;
import com.m3.dvdlibrary.ui.DvdLibraryView;
import com.m3.dvdlibrary.ui.UserIO;
import com.m3.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 * @author Ishraq Khan && Ronald Gedeon && Brandon Turner; 
 * gitRepo: https://github.com/ishraqKhan21/DVDLibrary.git 
 * Class controller which is the brain of the app (delegation & coordination of all other neighbor classes), on April 6, 2022
 */
public class DvdLibraryController {
    
    DvdLibraryFileImpl dao = new DvdLibraryFileImpl();
        DvdLibraryView view = new DvdLibraryView();
        UserIOConsoleImpl io = new UserIOConsoleImpl();

    // Fields to be injectes
//    private final DvdLibraryFileImpl dao; 
//    private final DvdLibraryView view; 
//    private final UserIO io; 

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
                    removeDVDs();
                    break;
                case 5:
                    updateTheDVD();
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

        try {
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
                        loadAllDVDs();
                        break;
                    case 11:
                        saveAllDVDs();
                        break;
                    case 12:
                        keepGoing = false;
                        break;
                    default:
                        io.print("UNKNOWN COMMAND");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
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

    private void updateTheDVD() {
        view.displayUpdateBanner();
        DVD updatedDVD = view.getNewDVDInfo();
        dao.updateDVD(updatedDVD.getTitle(), updatedDVD);
        view.displayUpdateSuccessBanner();
    }
    
    private void removeDVDs() {
        view.displayRemoveCollectionDVDsBanner();
        dao.removeDVDs(view.getCollectionDVDInfoToRemove());
        view.displayRemoveCollectionDVDsSuccessBanner();
    }


    private void loadAllDVDs() throws Exception {
        view.displayLoadingDVDBanner();
        dao.loadDVDs();
        view.displayLoadingDVDSuccessBanner();
    }

    private void saveAllDVDs() throws Exception {
        view.displaySavingDVDBanner();
        dao.saveDVDs();
        view.displaySavingDVDSuccessBanner();
    }
}
