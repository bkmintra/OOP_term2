package com.library.lab4;

import com.library.lab4.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("   LIBRARY MANAGEMENT SYSTEM - POLYMORPHISM DEMO");
        System.out.println("=".repeat(60));

        List<LibraryItem> items = new ArrayList<>();

        items.add(new PhysicalBook("Java Programming", "John Smith", "978-0134685991", 450.0, "A1-04"));
        items.add(new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 590.0, "B2-15"));
        items.add(new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612", 680.0, "A3-22"));

        items.add(new Ebook("Effective Java", "Joshua Bloch", "978-0134685991", "https://library.ebooks.com/effective-java.pdf", 5.2));
        items.add(new Ebook("Python Crash Course", "Eric Matthes", "978-1593279288", "https://library.ebooks.com/python-crash.pdf", 8.7));

        Member member1 = new Member("M001", "Somsak");
        Member member2 = new Member("M002", "Suda");

        System.out.println("\n--- ALL LIBRARY ITEMS (Polymorphism Demo)---");
        System.out.println("Calling displayDetails() on each item in the list:");
        System.out.println();
        for (LibraryItem item : items) {
            item.displayDetails();
            System.out.println();

        }

        System.out.println("\n--- TESTING CHECKOUT FUNCTIONALITY ---");

        System.out.println("\nMember Somsak borrows Physical Book: ");
        items.get(0).checkOut(member1);

        System.out.println("\nMember Suda borrows E-Book: ");
        items.get(1).checkOut(member2);

        System.out.println("\nAttempting to checkout an already borrowed item: ");
        items.get(0).checkOut(member2);

        System.out.println("\n--- ITEMS STATUS AFTER CHECKOUT ---");
        for (LibraryItem item: items) {
            item.printSummary();
        }

        System.out.println("\n--- TESTING RETURN FUNCTIONALITY ---");
        System.out.println("\nReturning Physical Book:");
        items.get(0).returnItem();

        System.out.println("\n--- TESTING BORROW LIMIT ---");
        items.get(0).checkOut(member1);
        items.get(1).checkOut(member1);
        items.get(2).checkOut(member1);
        items.get(3).checkOut(member1);

        System.out.println("\n" + "=".repeat(60));
        System.out.println(" METHOD OVERRIDING: LATE FEE CALCULATION DEMO");
        System.out.println("=".repeat(60));

        int daysLate = 5;
        System.out.println("\n--- Late Fee Calculation (" + daysLate + " days late) ---");
        System.out.println("\nPhysical Books (5 Bath per day late fee):");
        for (LibraryItem item : items) {
            double lateFee = item.calculateLateFee(daysLate);
            System.out.printf("%s: %.2f Baht\n", item.getTitle(), lateFee);
        }

        System.out.println();
        System.out.println("\n"+"=".repeat(60));
        System.out.println("INTERFACE IMPLEMENTATION: DIGITAL CONTENT & TAXABLE DEMO");
        System.out.println("\n"+"=".repeat(60));
        System.out.println();
        System.out.println("--- DIGITAL CONTENT INTERFACE ---");
        System.out.println("Processing Digital Content for EBooks (DigitalContent interface): ");
        System.out.println("Note: Only EBook implement DigitalContent, PhysicalBook do NOT.\n");
        for(LibraryItem item: items){
            if (item instanceof DigitalContent){
                DigitalContent digitalBook = (DigitalContent) item;
                System.out.println("Processing EBook: "+item.getTitle());
                launchStreamingPlayer(digitalBook);
            }
        }
        System.out.println();

        System.out.println("--- TAXABLE INTERFACE ---");
        System.out.println("Processing Tax Calculation (Taxable interface): ");
        System.out.println("Both EBooks and PhysicalBooks implement Taxable.\n");
        System.out.println("Tax Calculation foe physical Book (7% tax) and E-Books (5% digital tax): ");
        for(LibraryItem item: items){
            Taxable taxableItem = (Taxable) item;
            double tax = taxableItem.calculateTax();
            System.out.printf("%s: Price = %.2f Baht, Tax = %.2f Baht, Total = %.2f Baht\n ", item.getTitle(), item.getPrice(), tax,item.getPrice()+tax) ;
        }
    }

    public static void launchStreamingPlayer(DigitalContent content){
        System.out.println("Connecting to Streaming service...");
        System.out.println("Loading content...");
        content.streamOnline();
        System.out.println("User requests offline copy");
        content.download();
    }
}