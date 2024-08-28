package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.Country;
import com.northcoders.demospringbootapp.model.CountryList;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Scanner;

public class DAOUserInputCountries {

    /*
     *  This first method allows for user input. Used by printCoordinates.
     *  Creates get request to the base URL using the user input.
     *  Params limit the response to one object.
     *  Converts JSON to local java objects.
     *  Returns body as CountryList
     * */
    public CountryList getResponseBodyUserInput() {
        WebClient webClient = WebClient.builder().baseUrl("https://geocoding-api.open-meteo.com").build();
        CountryList responseBody;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter country or city name to receive longitude and latitude:");
        String countryName = scanner.nextLine();

        responseBody = webClient
                .get()
                .uri("/v1/search?name=" + countryName + "&count=1&language=en&format=json")
                .retrieve()
                .bodyToMono(CountryList.class)// json string to objects
                .block();

        return responseBody;
    }

    /*
    The point of this method is to print the longitude and latitude to console.
     * This method calls the first method, prompting input, then uses the returned list.
     * Since the list is capped at 1, using getFirst method we store the object itself in chosenCountry.
     * We access long and lat from the country and print to console.
     * */
    public void printCoordinates() {
        CountryList countryList = getResponseBodyUserInput();
        Country chosenCountry = countryList.results().getFirst(); // get first index from list (only result because search was limited to 1)
        System.out.println("Latitude: " + chosenCountry.latitude() + ". Longitude: " + chosenCountry.longitude());
    }

}
