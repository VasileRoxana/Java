
package crud;

import java.sql.SQLException;
import java.sql.Statement;
import models.DbConn;


public class Crud implements AutoCloseable {

    protected final DbConn dbConn = new DbConn();
    protected final Statement stmt;

    public Crud() throws SQLException, ClassNotFoundException {
        stmt = dbConn.getConnection().createStatement();
    }
    
    @Override
    public void close() throws Exception {
        if (stmt != null) {
            stmt.close();
        }
        dbConn.close();
    }
}
