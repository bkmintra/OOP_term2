package com.rpg.lab01;

import java.lang.Character;

public class Healer extends java.lang.Character {
    private int healAmount;

    public Healer(String name, int level, int hp, Weapon weapon, int healAmount) {
        super(name, level, hp, weapon, "Healer");
        this.healAmount = healAmount;
    }

    private int totalHealingPower() {
        return healAmount + (level * 3);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Healing Power: " + totalHealingPower());
    }

    public void heal(){
        System.out.println(name+ " ("+ state+") casts a healing spell!");
        int healAmount = totalHealingPower();
        int levelBonus = level * 3;
        System.out.println("Healing Amount: "+healAmount+" (Base: "+healAmount+" + Level Bonnus: "+levelBonus+")");
        this.newHeal(healAmount);
        System.out.println("Restored "+healAmount+" HP! Current HP: "+hp+"/"+maxHp);
    }

    public void healWarrior(Character target){
        System.out.println(name+ " ("+state+ ") casts healing spell on " +target.name + "!");
        int healAmount = totalHealingPower();
        System.out.println("Healing Amount: "+ healAmount);

        target.newHeal(healAmount);
        System.out.println("Restored "+ healAmount+ "HP to "+ target.name+ "! Their HP: "+target.hp);
    }
}


