package com.m3.dvdlibrary.controller;

import com.m3.dvdlibrary.dao.DvdLibraryFileImpl;
import com.m3.dvdlibrary.dto.DVD;
import com.m3.dvdlibrary.ui.DvdLibraryView;
import java.util.List;
/**
 * @author Ishraq Khan && Ronald Gedeon && Brandon Turner; 
 * gitRepo: https://github.com/ishraqKhan21/DVDLibrary.git 
 * Class controller which is the brain of the app (delegation & coordination of all other neighbor classes), on April 6, 2022
 */
public class DvdLibraryController {

    // Fields to be injected as dependencies
    private final DvdLibraryFileImpl dao;
    private final DvdLibraryView view;

    // Construction injection
    public DvdLibraryController(DvdLibraryFileImpl dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * This method holds all the business logic of the App.
     */
    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        // to catch all the checked exceptions resulting from reading or writing to File
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        createDVD(); // add a single DVD to Collection
                        break;
                    case 2:
                        createDVDs(); // add a list of DVDs to Collection
                        break;
                    case 3:
                        removeDVD(); // remove a single DVD from Collection
                        break;
                    case 4:
                        removeDVDs(); // remove a list of DVDs to Collection
                        break;
                    case 5:
                        updateTheDVD(); // update/edit a single DVD info in Collection
                        break;
                    case 6:
                        updateDVDs(); // update/edit a list of DVDs in Collection
                        break;
                    case 7:
                        listDVDs(); // List all the DVDs in Collection
                        break;
                    case 8:
                        viewDVD(); // Display one DVD info
                        break;
                    case 9:
                        searchDVD(); // search for a DVD by title in Collection to check wether it exists or not
                        break;
                    case 10:
                        loadAllDVDs(); // transfer all DVDs record from File to virtual memory (Map)
                        break;
                    case 11:
                        saveAllDVDs(); // transfer all DVDs from virtual memory (Map) to File
                        break;
                    case 12:
                        keepGoing = false; // condition to break out of the while loop
                        break;
                    default:
                        unknownCommand(); // default option for unknown command
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        exitMessage();
    }

    /**
     * This method gets and return menu selection entered by the user.
     */
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    /**
     * This method gonna just add a DVD in the Map with no return value.
     */
    private void createDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateDVDSuccessBanner();
    }

    /**
     * This method gonna just add a list of DVDs in the Map with no return
     * value.
     */
    private void createDVDs() {
        view.displayCreateCollectionDVDsBanner();
        List<DVD> newDVDs = view.getCollectionDVDInfo();
        dao.addDVDs(newDVDs);
        view.displayCreateCollectionDVDsSuccessBanner();
    }

    /**
     * This method gonna just update a single DVD in the Map with no return
     * value.
     */
    private void updateTheDVD() {
        view.displayUpdateBanner();
        DVD updatedDVD = view.getNewDVDInfo();
        dao.updateDVD(updatedDVD.getTitle(), updatedDVD);
        view.displayUpdateSuccessBanner();
    }

    /**
     * This method gonna just update a list of DVDs in the Map with no return
     * value.
     */
    private void updateDVDs() {
        view.displayUpdateCollectionDVDsBanner();
        List<DVD> newDVDs = view.getCollectionDVDInfo();
        dao.updateDVDs(newDVDs);
        view.displayUpdateCollectionDVDsSuccessBanner();
    }

    /**
     * This method gonna just display a list of DVDs in the Map with no return
     * value.
     */
    private void listDVDs() {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    /**
     * This method gonna just display a single DVD in the Map with no return
     * value.
     */
    private void viewDVD() {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    /**
     * This method gonna just delete a DVD in the Map with no return value.
     */
    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitle();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }

    /**
     * This method gonna just delete a list of DVDs in the Map with no return
     * value.
     */
    private void removeDVDs() {
        view.displayRemoveCollectionDVDsBanner();
        dao.removeDVDs(view.getCollectionDVDsTitleToRemove());
        view.displayRemoveCollectionDVDsSuccessBanner();
    }

    /**
     * This method gonna just check the existence of a DVD in collection (Map)
     */
    private void searchDVD() {
        view.displaySearchDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displaySearchDVD(dvd);
    }

    /**
     * This method gonna just unMarshall the File and transfer the DVDs objects
     * to virtual memory (Map)
     */
    private void loadAllDVDs() throws Exception {
        view.displayLoadingDVDBanner();
        dao.loadDVDs();
        view.displayLoadingDVDSuccessBanner();
    }

    /**
     * This method gonna just Marshall the DVDs objects and write them to a File
     * to virtual memory (Map)
     */
    private void saveAllDVDs() throws Exception {
        view.displaySavingDVDBanner();
        dao.saveDVDs();
        view.displaySavingDVDSuccessBanner();
    }

    /**
     * Two utility methods for refactoring sake
     */
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
