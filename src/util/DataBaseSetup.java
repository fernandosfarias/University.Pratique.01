package util;

import java.sql.Connection;
import java.sql.Statement;

public class DataBaseSetup {

    public static void recriarBanco() {

        String sql = """
            DROP TABLE IF EXISTS usuario;
            DROP TABLE IF EXISTS evento;
            DROP TABLE IF EXISTS presenca;

            CREATE TABLE usuario (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                login TEXT UNIQUE,
                senha TEXT,
                email TEXT
            );

            CREATE TABLE evento (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT,
                descricao TEXT,
                data TEXT,
                local TEXT,
                criador_id INTEGER
            );

            CREATE TABLE presenca (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                usuario_id INTEGER,
                evento_id INTEGER,
                status TEXT
            );
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            // 🔥 AQUI executa tudo no app.db
            stmt.executeUpdate(sql);

            System.out.println("Banco recriado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}