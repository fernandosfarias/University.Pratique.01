package view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CadastroView {

    private VBox layout;

    public CadastroView() {
        layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label titulo = new Label("Cadastro");

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField senhaField = new PasswordField();
        senhaField.setPromptText("Senha");

        PasswordField confirmarSenhaField = new PasswordField();
        confirmarSenhaField.setPromptText("Confirmar Senha");

        Button cadastrarButton = new Button("Cadastrar");

        layout.getChildren().addAll(
                titulo,
                nomeField,
                emailField,
                senhaField,
                confirmarSenhaField,
                cadastrarButton
        );

        cadastrarButton.setOnAction(e -> {
            System.out.println("Usuário cadastrado!");
        });
    }

    public Parent getView() {
        return layout;
    }
}    

