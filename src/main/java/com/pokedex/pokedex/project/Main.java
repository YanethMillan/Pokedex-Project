package com.pokedex.pokedex.project;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();
        boolean running = true;

        System.out.println("=== WELCOME TO YOUR POKEDEX ===");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Fetch and Add Pokemon from PokéAPI");
            System.out.println("2. Search Pokemon in local Pokedex");
            System.out.println("3. Show all stored Pokemon");
            System.out.println("4. Exit");
            System.out.print("Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Pokemon name to fetch (e.g., pikachu, ditto): ");
                    String nameToFetch = scanner.nextLine();

                    String jsonResponse = PokeApiService.fetchPokemonData(nameToFetch);

                    if (jsonResponse != null) {

                        JsonObject pokemonJson = JsonParser.parseString(jsonResponse).getAsJsonObject();

                        int id = pokemonJson.get("id").getAsInt();
                        String name = pokemonJson.get("name").getAsString();

                        String type = pokemonJson.getAsJsonArray("types")
                                .get(0).getAsJsonObject()
                                .getAsJsonObject("type")
                                .get("name").getAsString();

                        int hp = pokemonJson.getAsJsonArray("stats")
                                .get(0).getAsJsonObject()
                                .get("base_stat").getAsInt();

                        Pokemon newPokemon = new Pokemon(id, name, type, hp);

                        pokedex.addPokemon(newPokemon);

                        System.out.println("Success! Processed " + nameToFetch);
                    }
                    break;

                case 2:
                    System.out.print("Enter name to search in local Pokedex: ");
                    String searchName = scanner.nextLine();
                    Pokemon found = pokedex.searchByName(searchName);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Pokemon not found in your local collection.");
                    }
                    break;

                case 3:
                    pokedex.listAllPokemon();
                    break;
                case 4:
                    List<Pokemon> list = pokedex.getPokemonList();
                    for(int position = 0; position < list.size() -1; position++){
                        if(list.get(position).getHp() > list.get(position +1).getHp()){
                            Pokemon temporary = list.get(position);
                            list.set(position, list.get(position + 1));
                            list.set(position + 1, temporary);
                        }
                }
                
                    
                    
                    
                    
                    
                    
                    
                case 5:
                    running = false;
                    System.out.println("Closing Pokedex... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
