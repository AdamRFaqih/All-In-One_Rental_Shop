
import Application.Application;
import Database.CustomerDAO;
import Item.Game;
import Item.Item;
import Item.Mobil;
import User.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    public static void main(String[] args){
        CustomerDAO customerDAO = new CustomerDAO();
        
        ArrayList<Item> rentedItem = new ArrayList<Item>();
        rentedItem.add(new Mobil(
                300532,
                "Supra",
                "Mobil balap super cepat",
                2000000,
                true,
                "Toyota",
                "mk-3",
                2013,
                "bensin"
        ));
        rentedItem.add(new Game(
                720734,
                "PES2021",
                "game PES2021 full dlc",
                40000,
                true,
                "PES2021",
                "Soccer",
                "Konami",
                "full set"
        ));
        Customer customer = new Customer(
                200231,
                "Rahma Sakti",
                "rahmalover100@gmail.com",
                "inipassword",
                "normal",
                "081223344691",
                "Jl.Buah Batu no.3",
                null,
                "Bronze",
                0,
                0
        );
        System.out.println(rentedItem.size());
        customer.setRentedItem(rentedItem);
        
//        try {
//            customerDAO.createData(customer);
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Application.run();
    }
}