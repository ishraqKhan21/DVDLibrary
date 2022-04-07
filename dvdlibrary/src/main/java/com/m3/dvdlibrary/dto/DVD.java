package com.m3.dvdlibrary.dto;

/**
 * @author Ishraq Khan && Ronald Gedeon && Brandon Turner; 
 * gitRepo: https://github.com/ishraqKhan21/DVDLibrary.git 
 * Class for domain objects or data transfer objects of the App, on April 6, 2022
 */
public class DVD {

    private final String title; // read only field to pass to constructor
    private String releaseDate; // private field
    private String mpaaRating; // private field
    private String directorName; // private field
    private String studio; // private field
    private String review; // private field
    
    // Constructor
    public DVD(String title) {
        this.title = title;
    }

    /* All the getters & setters */
    
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
