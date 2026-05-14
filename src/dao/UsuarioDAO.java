package dao;

import java.util.ArrayList;
import model.usuario;

public class usuariodao {

    private static ArrayList<usuario> usuarios = new ArrayList<>();

    // SALVAR
    public void salvar(usuario usuario) {

        usuarios.add(usuario);
    }

    // BUSCAR USUARIO
    public usuario buscar(String login, String senha) {

        for (usuario usuario : usuarios) {

            if (
                usuario.getLogin().equals(login) &&
                usuario.getSenha().equals(senha)
            ) {

                return usuario;
            }
        }

        return null;
    }
}