package com.library.lab5;

public class EBook extends LibraryItem{
    private String downloadUrl;
    private double fileSize;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
        this.price = 99.0;
    }

    @Override
    public void printSummary() {
        System.out.printf("EBook[Title='%s', Size='%.2f MB', Status='%s']\n", title, fileSize, status);
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK: " + title);
    }
}
