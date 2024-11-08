public class Characters extends Abilities{
    public Characters(String name, int strength, int wisdom, double faithLevel, float humility, String specialAbility, String tribe, boolean isLeader) {
        super(name, strength, wisdom, faithLevel, humility, specialAbility, tribe, isLeader);
    }

    public static void main(String[] args) {
        Abilities mosesAbilities = new Abilities("Moses", 70, 70, 30, 2, "Parting the Sea", "Levi", true);
        System.out.println(mosesAbilities);
    }
}
