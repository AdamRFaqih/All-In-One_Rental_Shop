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
    
    private long wallet;
    
    public Customer(
            int userID,
            String name,
            String email,
            String password,
            String tipe,
            String phoneNumber,
            String address
    ) {
        super(userID, name, email, password, tipe);
        this.phoneNumber = phoneNumber;
        this.address = address;
        rentedItem = new ArrayList<>();
        loyaltyType = "New Member";
        numberBorrow = 0;
        wallet = 0;
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

    @Override
    public void login() {
        System.out.println("Customer Login");
    }

    @Override
    public void logout() {
        System.out.println("Customer Logout");
    }

    public void rentItem(Item item){
        this.wallet -= item.getRentalCharge();
        rentedItem.add(item);
    }

    public void returnItem(Item item){
        rentedItem.remove(item);
        numberBorrow++;
        if (numberBorrow > 10){
            System.out.println("Loyalty member upgraded to Veteran");
            loyaltyType = "Veteran";
        }
    }

    public List<Item> getRentedItem() {
        return rentedItem;
    }

    public void viewRentedItem(){
        System.out.println("Rented Item: ");
        for (Item item : rentedItem){
            System.out.println(item.getName());
        }
    }
    
    public void viewRentedItem(int format){
        System.out.println("Item List in Shop: ");
        int index = 1;
        for (Item item : this.rentedItem){
            if (format == 1){
                System.out.print((index++) + ". ");
            }
            System.out.println(item.getName());
        }
    }
    
    public void topUp(long amount){
        this.wallet += amount;
    }

    public long getWallet() {
        return wallet;
    }
}
