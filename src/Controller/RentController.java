/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.CustomerDAO;
import Database.ItemDAO;
import Database.TransactionDAO;
import Item.Item;
import Transaction.Transaction;
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
    public static boolean ValidatingTransaction(Customer Account, Item item, Date startDate, Date endDate){
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
        return isAccountValid && isItemValid;
        
    }
    
    public static boolean rent(Customer Account, Item item, Date startDate, Date endDate) throws SQLException{
        if(ValidatingTransaction(Account, item, startDate, endDate)){
            Account.setWallet(Account.getWallet() - item.getRentalChargePerDay());
            item.setAvailbility(false);
            Account.getRentedItem().add(item);
            
//            new TransactionDAO().createData(new Transaction(
//                    0,Account.getUserID(),item.getItemID(),(java.sql.Date) startDate,(java.sql.Date) endDate,null,
//                    GenerateTotalPayment(item,GenerateDayOfRent(startDate,endDate)))
//            );
//            new ItemDAO().updateData(item);
//            new CustomerDAO().updateData(Account);
            System.out.println("Rent berhasil");
            return true;
        }
        else{
            System.out.println("Rent Gagal "+BrowseController.SearchItem(item));
            return false;
        }
    }
    public static int GenerateDayOfRent(Date startDate, Date endDate){
        return startDate.compareTo(endDate);
    }
    public static double GenerateTotalPayment(Item item, int dayOfRent){
        return item.getRentalChargePerDay() * dayOfRent;
    }
}
