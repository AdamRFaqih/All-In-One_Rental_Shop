import Database.CustomerDAO;
import Database.GameDAO;
import Database.ItemDAO;
import Item.Game;
import Item.Item;
import User.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Game gow = new Game(0,"Game", "ini game",30.0,true,"God of War","RPG","Sony","good");
        Game gta = new Game(0,"Game", "ini game",30.0,true,"GTA","RPG","Rockstar","good");
        GameDAO gameDAO = new GameDAO();
        gameDAO.createData(gow);
//        gameDAO.createData(gta);
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