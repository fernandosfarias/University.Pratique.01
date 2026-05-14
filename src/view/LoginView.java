package view;

import javax.swing.*;

import service.usuarioservice;
import model.usuario;

public class LoginView extends JFrame {

    public LoginView() {

        setTitle("Login");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);

        // LOGIN
        JLabel lblLogin = new JLabel("Usuário:");
        lblLogin.setBounds(50, 30, 100, 25);
        painel.add(lblLogin);

        JTextField txtLogin = new JTextField();
        txtLogin.setBounds(180, 30, 180, 25);
        painel.add(txtLogin);

        // SENHA
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(50, 70, 100, 25);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(180, 70, 180, 25);
        painel.add(txtSenha);

        // CONFIRMAR SENHA
        JLabel lblConfirmarSenha =
            new JLabel("Confirmar senha:");

        lblConfirmarSenha.setBounds(50, 110, 120, 25);

        painel.add(lblConfirmarSenha);

        JPasswordField txtConfirmarSenha =
            new JPasswordField();

        txtConfirmarSenha.setBounds(180, 110, 180, 25);

        painel.add(txtConfirmarSenha);

        // NOME COMPLETO
        JLabel lblNome = new JLabel("Nome completo:");
        lblNome.setBounds(50, 150, 120, 25);
        painel.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(180, 150, 180, 25);
        painel.add(txtNome);

        // EMAIL
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 190, 100, 25);
        painel.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(180, 190, 180, 25);
        painel.add(txtEmail);

        // CPF
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(50, 230, 100, 25);
        painel.add(lblCpf);

        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(180, 230, 180, 25);
        painel.add(txtCpf);

        // BOTÕES
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(50, 320, 120, 35);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(220, 320, 140, 35);

        painel.add(btnEntrar);
        painel.add(btnCadastrar);

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

        // CADASTRO
        btnCadastrar.addActionListener(e -> {

            String login = txtLogin.getText();

            String senha =
                new String(txtSenha.getPassword());

            String confirmarSenha =
                new String(
                    txtConfirmarSenha.getPassword()
                );

            String nomeCompleto =
                txtNome.getText();

            String email =
                txtEmail.getText();

            String cpf =
                txtCpf.getText();

            boolean sucesso = service.cadastrar(
                login,
                senha,
                confirmarSenha,
                nomeCompleto,
                email,
                cpf
            );

            if (sucesso) {

                JOptionPane.showMessageDialog(
                    null,
                    "Usuário cadastrado!"
                );

            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "Erro no cadastro!"
                );
            }
        });

        add(painel);

        setVisible(true);
    }
}