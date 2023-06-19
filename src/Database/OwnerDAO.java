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
    public int createData(Owner object) throws SQLException{
        String userInsertQuery = "INSERT INTO users (username, password, email, user_type) VALUES (?, ?, ?, ?)";
        String ownerInsertQuery = "INSERT INTO rental_owners (user_id, shop_name, location, item_rented) VALUES (?, ?, ?, ?)";

        PreparedStatement userInsertStatement = connection.prepareStatement(userInsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        userInsertStatement.setString(1, object.getUserName());
        userInsertStatement.setString(2, object.getPassword());
        userInsertStatement.setString(3, object.getEmail());
        userInsertStatement.setString(4, object.getTipe());
        userInsertStatement.executeUpdate();

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
            throw new SQLException("Failed to create a owner account.");
        }
        return generatedKeys.getInt(1);
    }

    @Override
    public List<Owner> readData() throws SQLException{
        String query = "select u.*, ro. * from users u join rental_owners ro on u.id = ro.user_id";
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
            List<Item> itemRent = new ArrayList<>();
            if (itemRented != null){
                Integer[] item = (Integer[]) itemRented.getArray();
                for (int i = 0; i < item.length; i++){
                    int idCari = item[i];
                    Item itemToAdd = items.stream().filter(idItem -> idItem.getItemID() == idCari).findFirst().orElse(null);
                    itemRent.add(itemToAdd);
                }
            }
            Owner owner = new Owner(id, name, password, email,userType, shopName,location,itemRent);
            owners.add(owner);
        }
        return owners;
    }

    @Override
    public void updateData(Owner object) throws SQLException {
        String updateUsers = "UPDATE users SET username = ?, password = ?, email = ?, user_type = ? WHERE id = ?";
        String updateOwner = "UPDATE rental_owners SET shop_name = ?, location = ?, item_rented = ? WHERE user_id = ?";
        PreparedStatement userStatement = connection.prepareStatement(updateUsers);
        PreparedStatement ownerStatement = connection.prepareStatement(updateOwner);

        userStatement.setString(1, object.getUserName());
        userStatement.setString(2, object.getPassword());
        userStatement.setString(3, object.getEmail());
        userStatement.setString(4, object.getTipe());
        userStatement.setInt(5, object.getUserID());

        ownerStatement.setString(1, object.getShopName());
        ownerStatement.setString(2, object.getLocation());
        List<Integer> listIdItem = new ArrayList<>();
        for (Item item: object.getItemRented()) {
            listIdItem.add(item.getItemID());
        }
        Array item = connection.createArrayOf("integer", listIdItem.toArray(new Integer[0]));
        ownerStatement.setArray(3, item);
        ownerStatement.setInt(4, object.getUserID());

        userStatement.executeUpdate();
        ownerStatement.executeUpdate();

        connection.commit();
    }

    @Override
    public void deleteData(Owner object) throws SQLException {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, object.getUserID());
        statement.executeUpdate();
        connection.commit();
    }
}
