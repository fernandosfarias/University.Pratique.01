package util;

import java.sql.Connection;
import java.sql.Statement;

public class DataBaseSetup {

    public static void recriarBanco() {

        String sql = ""
                + "DROP TABLE IF EXISTS usuario;\n"
                + "DROP TABLE IF EXISTS evento;\n"
                + "DROP TABLE IF EXISTS presenca;\n"
                + "\n"
                + "CREATE TABLE usuario (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    login TEXT UNIQUE,\n"
                + "    senha TEXT,\n"
                + "    email TEXT\n"
                + ");\n"
                + "\n"
                + "CREATE TABLE evento (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    nome TEXT,\n"
                + "    descricao TEXT,\n"
                + "    data TEXT,\n"
                + "    local TEXT,\n"
                + "    criador_id INTEGER\n"
                + ");\n"
                + "\n"
                + "CREATE TABLE presenca (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    usuario_id INTEGER,\n"
                + "    evento_id INTEGER,\n"
                + "    status TEXT\n"
                + ");\n";

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