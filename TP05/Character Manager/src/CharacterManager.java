
package com.unpri.charactermanager.manager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Karakter tidak boleh null.");
        }
        characters.add(character);
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }
}
