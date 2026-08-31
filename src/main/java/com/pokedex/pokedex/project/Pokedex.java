package com.pokedex.pokedex.project;

import java.util.ArrayList;
import java.util.List;


public class Pokedex {

    private List<Pokemon> pokemonList;

    public Pokedex() {
        this.pokemonList = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public Pokemon searchByName(String name) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }

    public void listAllPokemon() {
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon);
        }
    }
    
    public List<Pokemon> getPokemonList(){
      return pokemonList;  
        
    }
      

}
    