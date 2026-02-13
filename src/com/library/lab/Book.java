package com.library.lab;

import java.time.LocalDate;


public class Book {
    private String title;

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

    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDueDate;
    private Member current;

    public Book(String title, String author, String isbn, double price, String status){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
    }

    public void displayDetails(){
        System.out.println("Book[Title = ']"+ title + "', Status = '"+ status + "']");
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
        this.current = borrower;

        borrower.borrowBook();

        System.out.println("Book '"+title+"' has been checked out successfully.");
        System.out.println("Book "+title+" has been borrowed by "+borrower.getName()+".");
        System.out.println("Return Due Date: "+this.returnDueDate);
    }

    public void returnBook(){
        if (this.current != null){
            this.current.returnBook();
            this.current = null;
        }

        this.status = "Available";
        this.returnDueDate = null;
        System.out.println("Book '"+title+"' has been returned succesfully.");
    }
}
