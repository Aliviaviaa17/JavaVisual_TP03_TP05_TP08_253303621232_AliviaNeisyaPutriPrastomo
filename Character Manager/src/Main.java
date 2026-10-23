
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        // Membuat tiga karakter
        Character c1 = new Character(
            "Arthur", CharacterType.WARRIOR
        );

        Character c2 = new Character(
            "Merlin", CharacterType.MAGE, 2, 120, 15
        );

        Character c3 = new Character(
            "Robin", CharacterType.ARCHER
        );

        System.out.println("=== DAFTAR KARAKTER ===");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Demonstrasi level up
        System.out.println("\n=== DEMO LEVEL UP ===");
        System.out.println("Sebelum level up: " + c1);
        c1.setLevel(c1.getLevel() + 1);
        System.out.println("Setelah level up: " + c1);

        // Mini-Challenge: mana dan isAlive()
        Character c4 = new Character(
            "Luna", CharacterType.MAGE
        );

        c4.setMana(80);

        System.out.println("\n=== MINI-CHALLENGE ===");
        System.out.println(c4);
        System.out.println(
            "Apakah " + c4.getName() + " masih hidup? "
            + c4.isAlive()
        );

        // Menguji karakter yang HP-nya nol
        c4.setHitPoints(0);
        System.out.println(
            "Setelah HP menjadi 0: " + c4.isAlive()
        );
    }
}