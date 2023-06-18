import Database.CustomerDAO;
import Database.GameDAO;
import Database.ItemDAO;
import Database.OwnerDAO;
import Item.*;
import User.Customer;
import User.Owner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        OwnerDAO ownerDAO = new OwnerDAO();
        List<Owner> owners = ownerDAO.readData();
        Owner kamal = owners.stream().filter(idOwner -> idOwner.getUserID() == 41).findFirst().orElse(null);
        List<Item> items = new ArrayList<>();
        items.add(itemToAdd(16));
        items.add(itemToAdd(17));
        items.add(itemToAdd(18));
        kamal.setItemRented(items);
        ownerDAO.updateData(kamal);

//        CustomerDAO customerDAO = new CustomerDAO();
//        List<Customer> customers = customerDAO.readData();
//        for (int i = 0; i < customers.size(); i++){
//            System.out.println(customers.get(i).getUserName());
//            for (int j = 0; j < customers.get(i).getRentedItem().size(); i++){
//                System.out.println(customers.get(i).getRentedItem().get(j).getName());
//            }
//        }
    }

    public static Item itemToAdd(int id) throws SQLException {
        ItemDAO itemDAO = new ItemDAO();
        List<Item> items = itemDAO.readData();
        Item itemToAdd = items.stream().filter(idItem -> idItem.getItemID() == id).findFirst().orElse(null);
        return itemToAdd;
    }
}