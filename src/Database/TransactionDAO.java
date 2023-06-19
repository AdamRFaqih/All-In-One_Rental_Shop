package Database;

import Transaction.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements InterfaceDAO<Transaction> {

    Connection connection;

    public TransactionDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public int createData(Transaction object) throws SQLException {
        String createQuery = "INSERT INTO transactions (customer_id, item_id, rental_start_date, rental_end_date, actual_return_date, rental_fee) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(createQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        insertStatement.setInt(1, object.getCustId());
        insertStatement.setInt(2, object.getItemId());
        insertStatement.setDate(3, (Date) object.getStartDate());
        insertStatement.setDate(4, (Date) object.getEndDate());
        insertStatement.setDate(5, (Date) object.getReturnDate());
        insertStatement.setDouble(6, object.getRentalFee());
        insertStatement.executeUpdate();
        connection.commit();
        ResultSet resultSet = insertStatement.getGeneratedKeys();
        return resultSet.getInt(1);

    }

    @Override
    public List<Transaction> readData() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String readQuery = "SELECT * FROM transactions";
        PreparedStatement readStatement = connection.prepareStatement(readQuery);
        ResultSet resultSet = readStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            int custId = resultSet.getInt("customer_id");
            int itemId = resultSet.getInt("item_id");
            Date starDate = resultSet.getDate("rental_start_date");
            Date endDate = resultSet.getDate("rental_end_date");
            Date returnDate = resultSet.getDate("actual_return_date");
            double fee = resultSet.getDouble("rental_fee");
            Transaction transaction = new Transaction(id, custId, itemId, starDate, endDate, returnDate, fee);
            transactions.add(transaction);
        }
        return transactions;
    }

    @Override
    public void updateData(Transaction object) throws SQLException {
        String updateQuery = "UPDATE transactions SET customer_id = ?, item_id = ?, rental_start_date = ?, rental_end_date = ?, actual_return_date = ?, rental_fee = ? WHERE id = ?";
        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.setInt(1, object.getCustId());
        updateStatement.setInt(2, object.getItemId());
        updateStatement.setDate(3, (Date) object.getStartDate());
        updateStatement.setDate(4, (Date) object.getEndDate());
        updateStatement.setDate(5, (Date) object.getReturnDate());
        updateStatement.setDouble(6, object.getRentalFee());
        updateStatement.setInt(7, object.getItemId());
        updateStatement.executeUpdate();
        connection.commit();
    }

    @Override
    public void deleteData(Transaction object) throws SQLException {
        String deleteQuery = "DELETE FROM transactions WHERE id = ?";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
        deleteStatement.setInt(1, object.getTransactionId());
        deleteStatement.executeUpdate();
        connection.commit();
    }
}
