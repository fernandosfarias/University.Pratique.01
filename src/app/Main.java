package app;

import view.LoginView;

public class Main {
    public static void main(String[] args) {

        LoginView tela = new LoginView();

        // teste simples
        tela.fazerLogin("admin", "123");
    }
}