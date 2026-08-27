package com.pokedex.pokedex.project;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokeApiService {

    // Fetches raw JSON data from PokéAPI by Pokemon name
    public static String fetchPokemonData(String pokemonName) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + pokemonName.toLowerCase().trim()))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body(); // Returns raw JSON text
            } else {
                System.out.println("Error: Pokemon not found on PokéAPI.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error connecting to PokéAPI: " + e.getMessage());
            return null;
        }
    }
}