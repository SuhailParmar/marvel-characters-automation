package com.yapily.automation.steps;

import com.yapily.automation.client.CharactersApiClient;
import com.yapily.automation.models.Character;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.assertj.core.api.Assertions;

import java.util.List;

public class CharactersSteps {

    private final int aBombId = 1017100;
    private CharactersApiClient charactersApiClient;

    @When("I request a list of marvel characters")
    public void iRequestAListOfMarvelCharacters() {
        charactersApiClient = new CharactersApiClient();
        charactersApiClient.getAllCharacterIds();
    }

    @When("I request a Marvel character by ID")
    public void iRequestAMarvelCharacterByID() {
        charactersApiClient = new CharactersApiClient();
        charactersApiClient.getCharacterById(aBombId);
    }

    @When("I request a Marvel character which does not exist")
    public void iRequestAMarvelCharacterWhichDoesNotExist() {
        charactersApiClient = new CharactersApiClient();
        charactersApiClient.getCharacterById(1);
    }

    @When("I request a Marvel character with ID {int}")
    public void iRequestAMarvelCharacterWithID(int userId) {
        charactersApiClient = new CharactersApiClient();
        charactersApiClient.getCharacterById(userId);
    }

    @Then("a list of user IDs are returned")
    public void aListOfUserIDsAreReturned() {
        SerenityRest.then().statusCode(200);
        List<Integer> ids = SerenityRest.lastResponse().jsonPath().getList(".", Integer.class);
        Assertions.assertThat(ids).as("Verify list returns all of the Marvel character ids").hasSize(1493);
        Assertions.assertThat(ids).as("Verify list contains a specific Character - A Bomb").contains(aBombId);
    }

    @Then("a Marvel character is returned")
    public void aMarvelCharacterIsReturned() {
        SerenityRest.then().statusCode(200);
        final Character expectedAbomb = Character.builder()
                .id(aBombId)
                .name("A-Bomb (HAS)")
                .thumbnail(Character.CharacterThumbnail.builder()
                        .path("http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16")
                        .extension("jpg")
                        .build())
                .description("Rick Jones has been Hulk's best bud since day one, but now he's more than" +
                        " a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, " +
                        "armored skin is just as strong and powerful as it is blue. And when he curls into action," +
                        " he uses it like a giant bowling ball of destruction! ")
                .build();

        final Character actualAbomb = SerenityRest.lastResponse().as(Character.class);
        Assertions.assertThat(expectedAbomb).as("Verify A-Bomb is returned")
                .usingRecursiveComparison()
                .isEqualTo(actualAbomb);
    }

    @Then("I am notified the character is not found")
    public void iAmNotifiedTheCharacterIsNotFound() {
        SerenityRest.then().statusCode(404);
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        Assertions.assertThat(responseBody).as("Verify no response body is returned").isNullOrEmpty();
    }

    @Then("I am notified of a bad request")
    public void iAmNotifiedOfABadRequest() {
        SerenityRest.then().statusCode(400);
        String responseBody = SerenityRest.lastResponse().getBody().asString();
        Assertions.assertThat(responseBody).as("Verify no response body is returned").isNullOrEmpty();
    }
}