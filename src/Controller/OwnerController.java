package Controller;

import Application.Application;
import Database.OwnerDAO;
import Item.*;
import JGUI.OwnerMainViewNew;
import User.Owner;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerController {
    OwnerMainViewNew ownerMainViewNew;
    public void setOwnerMainView(OwnerMainViewNew ownerMainViewNew){
        this.ownerMainViewNew = ownerMainViewNew;
    }
    public static Owner getOwner(){
        return ((Owner) Application.getAccount());
    }
    public void SetItemList(Owner owner){
        List<String> name = new ArrayList<>();
        List<Item> items = owner.getItemRented();
        for (int i = 0; i < items.size(); i++){
            if (items.get(i) instanceof Game){
                name.add(items.get(i).getItemID() + " - " + ((Game) items.get(i)).getTitle() + " - " + items.get(i).isAvailbility());
            } else if (items.get(i) instanceof Movie) {
                name.add(items.get(i).getItemID() + " - " +((Movie) items.get(i)).getTitle() + " - " + items.get(i).isAvailbility());
            } else if (items.get(i) instanceof Motor) {
                name.add(items.get(i).getItemID() + " - " +((Motor) items.get(i)).getModel() + " - " + items.get(i).isAvailbility());
            } else if (items.get(i) instanceof Mobil) {
                name.add(items.get(i).getItemID() + " - " +((Mobil) items.get(i)).getModel() + " - " + items.get(i).isAvailbility());
            }
        }
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String itemName : name) {
            listModel.addElement(itemName);
        }
        ownerMainViewNew.setjList1(listModel);
    }

    public Owner refresh(Owner oldOwner) throws SQLException {
        OwnerDAO ownerDAO = new OwnerDAO();
        List<Owner> owners = ownerDAO.readData();
        Owner newOwner = owners.stream().filter(id -> id.getUserID() == oldOwner.getUserID()).findFirst().orElse(null);
        return newOwner;
    }

    public boolean validateItemExist(Owner owner, int id){
        List<Item> items = owner.getItemRented();
        Item item = items.stream().filter(itemId -> itemId.getItemID() == id).findFirst().orElse(null);
        return item != null;
    }

    public Item searchItem(Owner owner, int id){
        List<Item> items = owner.getItemRented();
        return items.stream().filter(itemId -> itemId.getItemID() == id).findFirst().orElse(null);
    }
}
