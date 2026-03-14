package com.library.lab5;

import java.time.LocalDate;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String isbn;
    protected double price;
    protected String status;
    protected LocalDate returnDueDate;
    protected Member currentBorrower;

    public LibraryItem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = "Available";
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }


    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(status);
    }

    public void checkOut(Member borrower) {
        if (!isAvailable()) {
            System.out.println("Error: Item '" + this.title + "' is already borrowed.");
            return;
        }

        if (!borrower.canBorrow()) {
            String limitStr = borrower.getMembershipStrategy().hasUnlimitedBorrowing() ? "Unlimited" : String.valueOf(borrower.getMembershipStrategy().getBorrowLimit());
            System.out.println("Member " + borrower.getName() + " has reached the borrow limit (" + limitStr + ") for " + borrower.getMembershipStrategy().getMembershipType() + ".");
            System.out.println("Borrow request denied for member " + borrower.getName() + ".");
            return;
        }

        this.status = "Borrowed";

        int loanDays = borrower.getMembershipStrategy().getLoanPeriodDays();
        this.returnDueDate = LocalDate.now().plusDays(loanDays);
        this.currentBorrower = borrower;

        borrower.borrowItem();

        System.out.println("Item '" + title + "' has been checked out successfully.");
        System.out.println("Borrowed by " + borrower.getName() + " (" + borrower.getMembershipStrategy().getMembershipType() + ")");
        System.out.println("Loan Period: " + loanDays + " days");
        System.out.println("Return Due Date: " + this.returnDueDate);
    }

    public void returnItem() {
        if (this.currentBorrower != null) {
            this.currentBorrower.returnItem();
            this.currentBorrower = null;
        }
        this.status = "Available";
        this.returnDueDate = null;
        System.out.println("Item '" + title + "' has been returned successfully.");
    }

    public abstract void displayDetails();
    public abstract void printSummary();

    public double calculateLateFee(int daysLate) {
        return 0.0;
    }
}