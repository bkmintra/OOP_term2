package com.rpg.lab6;

public class StoneWall implements Destructible{
    private String name;
    private int durability;
    private int maxDurability;
    private String type;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StoneWall(String name, int durability, String type){
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.type = type;
    }

    public String getLocation(){
        return name;
    }

    @Override
    public void takeDamage(int amount){
        this.durability -= amount;
        System.out.println(name+" takes "+amount + " damage! (Durability: "+durability+"/"+maxDurability+")");
        if(this.durability <= 0){
            this.durability = 0;
            System.out.println(name=" has CRUMBLED to pieces!");
        }
    }

    @Override
    public boolean isDestroyed(){
        return durability <= 0;
    }

    public void displayWallDetails(){
        System.out.println("--- "+name.toUpperCase()+" ---");
        System.out.println("Type: "+type);
        System.out.println("Status: "+(isDestroyed() ? "DESTROYED": "STANDING"));
        System.out.println("Durability: "+durability+"/"+maxDurability);
    }
}
