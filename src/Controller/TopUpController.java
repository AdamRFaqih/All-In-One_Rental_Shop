package Controller;


import Database.CustomerDAO;
import User.Customer;

import java.sql.SQLException;

public class TopUpController {
    public static void addBalance(Customer customer, double balance){
        CustomerDAO customerDAO = new CustomerDAO();
        double currentBalance = customer.getWallet();
        double newBalance = currentBalance + balance;
        customer.setWallet(newBalance);
        try {
            customerDAO.updateData(customer);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
