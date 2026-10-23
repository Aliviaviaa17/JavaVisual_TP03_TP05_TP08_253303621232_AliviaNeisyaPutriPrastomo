
package com.unpri.charactermanager.model;

<<<<<<< HEAD
public class Character {

=======
import java.util.Objects;

public class Character {
>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
    private String name;
    private int level;
    private CharacterType type;

<<<<<<< HEAD
    public Character(String name, int level, CharacterType type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama karakter tidak boleh kosong.");
        }

        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1.");
        }

        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter harus diisi.");
        }

        this.name = name;
        this.level = level;
        this.type = type;
=======
    private static int totalCharacterCreated = 0;

    public Character(String name, int level, CharacterType type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }

        if (level < 1) {
            throw new IllegalArgumentException(
                "Level karakter minimal 1."
            );
        }

        this.name = name.trim();
        this.level = level;
        this.type = Objects.requireNonNull(
            type, "Tipe karakter tidak boleh null."
        );

        totalCharacterCreated++;
>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public CharacterType getType() {
        return type;
    }

<<<<<<< HEAD
    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1.");
        }
        this.level = level;
    }

=======
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }

        this.name = name.trim();
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level karakter minimal 1."
            );
        }

        this.level = level;
    }

    public void setType(CharacterType type) {
        this.type = Objects.requireNonNull(
            type, "Tipe karakter tidak boleh null."
        );
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
    @Override
    public String toString() {
        return "Character{name='" + name
                + "', level=" + level
                + ", type=" + type + "}";
    }
}
