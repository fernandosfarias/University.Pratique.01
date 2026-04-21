package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public void cadastrar(String login, String senha, String email) throws Exception {

        if (login.isEmpty() || senha.isEmpty()) {
            throw new Exception("Campos obrigatórios");
        }

        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        u.setEmail(email);

        dao.cadastrar(u);
    }

    public Usuario login(String login, String senha) throws Exception {
        return dao.login(login, senha);
    }
}