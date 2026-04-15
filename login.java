import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginView {

    private VBox layout;
    private TextField emailField;
    private PasswordField senhaField;
    private Button loginButton;
    private Button cadastroButton;

    public LoginView() {
        layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label titulo = new Label("Login");

        emailField = new TextField();
        emailField.setPromptText("Email");

        senhaField = new PasswordField();
        senhaField.setPromptText("Senha");

        loginButton = new Button("Entrar");
        cadastroButton = new Button("Cadastrar-se");

        layout.getChildren().addAll(
                titulo,
                emailField,
                senhaField,
                loginButton,
                cadastroButton
        );

        // 👉 Eventos (aqui você vai conectar com a lógica depois)
        loginButton.setOnAction(e -> fazerLogin());
        cadastroButton.setOnAction(e -> abrirCadastro());
    }

    public Parent getView() {
        return layout;
    }

    private void fazerLogin() {
        String email = emailField.getText();
        String senha = senhaField.getText();

        System.out.println("Login: " + email + " / " + senha);
    }

    private void abrirCadastro() {
        System.out.println("Abrir tela de cadastro");
    }
}