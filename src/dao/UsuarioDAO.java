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
            stmt.setString(1, getLogin(usuario));
            stmt.setString(2, getSenha(usuario));
            stmt.setString(3, getEmail(usuario));

            stmt.executeUpdate();
        }
    }

    private String getLogin(Usuario usuario) {
        try {
            java.lang.reflect.Field field = Usuario.class.getDeclaredField("login");
            field.setAccessible(true);
            Object value = field.get(usuario);
            return value != null ? value.toString() : null;
        } catch (Exception e) {
            return null;
        }
    }

    private String getSenha(Usuario usuario) {
        try {
            java.lang.reflect.Field field = Usuario.class.getDeclaredField("senha");
            field.setAccessible(true);
            Object value = field.get(usuario);
            return value != null ? value.toString() : null;
        } catch (Exception e) {
            return null;
        }
    }

    private String getEmail(Usuario usuario) {
        try {
            java.lang.reflect.Field field = Usuario.class.getDeclaredField("email");
            field.setAccessible(true);
            Object value = field.get(usuario);
            return value != null ? value.toString() : null;
        } catch (Exception e) {
            return null;
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
                return new Usuario();
            }
        }

        return null;
    }
}