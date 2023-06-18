/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Item.*;
import User.Owner;
import java.util.ArrayList;

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
    public static ArrayList<Item> SearchItem(String keyword, int count){
        ArrayList<Owner> owners = Application.Application.getOwners();
        ArrayList<Item> items = new ArrayList<Item>();
        
        int index = 0;
        for (Owner owner : owners){
            for (Item item : owner.getItemRented()){
                boolean validName =  item.getName().equals(keyword);
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
                
                if (validName || validProductAttribut){
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
