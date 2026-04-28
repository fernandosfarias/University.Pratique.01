package View;

import service.UsuarioService;
import model.Usuario;

public class LoginView {

    public void fazerLogin(String login, String senha) {

        try {
            UsuarioService service = new UsuarioService();

            Usuario usuario = service.login(login, senha);

            if (usuario != null) {
                System.out.println("Login OK");
            } else {
                System.out.println("Login inválido");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}