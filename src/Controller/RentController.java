/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Item.Item;
import User.Customer;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahma
 */
public class RentController {
    public static boolean rent(Customer Account, Item item, Date startDate, Date endDate){
        boolean isAccountValid = false;
        boolean isItemValid = false;
        
        try {
            isAccountValid =
                LoginController.getCustomer(Account) != null &&
                Account.getWallet() >= item.getRentalChargePerDay() * startDate.compareTo(endDate);
            isItemValid =
                    BrowseController.SearchItem(item) &&
                    item.isAvailbility(startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(RentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(isAccountValid && isItemValid){
            Account.setWallet(Account.getWallet() - item.getRentalChargePerDay());
            Account.getRentedItem().add(item);
            return true;
        }
        else{
            return false;
        }
    }
}
