package view;

import javax.swing.*;
import service.usuarioservice;
import model.usuario;

public class loginview extends JFrame {

    public loginview() {

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setBounds(50, 50, 80, 25);
        painel.add(lblLogin);

        JTextField txtLogin = new JTextField();
        txtLogin.setBounds(120, 50, 150, 25);
        painel.add(txtLogin);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 100, 80, 25);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(120, 100, 150, 25);
        painel.add(txtSenha);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(50, 160, 100, 30);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(170, 160, 120, 30);

        usuarioservice service = new usuarioservice();

        // LOGIN
        btnEntrar.addActionListener(e -> {

            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());

            usuario usuario = service.login(login, senha);

            if (usuario != null) {

                JOptionPane.showMessageDialog(null, "Login OK");

            } else {

                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            }
        });

        // CADASTRO
        btnCadastrar.addActionListener(e -> {

            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());

            service.cadastrar(login, senha);

            JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
        });

        painel.add(btnEntrar);
        painel.add(btnCadastrar);

        add(painel);

        setVisible(true);
    }
}