package com.library.lab5;

public class Member {
    private String memberId;
    private String name;
    private int itemsBorrowed;
    private MembershipStrategy membershipStrategy;

    public Member(String memberId, String name, MembershipStrategy strategy) {
        this.memberId = memberId;
        this.name = name;
        this.membershipStrategy = strategy;
        this.itemsBorrowed = 0;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getItemsBorrowed() { return itemsBorrowed; }
    public MembershipStrategy getMembershipStrategy() { return membershipStrategy; }


    public void setMembershipStrategy(MembershipStrategy strategy) {
        this.membershipStrategy = strategy;
    }


    public boolean canBorrow() {
        if (membershipStrategy.hasUnlimitedBorrowing()) return true;
        return itemsBorrowed < membershipStrategy.getBorrowLimit();
    }

    public void borrowItem() {
        if (canBorrow()) {
            this.itemsBorrowed++;
        }
    }

    public void returnItem() {
        if (this.itemsBorrowed > 0) {
            this.itemsBorrowed--;
        }
    }


    public double calculateLateFee(double baseFee) {
        return membershipStrategy.applyLateFeeDiscount(baseFee);
    }

    public void displayMemberInfo() {
        System.out.println("--- MEMBER INFORMATION ---");
        System.out.println("ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Membership Type: " + membershipStrategy.getMembershipType());
        System.out.println("Membership Cost: " + membershipStrategy.getMembershipCost() + " Baht");

        String limit = membershipStrategy.hasUnlimitedBorrowing() ? "Unlimited" : String.valueOf(membershipStrategy.getBorrowLimit());
        System.out.println("Borrow Limit: " + limit);
        System.out.println("Currently Borrowed: " + itemsBorrowed);
        System.out.println("Loan Period: " + membershipStrategy.getLoanPeriodDays() + " days");
    }
}
