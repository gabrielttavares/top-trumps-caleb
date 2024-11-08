public class Abilities {
    private String name;
    private int strength;
    private int wisdom;
    private double faithLevel;
    private float humility;
    private String specialAbility;
    private String tribe;
    private boolean isLeader;

    public Abilities(String name, int strength, int wisdom, double faithLevel, float humility, String specialAbility, String tribe, boolean isLeader) {
        this.name = name;
        setStrength(strength);
        setWisdom(wisdom);
        setFaithLevel(faithLevel);
        setHumility(humility);
        this.specialAbility = specialAbility;
        setTribe(tribe);
        this.isLeader = isLeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException("Strength cannot be negative");
        }
        this.strength = strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        if (wisdom < 0 || wisdom > 100) {
            throw new IllegalArgumentException("Wisdom must be between 0 and 100");
        }
        this.wisdom = wisdom;
    }

    public double getFaithLevel() {
        return faithLevel;
    }

    public void setFaithLevel(double faithLevel) {
        if (faithLevel < 0 || faithLevel > 100) {
            throw new IllegalArgumentException("Faith Level must be between 0 and 100");
        }
        this.faithLevel = faithLevel;
    }

    public float getHumility() {
        return humility;
    }

    public void setHumility(float humility) {
        if (humility < 0 || humility > 10) {
            throw new IllegalArgumentException("Humility must be between 0 and 10");
        }
        this.humility = humility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        if (tribe == null || tribe.isEmpty()) {
            throw new IllegalArgumentException("Tribe cannot be empty");
        }
        this.tribe = tribe;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setIsLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    @Override
    public String toString() {
        return "Character: " + name + "\n" +
                "Strength: " + strength + "\n" +
                "Wisdom: " + wisdom + "\n" +
                "Faith Level: " + faithLevel + "\n" +
                "Humility: " + humility + "\n" +
                "Special Ability: " + specialAbility + "\n" +
                "Tribe: " + tribe + "\n" +
                "Leader: " + (isLeader ? "Yes" : "No") + "\n";
    }
}