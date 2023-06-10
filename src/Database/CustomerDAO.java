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
        ItemDAO itemDAO = new ItemDAO();
        List<Item> items = itemDAO.readData();
        String queryStatement = "SELECT * FROM users NATURAL JOIN customers";
        PreparedStatement statement = connection.prepareStatement(queryStatement);
        ResultSet res = statement.executeQuery();
        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("username");
            String password = res.getString("password");
            String email = res.getString("email");
            String userType = res.getString("user_type");
            String phone = res.getString("phonenumber");
            String address = res.getString("address");
            String loyalty = res.getString("loyaltytype");
            int numberBorrow = res.getInt("numberborrow");
            Array rented = res.getArray("rented_item");
            double balance = res.getDouble("balance");
            Integer[] rent = (Integer[]) rented.getArray();
            List<Item> rentedItem = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < items.size(); i++){
                if (items.get(i).getItemID() == rent[j]){
                    rentedItem.add(items.get(i));
                    j++;
                }
            }
            Customer customer = new Customer(id, name, email, password, userType, phone, address, rentedItem, loyalty, numberBorrow,balance);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void updateData(Customer object) throws SQLException {
        String updateUsers = "UPDATE users SET username = ?, password = ?, email = ?, user_type = ? WHERE id = ?";
        String updateCustomer = "UPDATE customers SET phonenumber = ?, loyaltytype = ?, numberborrow = ?, balance = ?, rented_item = ? WHERE user_id = ?";
        PreparedStatement userStatement = connection.prepareStatement(updateUsers);
        PreparedStatement customerStatement = connection.prepareStatement(updateCustomer);

        userStatement.setString(1, object.getUserName());
        userStatement.setString(2, object.getPassword());
        userStatement.setString(3, object.getEmail());
        userStatement.setString(4, object.getTipe());
        userStatement.setInt(5, object.getUserID());

        customerStatement.setString(1, object.getPhoneNumber());
        customerStatement.setString(2, object.getLoyaltyType());
        customerStatement.setInt(3, object.getNumberBorrow());
        customerStatement.setDouble(4, object.getWallet());
        List<Integer> listIdItem = new ArrayList<>();
        for (Item item: object.getRentedItem()) {
            listIdItem.add(item.getItemID());
        }
        Array item = connection.createArrayOf("integer", listIdItem.toArray(new Integer[0]));
        customerStatement.setArray(5, item);
        customerStatement.setInt(6, object.getUserID());

        userStatement.executeUpdate();
        userStatement.executeUpdate();

        connection.commit();

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
