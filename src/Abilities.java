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
        this.strength = strength;
        this.wisdom = wisdom;
        this.faithLevel = faithLevel;
        this.humility = humility;
        this.specialAbility = specialAbility;
        this.tribe = tribe;
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
        this.wisdom = wisdom;
    }

    public double getFaithLevel() {
        return faithLevel;
    }

    public void setFaithLevel(double faithLevel) {
        this.faithLevel = faithLevel;
    }

    public float getHumility() {
        return humility;
    }

    public void setHumility(float humility) {
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
        if (tribe == null) {
            throw new IllegalArgumentException("Tribe cannot be empty");
        }
        this.tribe = tribe;
    }

    public boolean getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    @Override
    public String toString() {
        return "Abilities{" +
                "name=" + name +
                "strength=" + strength +
                ", wisdom=" + wisdom +
                ", faithLevel=" + faithLevel +
                ", humility=" + humility +
                ", specialAbility='" + specialAbility +
                ", tribe='" + tribe +
                ", isLeader=" + isLeader + '}';
    }
}