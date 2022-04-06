package com.m3.dvdlibrary;

import com.m3.dvdlibrary.controller.DvdLibraryController;

/**
 * @author Ronald Gedeon; email: gedemarcel0002@hotmail.com; gitRepo:
 * https://github.com/gedegithub/C223-JavaDev.git Description
 */
public class App {

    /**
     * This main method going to init the CRUD App.
     * @param args Unused.
     */
    public static void main(String[] args) {
        DvdLibraryController controller = new DvdLibraryController();
        controller.run();
    }
}
