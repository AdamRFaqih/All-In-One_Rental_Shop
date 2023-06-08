package Database;

import Item.Item;
import User.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements InterfaceDAO<Customer> {
    private Connection connection;

    public CustomerDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Customer customer) throws SQLException{
        String userInsertQuery = "INSERT INTO users (username, password, email, user_type) VALUES (?, ?, ?, ?)";
        String customerInsertQuery = "INSERT INTO customers (user_id, phonenumber, address, loyaltytype, numberborrow, balance, rented_item) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement userInsertStatement = connection.prepareStatement(userInsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        userInsertStatement.setString(1, customer.getUserName());
        userInsertStatement.setString(2, customer.getPassword());
        userInsertStatement.setString(3, customer.getEmail());
        userInsertStatement.setString(4, customer.getTipe());

        // Execute the user insertion statement
        userInsertStatement.executeUpdate();

        // Get the generated user ID
        ResultSet generatedKeys = userInsertStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int userId = generatedKeys.getInt(1);

            //Get item id held by cutomer
            List<Integer> listIdItem = new ArrayList<>();
            for (Item item: customer.getRentedItem()) {
                listIdItem.add(item.getItemID());
            }
            Array item = connection.createArrayOf("integer", listIdItem.toArray(new Integer[0]));

            // Create a prepared statement for customer insertion
            PreparedStatement customerInsertStatement = connection.prepareStatement(customerInsertQuery);
            customerInsertStatement.setInt(1, userId);
            customerInsertStatement.setString(2, customer.getPhoneNumber());
            customerInsertStatement.setString(3, customer.getAddress());
            customerInsertStatement.setString(4, customer.getLoyaltyType());
            customerInsertStatement.setInt(5, customer.getNumberBorrow());
            customerInsertStatement.setDouble(6, customer.getWallet());
            customerInsertStatement.setArray(7, item);

            // Execute the customer insertion statement
            customerInsertStatement.executeUpdate();

            connection.commit();
        } else {
            throw new SQLException("Failed to create a user account.");
        }

        // Close the prepared statements and result set
        userInsertStatement.close();
        generatedKeys.close();
    }

    @Override
    public List<Customer> readData() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String queryStatement = "SELECT * FROM users NATURAL JOIN customers";
        PreparedStatement statement = connection.prepareStatement(queryStatement);
        ResultSet res = statement.executeQuery();
        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("username");
            String password = res.getString("password");
            String email = res.getString("email");

        }
        return customers;
    }

    @Override
    public void updateData(Customer object) {

    }

    @Override
    public void deleteData(Customer object) throws SQLException {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, object.getUserID());
        statement.executeUpdate();
        connection.commit();
    }
}
