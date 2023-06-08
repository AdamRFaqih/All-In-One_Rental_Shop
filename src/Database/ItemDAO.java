package Database;

import Item.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements InterfaceDAO<Item> {

    Connection connection;

    public ItemDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Item object) throws SQLException {

    }

    @Override
    public List<Item> readData() throws SQLException {
        GameDAO gameDAO = new GameDAO();
        MobilDAO mobilDAO = new MobilDAO();
        MotorDAO motorDAO = new MotorDAO();
        MovieDAO movieDAO = new MovieDAO();
        List<Item> allItem = new ArrayList<>();
        allItem.addAll(gameDAO.readData());
        allItem.addAll(mobilDAO.readData());
        allItem.addAll(motorDAO.readData());
        allItem.addAll(movieDAO.readData());
        return allItem;
    }

    @Override
    public void updateData(Item object) throws SQLException {

    }

    @Override
    public void deleteData(Item object) throws SQLException {

    }
}
