package service;

import dao.eventosdao;
import model.evento;

public class eventosservice {

    private eventosdao dao = new eventosdao();

    public void criarEvento(String nome, String descricao, String data, String local, int usuarioId) throws Exception {

        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome obrigatório");
        }

        evento evento = new evento(nome, descricao, data, local, usuarioId);
        dao.criarevento(evento);
    }
}