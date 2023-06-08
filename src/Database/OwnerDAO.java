package Database;

import User.Owner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OwnerDAO implements InterfaceDAO<Owner> {

    Connection connection;

    public OwnerDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Owner object) {

    }

    @Override
    public List<Owner> readData() {
        return null;
    }

    @Override
    public void updateData(Owner object) {

    }

    @Override
    public void deleteData(Owner object) throws SQLException {

    }
}
