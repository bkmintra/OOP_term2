package com.rpg.lab4;

public class WoodenBox implements Destructible{
    private String name;
    private int hp;
    private int maxHp;
    private boolean locked;
    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WoodenBox(String name, int hp, boolean locked, String contents){
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.locked = locked;
        this.contents = contents;
    }

    @Override
    public void takeDamage(int amount){
        System.out.println(name+" takes "+amount+" damage!");
        this.hp -= amount;
        if(this.hp < 0)this.hp =0;

        if(this.hp == 0){
            System.out.println(name+ " HP: "+hp+"/"+maxHp+" (DESTROYED!)");
        }else{
            System.out.println(name+" HP: "+hp+"/"+maxHp);
        }

    }

    @Override
    public boolean isDestroyed(){
        return hp <=0;
    }

    public void displayBoxDetails(){
        System.out.println("--- "+name.toUpperCase()+" (WOODEN BOX) ---");
        System.out.println("Status: "+(isDestroyed()? "Destroyed":"Intact"));
        System.out.println("Health: "+hp+"/"+maxHp);
        System.out.println("Locked: "+(locked? "YES":"NO"));
        System.out.println("Contains: "+contents);
    }

    public void breakOpen(){
        if(!isDestroyed()){
            System.out.println("Cannot break open "+name+" - it's still intact!");
        }else{
            if(locked){
                System.out.println("The lock broke! "+name+" breaks open!");
            }else {
                System.out.println(name+" breaks open!");
            }
            System.out.println("Contents revealed: "+contents);
        }
    }
}

