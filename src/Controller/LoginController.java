/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.CustomerDAO;
import Database.OwnerDAO;
import Item.Item;
import JGUI.CustomerManageView;
import User.Customer;
import User.Owner;
import User.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahma
 */
public class LoginController {
    public static Customer getCustomer(User Account){
        return getCustomers().stream()
                .filter(customer -> customer.getUserID() == Account.getUserID())
                .findFirst().orElse(null);
    }
    public static Owner getOwner(User Account){
        return getOwners().stream()
                .filter(owner -> owner.getUserID() == Account.getUserID())
                .findFirst().orElse(null);
    }
    public static ArrayList<Customer> getCustomers(){
        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<Customer> customers = new ArrayList<Customer>(); 
        try {
            customers = (ArrayList<Customer>)customerDAO.readData();
        } 
        catch (SQLException ex) {
            Logger.getLogger(CustomerManageView.class.getName()).log(Level.SEVERE, null, ex);
            return customers;
        }
        ArrayList<Customer> tempCustomer = (ArrayList<Customer>)customers.clone();
        for(Customer customer : customers){
            System.out.println("["+customer.getUserName()+" : "+customer.getPassword()+"]");
        }
        return customers;
    }
    public static ArrayList<Owner> getOwners(){
        OwnerDAO ownerDAO = new OwnerDAO();
        ArrayList<Owner> owners = new ArrayList<Owner>(); 
        try {
            owners = (ArrayList<Owner>)ownerDAO.readData();
        } 
        catch (SQLException ex) {
            Logger.getLogger(CustomerManageView.class.getName()).log(Level.SEVERE, null, ex);
            return owners;
        }
        ArrayList<Customer> tempOwner = (ArrayList<Customer>)owners.clone();
        for(Owner owner : owners){
            System.out.println("["+owner.getUserName()+" : "+owner.getPassword()+"]");
        }
        return owners;
    }
    public static User LoginUser(String username, String password){
        Customer _user = getCustomers().stream()
                .filter(user -> 
                        user.getUserName().equals(username) && 
                        user.getPassword().equals(password))
                .findFirst().orElse(null);
        if(_user == null){return null;}
        ArrayList<Item> rentedItem = new ArrayList<Item>();
        _user.setRentedItem(rentedItem);
        return _user;
    }
    public static void customerRegister(String username, String password) throws SQLException{
        Customer customer = new Customer(); 
        customer.setUserName(username);
        customer.setPassword(password);
        
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createData(customer);
        
    }
    public static void ownerRegister(String username, String password) throws SQLException{
        Owner owner = new Owner(); 
        owner.setUserName(username);
        owner.setPassword(password);
        
        OwnerDAO ownerDAO = new OwnerDAO();
        ownerDAO.createData(owner);
    }
}
