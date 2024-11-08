import java.util.ArrayList;
import java.util.List;

public class Characters extends Abilities{
    private List<Abilities>characters;

    public Characters(String name, int strength, int wisdom, double faithLevel, float humility, String specialAbility, String tribe, boolean isLeader) {
        super(name, strength, wisdom, faithLevel, humility, specialAbility, tribe, isLeader);
        characters = new ArrayList<>();
    }

    public void addCharacter(Abilities abilities){
        characters.add(abilities);
    }

    public void findCharacterByName(String name) {
        for (Abilities character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                System.out.println(character);
                return;
            }
        }
        System.out.println("Character not found.");
    }

    public static void main(String[] args) {
        Abilities mosesAbilities = new Abilities("Moses", 70, 70, 30, 4, "Parting the Sea", "Levi", true);
        System.out.println(mosesAbilities);
    }
}
