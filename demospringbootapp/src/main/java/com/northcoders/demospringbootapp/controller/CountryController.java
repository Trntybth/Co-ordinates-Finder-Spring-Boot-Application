package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.CountryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // combines @Controller and @ResponseBody. Marks class as Sprint MVC Controller (model view controller)
public class CountryController {

    private final DAOCountries daoCountries; // immutable field declaration

    @Autowired // Annotation tells Spring to automatically inject an instance of DAOCountries into the CountryController.
    // this is a preferred dependency injection in Spring.
    public CountryController(DAOCountries daoCountries) {
        this.daoCountries = daoCountries;
    }

    /*
     * This below method is handling a request to /coordinates endpoint.
     *
     * Make a GET request to http://localhost:8080/coordinates?name=Paris (for example) in web browser.
     * Spring boot uses @GetMapping("/coordinates) annotation, which tells it that this method should handle GET requests to /coordinates URL.
     * @RequestParam String name <--- This line is extracting the name parameter from the URL (name=paris, e.g) and passes it to the method)
     * Therefore, paris is passed into getResponseBody in DAOCountries and a get request is created using the name detected in the URL.
     *
     * */
    @GetMapping("/coordinates")
    public CountryList countryList(@RequestParam String name) {
        return daoCountries.getResponseBody(name);
    }
}