import Database.CustomerDAO;

import Item.Game;
import Item.Item;
import Item.Mobil;
import User.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args)throws SQLException{
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
        
//        MobilDAO mobilDAO = new MobilDAO();
//        try {
//            mobilDAO.createData(new Mobil(
//                    300532,
//                    "Supra",
//                    "Mobil balap super cepat",
//                    2000000,
//                    true,
//                    "Toyota",
//                    "mk-3",
//                    2013,
//                    "bensin"
//            ));
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        try {
//            customerDAO.createData(customer);
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

//        Game gow = new Game(0,"Game", "ini game",30.0,true,"God of War","RPG","Sony","good");
//        Game gta = new Game(0,"Game", "ini game",30.0,true,"GTA","RPG","Rockstar","good");
//        GameDAO gameDAO = new GameDAO();
//        try {
//            gameDAO.createData(gow);
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        gameDAO.createData(gta);
//        List<Item> rented = new ArrayList<>();
//        rented.add(gow);
//        Customer customer = new Customer(0,"adam","adam@gmail.com","123","customer","08129908482","sukabirus",rented,"Junior",0,0);
//        CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.createData(customer);
//        List<Customer> customers = customerDAO.readData();
//        for (int i = 0; i < customers.size(); i++){
//            System.out.println(customers.get(i));

//        }
       Application.Application.run();

    }
}