package User;

import Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User {
    private String shopName;
    private String location;
    private List<Item> itemRented;

    public Owner() {
        super(0, "", "", "", "owner");
        itemRented = new ArrayList<Item>();
    }

    public Owner(int userID, String name, String email, String password, String tipe) {
        super(userID, name, email, password, tipe);
        itemRented = new ArrayList<Item>();
    }

    public Owner(String shopName, String location, List<Item> itemRented) {
        this.shopName = shopName;
        this.location = location;
        this.itemRented = itemRented;
    }

    public Owner(int userID, String name, String email, String password, String tipe, String shopName, String location, List<Item> itemRented) {
        super(userID, name, email, password, tipe);
        this.shopName = shopName;
        this.location = location;
        this.itemRented = itemRented;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Item> getItemRented() {
        return itemRented;
    }

    public void setItemRented(List<Item> itemRented) {
        this.itemRented = itemRented;
    }
}