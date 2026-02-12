package com.rpg.lab01;

public class Weapon {
    private String name;
    private String type;
    private int basedamage;
    private String ability;

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getBaseDamage() {
        return basedamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.basedamage = baseDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Weapon(String name, String type, int baseDamage, String ability){
        this.name = name;
        this.type = type;
        this.basedamage = baseDamage;
        this.ability = ability;
    }

    @Override
    public String toString(){
        return name+" (Type: "+type+", Damage: "+basedamage+", Ability: " +ability+")";
    }
}


