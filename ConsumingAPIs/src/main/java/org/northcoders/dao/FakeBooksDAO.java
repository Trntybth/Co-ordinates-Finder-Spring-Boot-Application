package org.northcoders.dao;
import org.northcoders.model.Book;
import org.northcoders.model.Data;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class FakeBooksDAO {

    // create a method that...
    // returns the RESPONSE BODY from a GET request (from postman???)
    // but it returns it mapped to the data model objects

    public Data getThing() {
        WebClient webClient = WebClient.builder().baseUrl("https://fakerapi.it/").build();
        Data responseBody;

        responseBody = webClient
                .get()
                .uri("api/v1/books")
                .retrieve()
                .bodyToMono(Data.class)// json string to objects
                .block();

        return responseBody;
    }


}
