package com.m3.dvdlibrary.controller;

import com.m3.dvdlibrary.ui.UserIO;
import com.m3.dvdlibrary.ui.UserIOConsoleImpl;

/**
 * @author Ronald Gedeon; email: gedemarcel0002@hotmail.com;  
 * gitRepo: https://github.com/gedegithub/C223-JavaDev.git 
 * Design of a class ... on month day, year
 */
public class DvdLibraryController {
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
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
            
            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 12);

            switch (menuSelection) {
                case 1:
                    io.print("ADD ONE DVD TO THE COLLECTION");
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
                    io.print("LIST ALL THE DVDs IN THE COLLECTION");
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
}

