package com.library.lab5;

public class PhysicalBook extends LibraryItem{
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn);
        this.price = price;
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void printSummary() {
        System.out.println("PhysicalBook[Title='" + title + "', Location='" + shelfLocation + "', Status='" + status + "']");
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK: " + title);
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 5.0;
    }
}
