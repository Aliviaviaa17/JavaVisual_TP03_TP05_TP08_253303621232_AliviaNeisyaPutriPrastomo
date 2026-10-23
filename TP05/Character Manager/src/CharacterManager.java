
package com.unpri.charactermanager.manager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;
<<<<<<< HEAD

public class CharacterManager {

=======
import java.util.List;
import java.util.Objects;

public class CharacterManager {
>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
    private final ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

<<<<<<< HEAD
    public void addCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Karakter tidak boleh null.");
        }
        characters.add(character);
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
=======
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equals(name.trim())) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
    }

    public int getTotalCharacters() {
        return characters.size();
    }

<<<<<<< HEAD
=======
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
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

<<<<<<< HEAD
=======
        if (type == null) {
            return result;
        }

>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }
<<<<<<< HEAD
=======

    /**
     * Menghitung jumlah karakter berdasarkan tipe tertentu.
     *
     * @param type tipe karakter yang akan dihitung
     * @return jumlah karakter dengan tipe tersebut
     */
    public int countByType(CharacterType type) {
        if (type == null) {
            return 0;
        }

        int count = 0;

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
}
