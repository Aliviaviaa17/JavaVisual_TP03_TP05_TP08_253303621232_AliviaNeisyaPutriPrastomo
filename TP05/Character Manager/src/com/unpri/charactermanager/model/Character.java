
package com.unpri.charactermanager.model;

public class Character {

    private String name;
    private int level;
    private CharacterType type;

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

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1.");
        }
        this.level = level;
    }

    @Override
    public String toString() {
        return "Character{name='" + name
                + "', level=" + level
                + ", type=" + type + "}";
    }
}
