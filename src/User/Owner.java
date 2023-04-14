package User;

import Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User{
    private String shopName;
    private String location;
    private List<Item> itemRented;

    public List<Item> getItemRented() {
        return itemRented;
    }

    public Owner(
            int userID,
            String name,
            String email,
            String password,
            String tipe,
            String shopName,
            String location
    ) {
        super(userID, name, email, password, tipe);
        this.shopName = shopName;
        this.location = location;
        itemRented = new ArrayList<>();
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

    @Override
    public void login() {
        System.out.println("Owner Login");
    }

    @Override
    public void logout() {
        System.out.println("Owner Logout");
    }

    public void addItem(Item item){
        itemRented.add(item);
    }

    public void removeItem(Item item){
        itemRented.remove(item);
    }

    public void viewItemList(){
        System.out.println("Item List in Shop: ");
        for (Item item : itemRented){
            System.out.println(item.getName());
        }
    }
    
    public void viewItemList(int format){
        System.out.println("Item List in Shop: ");
        int index = 1;
        for (Item item : itemRented){
            if (format == 1){
                System.out.print((index++) + ". ");
            }
            System.out.println(item.getName());
        }
    }
    
}
