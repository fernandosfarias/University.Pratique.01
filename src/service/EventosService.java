package service;

import dao.EventosDAO;

public class EventosService {

    private EventosDAO dao = new EventosDAO();

    public void criarEvento(String nome, String descricao, String data, String local, int usuarioId) throws Exception {

        if (nome.isEmpty()) {
            throw new Exception("Nome obrigatório");
        }

        dao.criarEvento(nome, descricao, data, local, usuarioId);
    }
}