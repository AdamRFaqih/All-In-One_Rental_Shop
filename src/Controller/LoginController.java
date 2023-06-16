/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.CustomerDAO;
import Item.Game;
import Item.Item;
import Item.Mobil;
import JGUI.CustomerManageView;
import User.Customer;
import User.User;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahma
 */
public class LoginController {
    private static ArrayList<Customer> getCustomers(){
        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<Customer> customers = null; 
        try {
            customers = (ArrayList<Customer>)customerDAO.readData();
        } 
        catch (SQLException ex) {
            Logger.getLogger(CustomerManageView.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        ArrayList<Customer> tempCustomer = (ArrayList<Customer>)customers.clone();
        for(Customer customer : customers){
            System.out.println("["+customer.getUserName()+" : "+customer.getPassword()+"]");
        }
        return customers;
    }
    public static User LoginUser(String username, String password){
        Customer _user = getCustomers().stream()
                .filter(user -> 
                        user.getUserName().equals(username) && 
                        user.getPassword().equals(password))
                .findFirst().orElse(null);
        
//        ArrayList<Item> rentedItem = new ArrayList<Item>();
//        rentedItem.add(new Mobil(
//                300532,
//                "Supra",
//                "Mobil balap super cepat",
//                2000000,
//                true,
//                "Toyota",
//                "mk-3",
//                2013,
//                "bensin"
//        ));
//        rentedItem.add(new Game(
//                720734,
//                "PES2021",
//                "game PES2021 full dlc",
//                40000,
//                true,
//                "PES2021",
//                "Soccer",
//                "Konami",
//                "full set"
//        ));
//        _user.setRentedItem(rentedItem);
        return _user;
    }
}
