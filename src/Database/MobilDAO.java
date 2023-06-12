package Database;

import Item.Game;
import Item.Mobil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MobilDAO implements InterfaceDAO<Mobil> {

    Connection connection;

    public MobilDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Mobil object) throws SQLException {
        String itemsQuery = "INSERT INTO items (name, description, rental_charge_per_day, availability) VALUES (?, ?, ?, ?)";
        String carQuery = "INSERT INTO car_items (item_id, manufacturer, model, production_year, fuel_type) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement itemInsertStatement = connection.prepareStatement(itemsQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        itemInsertStatement.setString(1, object.getName());
        itemInsertStatement.setString(2, object.getDescription());
        itemInsertStatement.setDouble(3, object.getRentalChargePerDay());
        itemInsertStatement.setBoolean(4, object.isAvailbility());


        ResultSet generatedKeys = itemInsertStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int itemID = generatedKeys.getInt(1);


            PreparedStatement carInsertStatement = connection.prepareStatement(carQuery);
            carInsertStatement.setInt(1, itemID);
            carInsertStatement.setString(2, object.getPabrikan());
            carInsertStatement.setString(3, object.getModel());
            carInsertStatement.setInt(4, object.getTahunKeluaran());
            carInsertStatement.setString(5, object.getBahanBakar());


            carInsertStatement.executeUpdate();

            connection.commit();
        } else {
            throw new SQLException("Failed to create a item.");
        }
    }

    @Override
    public List<Mobil> readData() throws SQLException {
        String query = "SELECT * FROM items NATURAL JOIN car_items";
        PreparedStatement queryStatement = connection.prepareStatement(query);
        List<Mobil> cars = new ArrayList<>();
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
            String fuel = res.getString("fuel_type");

            Mobil mobil = new Mobil(id, name, desc, charge, avail, manufactur, model, year, fuel);
            cars.add(mobil);

        }
        return cars;
    }

    @Override
    public void updateData(Mobil object) throws SQLException {
        String updateItems = "UPDATE items SET name = ?, description = ?, rental_charge_per_day = ?, availability = ? WHERE id = ?";
        String updateCar = "UPDATE car_items SET manufacturer = ?, model = ?, production_year = ?, fuel_type = ? WHERE item_id = ?";
        PreparedStatement itemsStatement = connection.prepareStatement(updateItems);
        PreparedStatement carStatement = connection.prepareStatement(updateCar);

        itemsStatement.setString(1, object.getName());
        itemsStatement.setString(2, object.getDescription());
        itemsStatement.setDouble(3, object.getRentalChargePerDay());
        itemsStatement.setBoolean(4, object.isAvailbility());
        itemsStatement.setInt(5, object.getItemID());

        carStatement.setString(1, object.getPabrikan());
        carStatement.setString(2, object.getModel());
        carStatement.setInt(3, object.getTahunKeluaran());
        carStatement.setString(4, object.getBahanBakar());
        carStatement.setInt(5, object.getItemID());

        itemsStatement.executeUpdate();
        carStatement.executeUpdate();

        connection.commit();
    }

    @Override
    public void deleteData(Mobil object) throws SQLException {
        throw new RuntimeException("Method Not Used");
    }
}
