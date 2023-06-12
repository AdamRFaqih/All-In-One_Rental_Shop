package Database;

import Item.Motor;
import Item.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements InterfaceDAO<Movie> {

    Connection connection;

    public MovieDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Movie object) throws SQLException {
        String itemsQuery = "INSERT INTO items (name, description, rental_charge_per_day, availability) VALUES (?, ?, ?, ?)";
        String movieQuery = "INSERT INTO movie_items (item_id, title, genre, release_year, director, condition) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement itemInsertStatement = connection.prepareStatement(itemsQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        itemInsertStatement.setString(1, object.getName());
        itemInsertStatement.setString(2, object.getDescription());
        itemInsertStatement.setDouble(3, object.getRentalChargePerDay());
        itemInsertStatement.setBoolean(4, object.isAvailbility());


        ResultSet generatedKeys = itemInsertStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int itemID = generatedKeys.getInt(1);


            PreparedStatement movieInsertStatement = connection.prepareStatement(movieQuery);
            movieInsertStatement.setInt(1, itemID);
            movieInsertStatement.setString(2, object.getTitle());
            movieInsertStatement.setString(3, object.getGenre());
            movieInsertStatement.setInt(4, object.getReleaseYear());
            movieInsertStatement.setString(5, object.getDirector());
            movieInsertStatement.setString(6, object.getCondition());


            movieInsertStatement.executeUpdate();

            connection.commit();
        } else {
            throw new SQLException("Failed to create a item.");
        }
    }

    @Override
    public List<Movie> readData() throws SQLException {
        String query = "SELECT * FROM items NATURAL JOIN motorcycle_items";
        PreparedStatement queryStatement = connection.prepareStatement(query);
        List<Movie> movies = new ArrayList<>();
        ResultSet res = queryStatement.executeQuery();
        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            String desc = res.getString("description");
            double charge = res.getDouble("rental_charge_per_day");
            boolean avail = res.getBoolean("availability");
            String title = res.getString("title");
            String genre = res.getString("genre");
            int year = res.getInt("release_year");
            String director = res.getString("director");
            String cond = res.getString("condition");

            Movie movie = new Movie(id, name, desc, charge, avail, title, genre, year, director, cond);
            movies.add(movie);

        }
        return movies;
    }

    @Override
    public void updateData(Movie object) throws SQLException {
        String updateItems = "UPDATE items SET name = ?, description = ?, rental_charge_per_day = ?, availability = ? WHERE id = ?";
        String updateMovie = "UPDATE movie_items SET title = ?, genre = ?, release_year = ?, director = ?, condition = ? WHERE item_id = ?";
        PreparedStatement itemsStatement = connection.prepareStatement(updateItems);
        PreparedStatement movieStatement = connection.prepareStatement(updateMovie);

        itemsStatement.setString(1, object.getName());
        itemsStatement.setString(2, object.getDescription());
        itemsStatement.setDouble(3, object.getRentalChargePerDay());
        itemsStatement.setBoolean(4, object.isAvailbility());
        itemsStatement.setInt(5, object.getItemID());

        movieStatement.setString(1, object.getTitle());
        movieStatement.setString(2, object.getGenre());
        movieStatement.setInt(3, object.getReleaseYear());
        movieStatement.setString(4, object.getDirector());
        movieStatement.setString(5, object.getCondition());
        movieStatement.setInt(6, object.getItemID());

        itemsStatement.executeUpdate();
        movieStatement.executeUpdate();

        connection.commit();
    }

    @Override
    public void deleteData(Movie object) throws SQLException {
        throw new RuntimeException("Method Not Used");
    }
}
