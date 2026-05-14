package dao;

import model.evento;
import util.connectionfactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class eventosdao {

    // 🔥 CREATE - salva evento no banco
    public void criarEvento(evento evento) throws Exception {

        String sql = "INSERT INTO evento (nome, descricao, data, local, criador_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connectionfactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 🔥 Aqui envia dados para o app.db
            stmt.setString(1, evento.getNome());
            stmt.setString(2, evento.getDescricao());
            stmt.setString(3, evento.getData());
            stmt.setString(4, evento.getLocal());
            stmt.setInt(5, evento.getCriadorId());

            stmt.executeUpdate();
        }
    }

    // 🔍 READ - listar todos eventos
    public List<evento> listarEventos() throws Exception {

        List<evento> lista = new ArrayList<>();

        String sql = "SELECT * FROM evento";

        try (Connection conn = connectionfactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // 🔥 Aqui lê dados do banco (app.db)
            while (rs.next()) {

                evento e = new evento();

                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setData(rs.getString("data"));
                e.setLocal(rs.getString("local"));
                e.setCriadorId(rs.getInt("criador_id"));

                lista.add(e);
            }
        }

        return lista;
    }

    // 🔍 READ - buscar evento por ID
    public evento buscarPorId(int id) throws Exception {

        String sql = "SELECT * FROM evento WHERE id = ?";

        try (Connection conn = connectionfactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                evento e = new evento();

                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setData(rs.getString("data"));
                e.setLocal(rs.getString("local"));
                e.setCriadorId(rs.getInt("criador_id"));

                return e;
            }
        }

        return null;
    }

    // 👤 listar eventos criados por um usuário
    public List<evento> listarPorUsuario(int usuarioId) throws Exception {

        List<evento> lista = new ArrayList<>();

        String sql = "SELECT * FROM evento WHERE criador_id = ?";

        try (Connection conn = connectionfactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                evento e = new evento();

                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setData(rs.getString("data"));
                e.setLocal(rs.getString("local"));
                e.setCriadorId(rs.getInt("criador_id"));

                lista.add(e);
            }
        }

        return lista;
    }
}