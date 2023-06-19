package Controller;

import Database.*;
import Item.*;
import User.Owner;

import java.sql.SQLException;
import java.util.List;

public class AddItemController<T>{
    Owner owner;
    T addForm;
    public void setAddController(T form){
        this.addForm = form;
    }

    public void addItem(Owner owner, Item item) throws SQLException {
        int itemID;
        if (item instanceof Game){
            GameDAO gameDAO = new GameDAO();
            itemID = gameDAO.createData(((Game) item));
            item.setItemID(itemID);
        } else if (item instanceof Mobil) {
            MobilDAO mobilDAO = new MobilDAO();
            itemID = mobilDAO.createData(((Mobil) item));
            item.setItemID(itemID);
        } else if (item instanceof Motor) {
            MotorDAO motorDAO = new MotorDAO();
            itemID = motorDAO.createData(((Motor) item));
            item.setItemID(itemID);
        } else if (item instanceof Movie) {
            MovieDAO movieDAO = new MovieDAO();
            itemID = movieDAO.createData(((Movie) item));
            item.setItemID(itemID);
        }
        List<Item> items = owner.getItemRented();
        items.add(item);
        owner.setItemRented(items);
        OwnerDAO ownerDAO = new OwnerDAO();
        ownerDAO.updateData(owner);
    }
}

