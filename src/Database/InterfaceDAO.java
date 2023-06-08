package Database;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    public void createData(T object) throws SQLException;
    public List<T> readData() throws SQLException;
    public void updateData(T object) throws SQLException;
    public void deleteData(T object) throws SQLException;
}
