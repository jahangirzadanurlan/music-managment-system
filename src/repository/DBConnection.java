package repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/music_db";
        String username="postgres";
        String password="root";

        return DriverManager.getConnection(url,username,password);
    }
}
