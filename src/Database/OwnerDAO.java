package Database;

import Item.Item;
import User.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO implements InterfaceDAO<Owner> {

    Connection connection;

    public OwnerDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Owner object) throws SQLException{
        String userInsertQuery = "INSERT INTO users (username, password, email, user_type) VALUES (?, ?, ?, ?)";
        String ownerInsertQuery = "INSERT INTO rental_owners (user_id, shop_name, location, item_rented) VALUES (?, ?, ?, ?)";

        PreparedStatement userInsertStatement = connection.prepareStatement(userInsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        userInsertStatement.setString(1, object.getUserName());
        userInsertStatement.setString(2, object.getPassword());
        userInsertStatement.setString(3, object.getEmail());
        userInsertStatement.setString(4, object.getTipe());

        // Get the generated user ID
        ResultSet generatedKeys = userInsertStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int userId = generatedKeys.getInt(1);

            List<Integer> listIdItem = new ArrayList<>();
            for (Item item: object.getItemRented()) {
                listIdItem.add(item.getItemID());
            }
            Array item = connection.createArrayOf("integer", listIdItem.toArray(new Integer[0]));

            // Create a prepared statement for customer insertion
            PreparedStatement ownerInsertStatement = connection.prepareStatement(ownerInsertQuery);
            ownerInsertStatement.setInt(1, userId);
            ownerInsertStatement.setString(2, object.getShopName());
            ownerInsertStatement.setString(3, object.getLocation());
            ownerInsertStatement.setArray(4, item);


            // Execute the customer insertion statement
            ownerInsertStatement.executeUpdate();

            connection.commit();
        } else {
            throw new SQLException("Failed to create a user account.");
        }
    }

    @Override
    public List<Owner> readData() throws SQLException{
        String query = "SELECT * FROM transactions";
        ItemDAO itemDAO = new ItemDAO();
        List<Owner> owners = new ArrayList<>();
        List<Item> items = itemDAO.readData();
        PreparedStatement queryStatement = connection.prepareStatement(query);
        ResultSet resultSet = queryStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String userType = resultSet.getString("user_type");
            String shopName = resultSet.getString("shop_name");
            String location = resultSet.getString("location");
            Array itemRented = resultSet.getArray("item_rented");
            Integer[] item = (Integer[]) itemRented.getArray();
            List<Item> itemRent = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < items.size(); i++){
                if (items.get(i).getItemID() == item[j]){
                    itemRent.add(items.get(i));
                    j++;
                }
            }
            Owner owner = new Owner(id, name, password, email,userType, shopName,location,itemRent);
            owners.add(owner);
        }
        return null;
    }

    @Override
    public void updateData(Owner object) {

    }

    @Override
    public void deleteData(Owner object) throws SQLException {

    }
}
