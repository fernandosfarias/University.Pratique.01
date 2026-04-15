import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        mostrarLogin();
    }

    public void mostrarLogin() {
        LoginView login = new LoginView();

        Scene scene = new Scene(login.getView(), 400, 300);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    public void mostrarCadastro() {
        CadastroView cadastroView = new CadastroView();

        Scene scene = new Scene(cadastroView.getView(), 400, 350);
        stage.setScene(scene);
        stage.setTitle("Cadastro");
    }

    public static void main(String[] args) {
        launch();
    }
}