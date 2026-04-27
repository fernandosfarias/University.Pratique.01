package view;

import service.UsuarioService;

public class CadastroView {

    private final UsuarioService service = new UsuarioService();

    public void cadastrar(String login, String senha, String confirmarSenha, String email) {
        try {
            if (login == null || login.isBlank() || senha == null || senha.isBlank()) {
                throw new IllegalArgumentException("Login e senha são obrigatórios.");
            }

            if (!senha.equals(confirmarSenha)) {
                throw new IllegalArgumentException("Senha e confirmação devem ser iguais.");
            }

            service.cadastrar(login, senha, email);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}

