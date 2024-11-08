public class Abilities {
    private int strength;
    private int wisdom;
    private int miraclesPerformed;
    private double faithLevel;
    private float humility;
    private String specialAbility;
    private String tribe;
    private boolean isLeader;

    public Abilities(int strength, int wisdom, int miraclesPerformed, double faithLevel, float humility, String specialAbility, String tribe, boolean isLeader) {
        this.strength = strength;
        this.wisdom = wisdom;
        this.miraclesPerformed = miraclesPerformed;
        this.faithLevel = faithLevel;
        this.humility = humility;
        this.specialAbility = specialAbility;
        this.tribe = tribe;
        this.isLeader = isLeader;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getMiraclesPerformed() {
        return miraclesPerformed;
    }

    public void setMiraclesPerformed(int miraclesPerformed) {
        this.miraclesPerformed = miraclesPerformed;
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
                "strength=" + strength +
                ", wisdom=" + wisdom +
                ", miraclesPerformed=" + miraclesPerformed +
                ", faithLevel=" + faithLevel +
                ", humility=" + humility +
                ", specialAbility='" + specialAbility +
                ", tribe='" + tribe +
                ", isLeader=" + isLeader + '}';
    }
}