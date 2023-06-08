package Database;

import Item.Motor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MotorDAO implements InterfaceDAO<Motor> {

    Connection connection;

    public MotorDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Motor object) {

    }

    @Override
    public List<Motor> readData() {
        return null;
    }

    @Override
    public void updateData(Motor object) {

    }

    @Override
    public void deleteData(Motor object) throws SQLException {

    }
}
