package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.CountryList;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Scanner;

@Service
public class DAOCountries {
    /*
     * The getResponseBody method is similar to the previous one, however it does not prompt user input.
     * This method fetches data from the API and returns it via a CountryList object.
     * The search to the URL below (combined baseUrl with the uri, uses the name that is passed in) retrieves the actual data.
     * bodyToMono line then converts the JSON response body from the API to java countryList object.
     * */
    public CountryList getResponseBody(String name) {

        WebClient webClient = WebClient.builder().baseUrl("https://geocoding-api.open-meteo.com").build();
        CountryList responseBody;

        responseBody = webClient
                .get()
                .uri("/v1/search?name=" + name + "&count=1&language=en&format=json")
                .retrieve()
                .bodyToMono(CountryList.class)//
                .block();

        return responseBody;
    }

}

