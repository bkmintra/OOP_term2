package com.library.lab3;

public class PhysicalBook extends LibraryItem{
    private double price;
    private String shelfLocation;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation){
        super(title, author, isbn);
        this.price = price;
        this.shelfLocation = shelfLocation;
    }

    public void printSummary(){
        System.out.println("PhysicalBook[ Title = ' "+title+" ', Location = '"+shelfLocation+" ', Status ="+ status +"'']");
    }

    @Override
    public void displayDetails(){
        System.out.println("PHYSICAL BOOK");
        System.out.println("- Title: "+title);
        System.out.println("- Author: "+author);
        System.out.println("- ISBN: "+ isbn);
        System.out.println("- Price: "+ price+" Baht");
        System.out.println("- Shelf Location: "+shelfLocation);
        System.out.println("- Status: "+ status);

        if ("Available".equalsIgnoreCase(status)){
            System.out.println("- Return Due Date: N/A (Book is available)");
        }else{
            System.out.println("- Return Due Date: "+returnDueDate);
        }
    }

    @Override
    public double calculateLateFee(int daysLate){
        return daysLate*5.0;
    }

}
