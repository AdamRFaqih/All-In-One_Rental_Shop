package Database;

import Item.Movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MovieDAO implements InterfaceDAO<Movie> {

    Connection connection;

    public MovieDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Movie object) {

    }

    @Override
    public List<Movie> readData() {
        return null;
    }

    @Override
    public void updateData(Movie object) {

    }

    @Override
    public void deleteData(Movie object) throws SQLException {

    }
}
