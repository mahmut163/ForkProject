package apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.TestUtility;

import java.util.ArrayList;
import java.util.List;


public class ApiTestRunner {

    private static String configFile = "config.properties";
    private static String baseUrl;
    @Test
    public void getAllNormalTypePokemons() throws JsonProcessingException {
         baseUrl= TestUtility.readFromConfigProperties(configFile,"baseurl");
        //Sending request to get respone
        Response pokepomListResponse= (Response) RestAssured.when().get(baseUrl);
        pokepomListResponse.then().assertThat().statusCode(200);
        List<Pokemon> pokemons = pokepomListResponse.getBody().jsonPath().getList("results", Pokemon.class);
        List<Pokemon> normalTypePokemons = new ArrayList<>();
        Response pokemonResponse;
        for (Pokemon pokemon : pokemons) {
            pokemonResponse = RestAssured.when().get(pokemon.getUrl());

            if(pokemonResponse.getBody().jsonPath().get("types.type.name").toString().contains("normal")){
                normalTypePokemons.add(pokemon);
            }
        }

        System.out.println("The list of normal type Pokemons: ");
       for (Pokemon poke : normalTypePokemons){
           System.out.println("name = " + poke.getName() + ", url = " + poke.getUrl());
       }


    }

}

