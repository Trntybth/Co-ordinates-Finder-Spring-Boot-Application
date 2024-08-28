package com.northcoders.demospringbootapp.model;

import com.northcoders.demospringbootapp.controller.DAOCountries;
import com.northcoders.demospringbootapp.controller.DAOUserInputCountries;

public class Main {
    public static void main(String[] args) {

        /*
         * Running this main method prompts user input, and then gets the data from the API and returns to console.
         * */

        DAOUserInputCountries dao = new DAOUserInputCountries();
        dao.printCoordinates();
    }
}
