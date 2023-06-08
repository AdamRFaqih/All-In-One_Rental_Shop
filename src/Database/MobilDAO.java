package Database;

import Item.Mobil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class MobilDAO implements InterfaceDAO<Mobil> {

    Connection connection;

    public MobilDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void createData(Mobil object) {

    }

    @Override
    public List<Mobil> readData() {
        return null;
    }

    @Override
    public void updateData(Mobil object) {

    }

    @Override
    public void deleteData(Mobil object) throws SQLException {

    }
}
