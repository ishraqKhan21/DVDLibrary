package com.m3.dvdlibrary.ui;

import java.util.Scanner;

/**
 * @author Ronald Gedeon; email: gedemarcel0002@hotmail.com;  
 * gitRepo: https://github.com/gedegithub/C223-JavaDev.git 
 * Design of a class ... on month day, year
 */

public class UserIOConsoleImpl implements UserIO {
    
    public static Scanner userInput = new Scanner(System.in); // Scanner to read user input from the console
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return userInput.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(userInput.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int userVal; // container to hold the user integer
        do {
            System.out.println(prompt);
            userVal = Integer.parseInt(userInput.nextLine());// should be in a try catch for possible NullFormatException

        } while (!(userVal >= min && userVal <= max));
        return userVal;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(userInput.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double userVal; // container to hold the user double
        do {
            System.out.println(prompt);
            userVal = Double.parseDouble(userInput.nextLine());// should be in a try catch for possible NullFormatException

        } while (!(userVal >= min && userVal <= max));
        return userVal;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(userInput.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float userVal; // container to hold the user float
        do {
            System.out.println(prompt);
            userVal = Float.parseFloat(userInput.nextLine());// should be in a try catch for possible NullFormatException

        } while (!(userVal >= min && userVal <= max));
        return userVal;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(userInput.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long userVal; // container to hold the user long
        do {
            System.out.println(prompt);
            userVal = Long.parseLong(userInput.nextLine());// should be in a try catch for possible NullFormatException

        } while (!(userVal >= min && userVal <= max));
        return userVal;
    }
}


