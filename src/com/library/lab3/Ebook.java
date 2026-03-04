package com.library.lab3;

public class Ebook extends LibraryItem {
    private String downloadUrl;
    private double fileSize;

    public Ebook(String title, String author, String isbn, String downloadUrl, double fileSize){
        super(title,author,isbn);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        System.out.println("- Title: "+title);
        System.out.println("- Author: "+author);
        System.out.println("- ISBN: "+isbn);
        System.out.println("- Download URL: "+downloadUrl);
        System.out.println("- File Size: "+fileSize+"MB");
        System.out.println("- Status: "+status);

        if("Available".equalsIgnoreCase(status)){
            System.out.println("- Return Due Date: N/A (E-book is available)");
        }else{
            System.out.println("- Return Due Date: "+returnDueDate);
        }
    }

    @Override
    public double calculateLateFee(int daysLate){
        return 0.0;
    }
}
