package com.example.top_trumps_the_bible.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")  // Rename the table to avoid using the reserved keyword "character"
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    private int strength;
    private int wisdom;
    private double faithLevel;
    private float humility;
    private String specialAbility;
    private String tribe;
    private boolean isLeader;
    
    // Default constructor (required by JPA)
    public Character() {
    }

    public Character(String name, int strength, int wisdom, double faithLevel, float humility, String specialAbility, String tribe, boolean isLeader) {
        this.name = name;
        this.strength = strength;
        this.wisdom = wisdom;
        this.faithLevel = faithLevel;
        this.humility = humility;
        this.specialAbility = specialAbility;
        this.tribe = tribe;
        this.isLeader = isLeader;
    }
    
    public Comparable<?> getAttributeValue(Attribute attribute) {
    	switch (attribute) {
	        case STRENGTH:
	            return strength;
	        case WISDOM:
	            return wisdom;
	        case FAITH_LEVEL:
	            return faithLevel;
	        case HUMILITY:
	            return humility;
	        case SPECIAL_ABILITY:
	            return specialAbility;
	        case TRIBE:
	            return tribe;
	        case LEADER:
	            return isLeader;
	        default:
	            throw new IllegalArgumentException("Unknown attribute: " + attribute);
    	}
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

    public boolean getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Character: " + name + "\n" +
        		"Special Ability: " + specialAbility + "\n" +
                "Strength: " + strength + "\n" +
                "Wisdom: " + wisdom + "\n" +
                "Faith Level: " + faithLevel + "\n" +
                "Humility: " + humility + "\n" +
                "Tribe: " + tribe + "\n" +
                "Leader: " + (isLeader ? "Yes" : "No") + "\n";
    }
}