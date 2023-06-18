/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Item.Item;
import JGUI.CustomerMainView;
import User.Owner;
import java.util.ArrayList;

/**
 *
 * @author rahma
 */
public class CustomerMainController {
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
}
