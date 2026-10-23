
package com.unpri.charactermanager.manager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
<<<<<<< HEAD
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        manager.addCharacter(
            new Character("Arka", 10, CharacterType.WARRIOR)
        );
        manager.addCharacter(
            new Character("Luna", 8, CharacterType.MAGE)
        );
        manager.addCharacter(
            new Character("Raka", 6, CharacterType.WARRIOR)
        );
        manager.addCharacter(
            new Character("Nara", 5, CharacterType.HEALER)
        );
        manager.addCharacter(
            new Character("Kirana", 12, CharacterType.ARCHER)
        );

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
=======

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("=== CHARACTER MANAGER TP5 ===");

        // Uji rata-rata ketika list masih kosong
        System.out.println(
            "Rata-rata list kosong: " + manager.getAverageLevel()
        );

        // Membuat karakter
        Character c1 = new Character(
            "Aria", 8, CharacterType.WARRIOR
        );

        Character c2 = new Character(
            "Bima", 6, CharacterType.MAGE
        );

        Character c3 = new Character(
            "Citra", 4, CharacterType.ARCHER
        );

        // CREATE
        System.out.println("\n=== CREATE ===");
        System.out.println("Tambah Aria: " + manager.addCharacter(c1));
        System.out.println("Tambah Bima: " + manager.addCharacter(c2));
        System.out.println("Tambah Citra: " + manager.addCharacter(c3));

        // Uji nama duplikat
        Character duplicate = new Character(
            "Aria", 10, CharacterType.MAGE
        );

        System.out.println(
            "Tambah Aria duplikat: "
            + manager.addCharacter(duplicate)
        );

        // READ
        System.out.println("\n=== READ ===");
        System.out.println("Cari Bima: " + manager.findByName("Bima"));
        System.out.println("Cari Deni: " + manager.findByName("Deni"));
        System.out.println("Total karakter: " + manager.getTotalCharacters());

        // READ ALL
        System.out.println("\n=== SEMUA KARAKTER ===");
        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // Uji getAllCharacters: salinan list
        System.out.println("\n=== UJI SALINAN LIST ===");
        ArrayList<Character> copy = manager.getAllCharacters();

        copy.clear();

        System.out.println("Ukuran salinan setelah clear: " + copy.size());
        System.out.println(
            "Total karakter asli setelah clear salinan: "
            + manager.getTotalCharacters()
        );

        // Uji equals
        System.out.println("\n=== UJI EQUALS ===");
        Character anotherAria = new Character(
            "Aria", 20, CharacterType.ARCHER
        );

        System.out.println(
            "Nama Aria sama menurut equals: " + c1.equals(anotherAria)
        );
        System.out.println(
            "Objek Aria sama menurut ==: " + (c1 == anotherAria)
        );

        // ANALYTICS
        System.out.println("\n=== ANALYTICS ===");
        System.out.println(
            "Rata-rata level: " + manager.getAverageLevel()
        );

        System.out.println("Karakter tipe WARRIOR:");
        for (Character character :
                manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(character);
        }

        System.out.println(
            "Jumlah MAGE: " + manager.countByType(CharacterType.MAGE)
        );

        // Uji reference
        System.out.println("\n=== UJI REFERENCE ===");
        Character a = new Character(
            "Dara", 3, CharacterType.WARRIOR
        );

        Character b = a;
        b.setLevel(8);

        System.out.println("Level a setelah level b diubah: " + a.getLevel());
        System.out.println("a == b: " + (a == b));

        // Membuat objek yang independen
        Character independent = new Character(
            a.getName(), a.getLevel(), a.getType()
        );

        independent.setLevel(12);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Level independent: " + independent.getLevel());
        System.out.println("a == independent: " + (a == independent));

        // UPDATE
        System.out.println("\n=== UPDATE ===");
        c2.setLevel(9);
        System.out.println("Bima setelah update: " + c2);

        // DELETE
        System.out.println("\n=== DELETE ===");
        System.out.println(
            "Hapus Citra: " + manager.removeCharacter("Citra")
        );
        System.out.println(
            "Hapus Citra lagi: " + manager.removeCharacter("Citra")
        );
        System.out.println(
            "Total karakter setelah delete: "
            + manager.getTotalCharacters()
        );

        System.out.println(
            "Total objek berhasil dibuat: "
            + Character.getTotalCharacterCreated()
        );
>>>>>>> 1839b646989e05707c098950befb06f2ce90a90e
    }
}
