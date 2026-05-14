package service;

import dao.usuariodao;
import model.usuario;

public class usuarioservice {

    private usuariodao dao = new usuariodao();

    // CADASTRO
    public void cadastrar(String login, String senha) {

        usuario usuario = new usuario(login, senha);

        dao.salvar(usuario);
    }

    // LOGIN
    public usuario login(String login, String senha) {

        return dao.buscar(login, senha);
    }
}