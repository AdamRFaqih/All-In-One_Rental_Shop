package User;


import Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private String phoneNumber;
    private String address;
    private List<Item> rentedItem;
    private String loyaltyType;
    private int numberBorrow;
    
    private double wallet;

    public Customer() {
        super(0, "", "", "", "customer");
        rentedItem = new ArrayList<Item>();
    }

    public Customer(String phoneNumber, String address, List<Item> rentedItem, String loyaltyType, int numberBorrow, double wallet) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentedItem = rentedItem;
        this.loyaltyType = loyaltyType;
        this.numberBorrow = numberBorrow;
        this.wallet = wallet;
    }

    public Customer(int userID, String name, String email, String password, String tipe) {
        super(userID, name, email, password, tipe);
        rentedItem = new ArrayList<Item>();
    }

    public Customer(
            int userID,
            String name,
            String email,
            String password,
            String tipe,
            String phoneNumber,
            String address,
            List<Item> rentedItem,
            String loyaltyType,
            int numberBorrow,
            double wallet) {
        super(userID, name, email, password, tipe);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentedItem = rentedItem;
        this.loyaltyType = loyaltyType;
        this.numberBorrow = numberBorrow;
        this.wallet = wallet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getRentedItem() {
        return rentedItem;
    }

    public void setRentedItem(List<Item> rentedItem) {
        this.rentedItem = rentedItem;
    }

    public String getLoyaltyType() {
        return loyaltyType;
    }

    public void setLoyaltyType(String loyaltyType) {
        this.loyaltyType = loyaltyType;
    }

    public int getNumberBorrow() {
        return numberBorrow;
    }

    public void setNumberBorrow(int numberBorrow) {
        this.numberBorrow = numberBorrow;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}
