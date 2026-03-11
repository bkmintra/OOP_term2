package com.library.lab4;

import com.library.lab4.DigitalContent;
import com.library.lab4.Taxable;

public class Ebook extends LibraryItem  implements DigitalContent, Taxable {
    private String downloadUrl;
    private double fileSize;

    public Ebook(String title, String author, String isbn, String downloadUrl, double fileSize){
        super(title,author,isbn);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
        this.price = 99.0;
    }

    @Override
    public void printSummary(){
        System.out.printf("Ebook [Title='%s', Size= '%.2f MB', Status='%s']\n", title, fileSize,status);
    }

    @Override
    public void displayDetails() {
        System.out.println("- Title: "+title);
        System.out.println("- ISBN: "+isbn);
        System.out.println("- Status: "+status);

        if("Available".equalsIgnoreCase(status)){
            System.out.println("- Return Due Date: N/A (E-book is available)");
        }else{
            System.out.println("- Return Due Date: "+returnDueDate);
        }
    }

    @Override
    public void streamOnline(){
        System.out.println("Streaming '"+title+"' from URL: "+downloadUrl);
        System.out.println("Starting online stream... connected!");
        System.out.println("You can now read the book online without downloading.");
    }

    @Override
    public void download(){
        System.out.println("Downloading '"+title+"' form URL: "+downloadUrl);
        System.out.printf("Downloading file... (%.2f MB)\n", fileSize);
        System.out.println("Download complete! File saved to your device.");
        System.out.println("You can now read the book offline.");
    }

    @Override
    public double calculateTax(){
        return this.price *0.05;
    }
}
