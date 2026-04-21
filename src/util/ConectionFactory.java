package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:app.db";

    public static Connection getConnection() throws Exception {
        // 🔥 AQUI é onde conecta com o app.db
        return DriverManager.getConnection(URL);
    }
}