package dao;

import model.Usuario;
import util.ConnectionFactory;

import java.sql.*;

public class UsuarioDAO {

    public void cadastrar(Usuario usuario) throws Exception {

        String sql = "INSERT INTO usuario (login, senha, email) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 🔥 AQUI envia dados pro banco (app.db)
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());

            stmt.executeUpdate();
        }
    }

    public Usuario login(String login, String senha) throws Exception {

        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            // 🔥 AQUI lê dados do banco
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                return u;
            }
        }

        return null;
    }
}