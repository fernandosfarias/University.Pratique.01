package dao;

import java.util.ArrayList;
import model.evento;

public class eventosdao {

    private static ArrayList<evento> eventos = new ArrayList<>();

    public void salvar(evento evento) {

        eventos.add(evento);
    }

    public ArrayList<evento> listar() {

        return eventos;
    }
}