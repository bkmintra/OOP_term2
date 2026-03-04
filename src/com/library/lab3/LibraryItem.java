package com.library.lab3;

import java.time.LocalDate;


public abstract class LibraryItem {
    protected String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected String author;
    protected String isbn;
    protected double price;
    protected String status;
    protected LocalDate returnDueDate;
    protected Member currentBorrower;

    public LibraryItem(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = "Available";
    }

    public void checkOut(Member borrower){
        if ("Borrowed".equalsIgnoreCase(this.status)) {
            System.out.println("Error: Book '"+this.title+"' is already borrowed and cannot be checked out again.");
            return;
        }

        if (!borrower.canBorrow()){
            System.out.println("Member "+ borrower.getName()+" has reached the borrow limit (3).");
            System.out.println("Borrow request denied for member "+borrower.getName()+".");
            return;
        }

        this.status = "Borrowed";
        this.returnDueDate = LocalDate.now().plusDays(14);
        this.currentBorrower = borrower;

        borrower.borrowItem();

        System.out.println("Item '"+title+"' has been checked out successfully.");
        System.out.println("Item '"+title+"' has been borrowed by "+borrower.getName()+".");
        System.out.println("Return Due Date: "+this.returnDueDate);
    }

    public void returnItem(){
        if (this.currentBorrower != null){
            this.currentBorrower.returnItem();
            this.currentBorrower = null;
        }

        this.status = "Available";
        this.returnDueDate = null;
        System.out.println("Item '"+title+"' has been returned successfully.");
    }

    public abstract void displayDetails();

    public double calculateLateFee(int daysLate){
        return 0.0;
    }
}
