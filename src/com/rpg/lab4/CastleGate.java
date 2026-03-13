package com.rpg.lab4;

public class CastleGate implements Destructible {
    private String name;
    private int durability;
    private int maxDurability;
    private boolean locked;
    private boolean reinfored;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReinfored() {
        return reinfored;
    }

    public void setReinfored(boolean reinfored) {
        this.reinfored = reinfored;
    }

    public CastleGate(String name, int durability, boolean locked, boolean reinfored){
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.locked = locked;
        this.reinfored = reinfored;
    }

    @Override
    public void takeDamage(int amount){
        int finalDamage = amount;
        if (reinfored){
            finalDamage = amount/2;
            System.out.println(name+ " is REINFORCE! (reduces damage from "+ amount+" to "+finalDamage+")");
        }

        this.durability -= finalDamage; {
            System.out.println(name + " has been BREACHED! The gate COLLAPSES!");
        }
    }

    @Override
    public boolean isDestroyed(){
        return durability <=0;
    }

    public void displayGateDetails(){
        System.out.println("--- "+name.toUpperCase()+"--- ");
        System.out.println("Status: "+(isDestroyed() ? "BREACHED": "INTACT"));
        System.out.println("Durability: "+ durability+ "/"+ maxDurability);
        System.out.println("Locked: "+(locked? "Yes" :"No"));
        System.out.println("Reinforced: "+(reinfored?"Yes":"No"));
    }
}
