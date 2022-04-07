package com.m3.dvdlibrary;

import com.m3.dvdlibrary.controller.DvdLibraryController;
import com.m3.dvdlibrary.dao.DvdLibraryFileImpl;
import com.m3.dvdlibrary.ui.DvdLibraryView;
import com.m3.dvdlibrary.ui.UserIOConsoleImpl;
/**
 * @author Ishraq Khan && Ronald Gedeon && Brandon Turner; 
 * gitRepo: https://github.com/ishraqKhan21/DVDLibrary.git 
 * Class App that encapsulate the DVD library CRUD application using MVC, dependency injection & File Persistence, on April 6, 2022
 */
public class App {

    /**
     * This main method going to init the CRUD App by calling the controller.run()
     * @param args Unused.
     */
    public static void main(String[] args) {

        // For dependency injection
        UserIOConsoleImpl io = new UserIOConsoleImpl();
        DvdLibraryFileImpl dao = new DvdLibraryFileImpl();
        DvdLibraryView view = new DvdLibraryView(io);

        DvdLibraryController controller = new DvdLibraryController(dao, view);
        controller.run();
    }
}
