package view;

import javax.swing.*;

import service.usuarioservice;
import model.usuario;

public class LoginView extends JFrame {

    public LoginView() {

        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);

        // LOGIN
        JLabel lblLogin = new JLabel("Usuário:");
        lblLogin.setBounds(50, 40, 100, 25);
        painel.add(lblLogin);

        JTextField txtLogin = new JTextField();
        txtLogin.setBounds(150, 40, 180, 25);
        painel.add(txtLogin);

        // SENHA
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 90, 100, 25);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(150, 90, 180, 25);
        painel.add(txtSenha);

        // BOTÃO ENTRAR
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(50, 150, 120, 35);

        // BOTÃO CADASTRO
        JButton btnCriarConta =
            new JButton("Criar Conta");

        btnCriarConta.setBounds(200, 150, 130, 35);

        painel.add(btnEntrar);
        painel.add(btnCriarConta);

        usuarioservice service = new usuarioservice();

        // LOGIN
        btnEntrar.addActionListener(e -> {

            String login = txtLogin.getText();

            String senha =
                new String(txtSenha.getPassword());

            usuario usuario =
                service.login(login, senha);

            if (usuario != null) {

                JOptionPane.showMessageDialog(
                    null,
                    "Login OK"
                );

                new eventosview();

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "Login inválido"
                );
            }
        });

        // ABRIR CADASTRO
        btnCriarConta.addActionListener(e -> {

            new CadastroView();
        });

        add(painel);

        setVisible(true);
    }
}