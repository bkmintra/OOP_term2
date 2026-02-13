package com.library.lab;

public class Member {
    private String memberId;
    private String name;
    private int booksBorrowed;
    private static final int MAX_BORROW = 3;

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(int booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
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
        this.booksBorrowed = 0;
    }

    public boolean canBorrow() {
        return (booksBorrowed <MAX_BORROW);

    }

    public void borrowBook(){
        if (canBorrow()){
            this.booksBorrowed++;
        }
    }

    public void returnBook(){
        if (this.booksBorrowed > 0){
            this.booksBorrowed--;
        }
    }
}
