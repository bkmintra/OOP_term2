package com.rpg.lab;

public class Healer extends Character {
    private int healPower;

    public Healer(String name, int level, int hp,int baseDamage,int defense,Weapon weapon, int healPower) {
        super(name,level, hp, baseDamage, defense, weapon,"Healer");
        this.healPower = healPower;
    }

    private int totalHealingPower() {
        return healPower + (level * 3);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Healing Power: " + totalHealingPower());
    }

    public void heal(){
        System.out.println(name+ " ("+ job +") casts a healing spell!");
        int totalHeal = totalHealingPower();
        int levelBonus = level * 3;
        System.out.println("Healing Amount: "+totalHeal+" (Base: "+healPower+" + Level Bonnus: "+levelBonus+")");
        this.receiveHeal(totalHeal);
        int oldHp = this.hp;
        this.hp += totalHeal;
        if (this.hp > this.maxHp)
            this.hp = this.maxHp;
        System.out.println("Restored "+ totalHeal+" HP! Current HP: "+hp+"/"+maxHp);

        //this.newHeal(totalHeal);

    }

    public void healWarrior(Character target){
        System.out.println(name+ " ("+ job + ") casts healing spell on " +target.name + "!");
        int totalHeal = totalHealingPower();
        System.out.println("Healing Amount: "+ totalHeal);

        target.receiveHeal(totalHeal);

    }
}

