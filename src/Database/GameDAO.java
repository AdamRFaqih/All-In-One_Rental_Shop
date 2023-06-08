package Database;

import Item.Game;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GameDAO implements InterfaceDAO<Game> {

    Connection connection;

    public GameDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Game object) {

    }

    @Override
    public List<Game> readData() {
        return null;
    }

    @Override
    public void updateData(Game object) {

    }

    @Override
    public void deleteData(Game object) throws SQLException {

    }
}
