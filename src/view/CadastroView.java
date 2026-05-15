package view;

import javax.swing.*;

import service.usuarioservice;

public class CadastroView extends JFrame {

    public CadastroView() {

        setTitle("Cadastro");
        setSize(450, 500);
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
        JLabel lblConfirmar =
            new JLabel("Confirmar senha:");

        lblConfirmar.setBounds(50, 110, 120, 25);

        painel.add(lblConfirmar);

        JPasswordField txtConfirmar =
            new JPasswordField();

        txtConfirmar.setBounds(180, 110, 180, 25);

        painel.add(txtConfirmar);

        // NOME
        JLabel lblNome =
            new JLabel("Nome completo:");

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

        // BOTÃO
        JButton btnCadastrar =
            new JButton("Cadastrar");

        btnCadastrar.setBounds(140, 320, 150, 40);

        painel.add(btnCadastrar);

        usuarioservice service =
            new usuarioservice();

        btnCadastrar.addActionListener(e -> {

            boolean sucesso =
                service.cadastrar(

                   txtLogin.getText(),

                   new String(
                       txtSenha.getPassword()
                   ),

                   new String(
                       txtConfirmar.getPassword()
                   ),

                   txtNome.getText(),

                   txtEmail.getText(),

                   txtCpf.getText()
               );

           if (sucesso) {

              JOptionPane.showMessageDialog(
                   null,
                   "Cadastro realizado com sucesso!"
              );

             dispose();

            new LoginView();

         } else {

            JOptionPane.showMessageDialog(
                null,
                 "Login, CPF ou Email já cadastrados!"
            );
        }
    });

        add(painel);

        setVisible(true);
    }
}