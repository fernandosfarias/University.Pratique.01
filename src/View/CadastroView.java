package View;

import javax.swing.*;
import java.awt.*;

public class CadastroView {

    private JPanel layout;

    public CadastroView() {
        layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
        layout.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Cadastro");
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField nomeField = new JTextField();
        nomeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nomeField.getPreferredSize().height));
        nomeField.setAlignmentX(Component.LEFT_ALIGNMENT);
        nomeField.setToolTipText("Nome");

        JTextField emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, emailField.getPreferredSize().height));
        emailField.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailField.setToolTipText("Email");

        JPasswordField senhaField = new JPasswordField();
        senhaField.setMaximumSize(new Dimension(Integer.MAX_VALUE, senhaField.getPreferredSize().height));
        senhaField.setAlignmentX(Component.LEFT_ALIGNMENT);
        senhaField.setToolTipText("Senha");

        JPasswordField confirmarSenhaField = new JPasswordField();
        confirmarSenhaField.setMaximumSize(new Dimension(Integer.MAX_VALUE, confirmarSenhaField.getPreferredSize().height));
        confirmarSenhaField.setAlignmentX(Component.LEFT_ALIGNMENT);
        confirmarSenhaField.setToolTipText("Confirmar Senha");

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        cadastrarButton.addActionListener(e -> System.out.println("Usuário cadastrado!"));

        layout.add(titulo);
        layout.add(Box.createRigidArea(new Dimension(0, 10)));
        layout.add(nomeField);
        layout.add(Box.createRigidArea(new Dimension(0, 10)));
        layout.add(emailField);
        layout.add(Box.createRigidArea(new Dimension(0, 10)));
        layout.add(senhaField);
        layout.add(Box.createRigidArea(new Dimension(0, 10)));
        layout.add(confirmarSenhaField);
        layout.add(Box.createRigidArea(new Dimension(0, 10)));
        layout.add(cadastrarButton);
    }

    public JPanel getView() {
        return layout;
    }
}
