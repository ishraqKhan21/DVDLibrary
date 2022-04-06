package com.m3.dvdlibrary.dao;

import com.m3.dvdlibrary.dto.DVD;
import java.util.List;

/**
 * @author Ronald Gedeon; email: gedemarcel0002@hotmail.com;  
 * gitRepo: https://github.com/gedegithub/C223-JavaDev.git 
 * Design of an interface defining ... on month day, year
 */
public interface DvdLibraryDao {

        DVD addDVD(String title, DVD dvd);
        
        List<DVD> addDVDs(String[] titles, DVD dvds);
        
        DVD removeDVD(String title);
        
        List<DVD> removeDVDs(String[] titles, DVD dvds);
        
        DVD updateDVD(String title, DVD dvd);// call addDVD
        
        DVD updateDVDs(String[] titles, DVD dvds);// call addDVDs
        
        DVD getDVD(String title); // search dvd by title
        
        List<DVD> getAllDVDs();
        
        void displayDVDinfo(DVD dvd, String info); // display dvd.get(info)
        
        void loadDVDs(); // load DVDs library from the File
        
        void saveDVDs(); // save DVDs library back to the File
        
}
