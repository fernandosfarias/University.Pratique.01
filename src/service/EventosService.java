package service;

import java.util.ArrayList;

import dao.eventosdao;
import model.evento;

public class eventosservice {

    private eventosdao dao = new eventosdao();

    public void cadastrarEvento(
        String nome,
        String cidade,
        String data
    ) {

        evento evento = new evento(nome, cidade, data);

        dao.salvar(evento);
    }

    public ArrayList<evento> listarEventos() {

        return dao.listar();
    }
}