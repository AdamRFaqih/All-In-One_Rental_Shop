package Database;

import Item.Game;
import Item.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements InterfaceDAO<Game> {

    Connection connection;

    public GameDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Game object) throws SQLException {
        String itemsQuery = "INSERT INTO items (name, description, rental_charge_per_day, availability) VALUES (?, ?, ?, ?)";
        String gameQuery = "INSERT INTO game_items (item_id, title, genre, publisher, condition) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement itemInsertStatement = connection.prepareStatement(itemsQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        itemInsertStatement.setString(1, object.getName());
        itemInsertStatement.setString(2, object.getDescription());
        itemInsertStatement.setDouble(3, object.getRentalChargePerDay());
        itemInsertStatement.setBoolean(4, object.isAvailbility());

        itemInsertStatement.executeUpdate();
        ResultSet generatedKeys = itemInsertStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int itemID = generatedKeys.getInt(1);


            PreparedStatement gameInsertStatement = connection.prepareStatement(gameQuery);
            gameInsertStatement.setInt(1, itemID);
            gameInsertStatement.setString(2, object.getTitle());
            gameInsertStatement.setString(3, object.getGenre());
            gameInsertStatement.setString(4, object.getPublisher());
            gameInsertStatement.setString(5, object.getCondition());


            gameInsertStatement.executeUpdate();

            connection.commit();
        } else {
            throw new SQLException("Failed to create a item.");
        }
    }

    @Override
    public List<Game> readData() throws SQLException {
        String query = "select i.*, gi.* from items i join game_items gi on i.id = gi.item_id";
        PreparedStatement queryStatement = connection.prepareStatement(query);
        List<Game> games = new ArrayList<>();
        ResultSet res = queryStatement.executeQuery();
        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            String desc = res.getString("description");
            double charge = res.getDouble("rental_charge_per_day");
            boolean avail = res.getBoolean("availability");
            String title = res.getString("title");
            String genre = res.getString("genre");
            String pub = res.getString("publisher");
            String cond = res.getString("condition");

            Game game = new Game(id, name, desc, charge,avail, title, genre, pub, cond);
            games.add(game);

        }
        return games;
    }

    @Override
    public void updateData(Game object) throws SQLException {
        String updateItems = "UPDATE items SET name = ?, description = ?, rental_charge_per_day = ?, availability = ? WHERE id = ?";
        String updateGame = "UPDATE game_items SET title = ?, genre = ?, publisher = ?, condition = ? WHERE item_id = ?";
        PreparedStatement itemsStatement = connection.prepareStatement(updateItems);
        PreparedStatement gameStatement = connection.prepareStatement(updateGame);

        itemsStatement.setString(1, object.getName());
        itemsStatement.setString(2, object.getDescription());
        itemsStatement.setDouble(3, object.getRentalChargePerDay());
        itemsStatement.setBoolean(4, object.isAvailbility());
        itemsStatement.setInt(5, object.getItemID());

        gameStatement.setString(1, object.getTitle());
        gameStatement.setString(2, object.getGenre());
        gameStatement.setString(3, object.getPublisher());
        gameStatement.setString(4, object.getCondition());
        gameStatement.setInt(5, object.getItemID());

        itemsStatement.executeUpdate();
        gameStatement.executeUpdate();

        connection.commit();
    }

    @Override
    public void deleteData(Game object) throws SQLException {
        throw new RuntimeException("Method Not Used");
    }
}
