package com.rpg.lab6;

public class Weapon {
    private String name;
    private String type;
    private int baseDamage;
    private String ability;

    public Weapon(String name, String type, int baseDamage, String ability) {
        this.name = name;
        this.type = type;
        this.baseDamage = baseDamage;
        this.ability = ability;
    }
    public String getName() { return name; }
    public int getBaseDamage() { return baseDamage; } // ใช้ getBaseDamage ตามโจทย์
    @Override
    public String toString() { return name + " (Type: " + type + ", Damage: " + baseDamage + ")"; }
}
