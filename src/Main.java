import Database.CustomerDAO;
import Item.Game;
import Item.Item;
import User.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Game gow = new Game(123,"Game", "ini game",30.0,true,"God of War","RPG","Sony","good");
        Game gta = new Game(124,"Game", "ini game",30.0,true,"GTA","RPG","Rockstar","good");
        List<Item> rented = new ArrayList<>();
        rented.add(gow);
        rented.add(gta);
        Customer customer = new Customer(0,"adam","adam@gmail.com","123","customer","08129908482","sukabirus",rented,"Junior",0,0);
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createData(customer);


    }
}