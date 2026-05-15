package service;

import dao.usuariodao;
import model.usuario;

public class usuarioservice {

    private usuariodao dao =
        new usuariodao();

    // CADASTRO
    public boolean cadastrar(

        String login,
        String senha,
        String confirmarSenha,
        String nomeCompleto,
        String email,
        String cpf
    ) {

        if (!senha.equals(confirmarSenha)) {

            return false;
        }

        if (dao.existeLogin(login)) {

            return false;
        }

        if (dao.existeEmail(email)) {

            return false;
        }

        if (dao.existeCpf(cpf)) {

            return false;
        }

        usuario usuario = new usuario(

            login,
            senha,
            nomeCompleto,
            email,
            cpf
        );

        dao.salvar(usuario);

        return true;
    }

    // LOGIN
    public usuario login(
        String login,
        String senha
    ) {

        return dao.buscar(login, senha);
    }
}