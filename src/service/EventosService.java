package service;

import dao.EventosDAO;

public class EventosService {

    private EventosDAO dao = new EventosDAO();

    public void criarEvento(String nome, String descricao, String data, String local, int usuarioId) throws Exception {

        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome obrigatório");
        }

        model.Evento evento = new model.Evento(nome, descricao, data, local, usuarioId);
        dao.criarEvento(evento);
    }
}