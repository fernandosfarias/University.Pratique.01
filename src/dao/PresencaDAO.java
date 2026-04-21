package dao;

import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PresencaDAO {

    public void confirmarPresenca(int usuarioId, int eventoId, String status) throws Exception {

        String sql = "INSERT INTO presenca (usuario_id, evento_id, status) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 🔥 registra presença no banco
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, eventoId);
            stmt.setString(3, status);

            stmt.executeUpdate();
        }
    }
}