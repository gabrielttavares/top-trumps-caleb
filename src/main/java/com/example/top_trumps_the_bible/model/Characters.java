package com.example.top_trumps_the_bible.model;

import java.util.List;

public class Characters {
    private List<Character> characters;

    public Characters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCharacterList() {
        return characters;
    }

    public void displayAllCharacters() {
        for (Character character : characters) {
            System.out.println(character);
        }
    }
}