package com.rpg.lab6;

public class HealthPotion implements Consumable{
    private String name;
    private int healingPower;
    private int quantity;

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public HealthPotion(String name, int healingPower, int quantity){
        this.name =name;
        this.healingPower =healingPower;
        this.quantity = quantity;
    }

    public void displayPotionDetails(){
        System.out.println("--- "+name.toUpperCase()+" ---");
        System.out.println("Healing Power: "+healingPower+" HP");
        System.out.println("Quantity: "+quantity);
        System.out.println("Type: Consumable");
    }

    @Override
    public void use (Character user){
        if(quantity>0){
            System.out.println(user.getName()+" drinks "+name+"!");
            int oldHp = user.getHealthPoints();
            int newHp = oldHp+healingPower;
            if (newHp > user.getMaxHealthPoints()){
                newHp = user.getMaxHealthPoints();
            }
            user.setHealthPoints(newHp);
            System.out.println("Health restored: "+oldHp+" -> "+newHp+" ("+healingPower+")");
            quantity--;
            System.out.println(name+" remaining: "+ quantity);
        }
    }
}
