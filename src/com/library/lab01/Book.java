package com.library.lab01;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;

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

    private LocalDate returnDueDate;



    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public Book(String title, String author, String isbn, double price, String status){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
    }

    public void displayDetails(){
        System.out.println("- Title : "+ title);
        System.out.println("- Author : "+ author);
        System.out.println("- ISBN : "+ isbn);
        System.out.println("- Price :"+ price);
        System.out.println("- Status : "+status);
        System.out.println("- Return Due Date : "+ returnDueDate);
    }

    public void checkOut(){
        if ("Borrowed".equalsIgnoreCase(this.status)) {
            System.out.println("Error: Book '"+this.title+"' is already borrowed and cannot be checked out again.");
        }

        this.status = "Borrowed";
        this.returnDueDate = LocalDate.now().plusDays(14);
        System.out.println("Book '"+title+"' has been checked out successfully.");
        System.out.println("Return Due Date: "+this.returnDueDate);
    }

    public void returnBook(){
        System.out.println("Book '"+title+"' has been returned succesfully.");
    }
}
