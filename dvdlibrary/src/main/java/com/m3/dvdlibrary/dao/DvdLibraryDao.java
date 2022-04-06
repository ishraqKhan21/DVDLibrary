package com.m3.dvdlibrary.dao;

import com.m3.dvdlibrary.dto.DVD;
import java.util.List;

/**
 * @author Ishraq Khan && Ronald Gedeon && Brandon Turner; 
 * gitRepo: https://github.com/ishraqKhan21/DVDLibrary.git 
 * Interface with all mandatory behavior methods available for reading & saving data to a storage, on April 6, 2022
 */
public interface DvdLibraryDao {

        DVD addDVD(String title, DVD dvd);
        
        void addDVDs(List<DVD> dvds);
        
        DVD removeDVD(String title);
        
        List<DVD> removeDVDs(String[] titles, DVD dvds);
        
        DVD updateDVD(String title, DVD dvd);// call addDVD
        
        void updateDVDs(List<DVD> dvds);// call addDVDs
        
        DVD getDVD(String title); // search dvd by title
        
        List<DVD> getAllDVDs();
        
        void displayDVDinfo(DVD dvd, String info); // display dvd.get(info)
        
        void loadDVDs()throws Exception; // load DVDs library from the File
        
        void saveDVDs()throws Exception; // save DVDs library back to the File
        
}
