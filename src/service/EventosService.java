package service;

import dao.EventosDAO;
import model.Evento;

public class EventosService {

    private EventosDAO dao = new EventosDAO();

    public void criarEvento(String nome, String descricao, String data, String local, int usuarioId) throws Exception {

        if (nome.isEmpty()) {
            throw new Exception("Nome obrigatório");
        }

        Evento evento = new Evento(nome, descricao, data, local, usuarioId);
        dao.criarEvento(evento);
    }
}