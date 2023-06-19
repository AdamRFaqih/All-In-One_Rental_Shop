package Controller;

import Database.GameDAO;
import Database.MobilDAO;
import Database.MotorDAO;
import Database.MovieDAO;
import Item.*;

import java.sql.SQLException;

public class EditItemController<T> {
    T editForm;
    public void setEditForm(T editForm){
        this.editForm =editForm;
    }

    public void updateEditedItem(Item item) throws SQLException {
        if (item instanceof Game){
            GameDAO gameDAO = new GameDAO();
            gameDAO.updateData(((Game) item));
        } else if (item instanceof Mobil) {
            MobilDAO mobilDAO = new MobilDAO();
            mobilDAO.updateData(((Mobil) item));
        } else if (item instanceof Motor) {
            MotorDAO motorDAO = new MotorDAO();
            motorDAO.updateData(((Motor) item));
        } else if (item instanceof Movie) {
            MovieDAO movieDAO = new MovieDAO();
            movieDAO.updateData(((Movie) item));
        }
    }
}
