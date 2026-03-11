package com.library.lab4;

public class Member {
    private String memberId;
    private String name;
    private int itemsBorrowed;
    private static final int MAX_BORROW = 3;

    public int getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(int itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(String memberId, String name){
        this.memberId = memberId;
        this.name = name;
        this.itemsBorrowed = 0;
    }

    public boolean canBorrow() {
        return (itemsBorrowed <MAX_BORROW);

    }

    public void borrowItem(){
        if (canBorrow()){
            this.itemsBorrowed++;
        }
    }

    public void returnItem(){
        if (this.itemsBorrowed > 0){
            this.itemsBorrowed--;
        }
    }
}
