package com.yapily.automation.client;

import net.serenitybdd.rest.SerenityRest;

public class CharactersApiClient {

    private static final String API_URL = "http://localhost:8080/characters";

    public void getAllCharacterIds() {
        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .get(API_URL);
    }

    public void getCharacterById(int id) {
        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .pathParam("id", id)
                .get(API_URL + "/{id}");
    }
}