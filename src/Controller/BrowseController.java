/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.OwnerDAO;
import Item.*;
import User.Owner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahma
 */
public class BrowseController {
    public static ArrayList<Item> generateRecomendationItem(int count){
        ArrayList<Owner> owners = Application.Application.getOwners();
        ArrayList<Item> items = new ArrayList<Item>();
        
        int index = 0;
        for (Owner owner : owners){
            for (Item item : owner.getItemRented()){
                items.add(item);
                index++;
                if(index >= count){
                    return items;
                }
            }
        }
        return items;
    }
    public static boolean SearchItem(Item item) throws SQLException{
        OwnerDAO ownerDAO = new OwnerDAO();
        ArrayList<Owner> owners = (ArrayList<Owner>) ownerDAO.readData();
        for (Owner owner : owners){
            for (Item itemI : owner.getItemRented()){
                if (itemI.getItemID() == item.getItemID()){
                    return true;
                }
            }
        }
        return false;
    }
    public static ArrayList<Item> SearchItem(String keyword, int count, Date startDate, Date endDate){
        ArrayList<Owner> owners = Application.Application.getOwners();
        ArrayList<Item> items = new ArrayList<Item>();
        
        int index = 0;
        for (Owner owner : owners){
            for (Item item : owner.getItemRented()){
                boolean validName =  item.getName().equals(keyword);
                boolean available = false;
                try {
                    available = item.isAvailbility(startDate, endDate);
                } catch (SQLException ex) {
                    Logger.getLogger(BrowseController.class.getName()).log(Level.SEVERE, null, ex);
                }
                boolean validProductAttribut = false;
                
                switch (item.toString()){
                    case "class Item.Mobil":
                        // Do in case mobil
                        Mobil mobil = (Mobil) item;
                        validProductAttribut = 
                                mobil.getPabrikan() == keyword ||
                                mobil.getModel() == keyword
                                ;
                        break;
                    case "class Item.Game":
                        // Do in case Game
                        Game game = (Game) item;
                        validProductAttribut = 
                                game.getTitle() == keyword ||
                                game.getPublisher() == keyword ||
                                game.getGenre() == keyword
                                ;
                        break;
                    case "class Item.Motor":
                        // Do in case Motor
                        Motor motor = (Motor) item;
                        validProductAttribut =
                                motor.getModel() == keyword ||
                                motor.getPabrikan() == keyword
                                ;
                        break;
                    case "class Item.Movie":
                        // Do in case Movie
                        Movie movie = (Movie) item;
                        validProductAttribut = 
                                movie.getTitle() == keyword ||
                                movie.getGenre() == keyword ||
                                movie.getDirector() == keyword
                                ;
                        break;
                }
                
                if ((validName || validProductAttribut) && available){
                    items.add(item);
                    index++;
                }
                if(index >= count){
                    return items;
                }
            }
        }
        return items;
    }
}
