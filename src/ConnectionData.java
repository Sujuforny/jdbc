import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionData {
    public static DataSource dataSource(){
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setUser("postgres");
        pgSimpleDataSource.setPassword("123456");
        pgSimpleDataSource.setDatabaseName("student");
        return pgSimpleDataSource;
    }
}
