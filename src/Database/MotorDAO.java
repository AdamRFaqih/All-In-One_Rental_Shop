package Database;

import Item.Motor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorDAO implements InterfaceDAO<Motor> {

    Connection connection;

    public MotorDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public int createData(Motor object) throws SQLException {
        String itemsQuery = "INSERT INTO items (name, description, rental_charge_per_day, availability) VALUES (?, ?, ?, ?)";
        String motorQuery = "INSERT INTO motorcycle_items (item_id, manufacturer, model, production_year) VALUES (?, ?, ?, ?)";

        PreparedStatement itemInsertStatement = connection.prepareStatement(itemsQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        itemInsertStatement.setString(1, object.getName());
        itemInsertStatement.setString(2, object.getDescription());
        itemInsertStatement.setDouble(3, object.getRentalChargePerDay());
        itemInsertStatement.setBoolean(4, object.isAvailbility());

        itemInsertStatement.executeUpdate();


        ResultSet generatedKeys = itemInsertStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int itemID = generatedKeys.getInt(1);


            PreparedStatement motorInsertStatement = connection.prepareStatement(motorQuery);
            motorInsertStatement.setInt(1, itemID);
            motorInsertStatement.setString(2, object.getPabrikan());
            motorInsertStatement.setString(3, object.getModel());
            motorInsertStatement.setInt(    4, object.getTahunKeluar());


            motorInsertStatement.executeUpdate();

            connection.commit();
        } else {
            throw new SQLException("Failed to create a item.");
        }
        return generatedKeys.getInt(1);
    }

    @Override
    public List<Motor> readData() throws SQLException {
        String query = "select i.*, mi.* from items i join motorcycle_items mi  on i.id = mi.item_id;";
        PreparedStatement queryStatement = connection.prepareStatement(query);
        List<Motor> motorList = new ArrayList<>();
        ResultSet res = queryStatement.executeQuery();
        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            String desc = res.getString("description");
            double charge = res.getDouble("rental_charge_per_day");
            boolean avail = res.getBoolean("availability");
            String manufactur = res.getString("manufacturer");
            String model = res.getString("model");
            int year = res.getInt("production_year");

            Motor mobil = new Motor(id, name, desc, charge, avail, manufactur, model, year);
            motorList.add(mobil);

        }
        return motorList;
    }

    @Override
    public void updateData(Motor object) throws SQLException {
        String updateItems = "UPDATE items SET name = ?, description = ?, rental_charge_per_day = ?, availability = ? WHERE id = ?";
        String updateMotor = "UPDATE motorcycle_items SET manufacturer = ?, model = ?, production_year = ? WHERE item_id = ?";
        PreparedStatement itemsStatement = connection.prepareStatement(updateItems);
        PreparedStatement motorStatement = connection.prepareStatement(updateMotor);

        itemsStatement.setString(1, object.getName());
        itemsStatement.setString(2, object.getDescription());
        itemsStatement.setDouble(3, object.getRentalChargePerDay());
        itemsStatement.setBoolean(4, object.isAvailbility());
        itemsStatement.setInt(5, object.getItemID());

        motorStatement.setString(1, object.getPabrikan());
        motorStatement.setString(2, object.getModel());
        motorStatement.setInt(3, object.getTahunKeluar());
        motorStatement.setInt(4, object.getItemID());

        itemsStatement.executeUpdate();
        motorStatement.executeUpdate();

        connection.commit();
    }

    @Override
    public void deleteData(Motor object) throws SQLException {
        throw new RuntimeException("Method Not Used");
    }
}
