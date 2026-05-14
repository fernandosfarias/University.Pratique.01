package view;

import javax.swing.*;
import java.util.ArrayList;

import model.evento;
import service.eventosservice;

public class eventosview extends JFrame {

    private eventosservice service = new eventosservice();

    private JTextArea areaEventos;

    public eventosview() {

        setTitle("Sistema de Eventos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);

        // NOME
        JLabel lblNome = new JLabel("Evento:");
        lblNome.setBounds(20, 20, 100, 25);
        painel.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 20, 200, 25);
        painel.add(txtNome);

        // CIDADE
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(20, 60, 100, 25);
        painel.add(lblCidade);

        JTextField txtCidade = new JTextField();
        txtCidade.setBounds(120, 60, 200, 25);
        painel.add(txtCidade);

        // DATA
        JLabel lblData = new JLabel("Data:");
        lblData.setBounds(20, 100, 100, 25);
        painel.add(lblData);

        JTextField txtData = new JTextField();
        txtData.setBounds(120, 100, 200, 25);
        painel.add(txtData);

        // BOTÃO
        JButton btnCadastrar = new JButton("Cadastrar Evento");
        btnCadastrar.setBounds(120, 150, 200, 30);

        painel.add(btnCadastrar);

        // ÁREA DE EVENTOS
        areaEventos = new JTextArea();

        JScrollPane scroll = new JScrollPane(areaEventos);
        scroll.setBounds(20, 220, 540, 200);

        painel.add(scroll);

        // EVENTO DO BOTÃO
        btnCadastrar.addActionListener(e -> {

            String nome = txtNome.getText();
            String cidade = txtCidade.getText();
            String data = txtData.getText();

            service.cadastrarEvento(nome, cidade, data);

            atualizarLista();
        });

        add(painel);

        setVisible(true);
    }

    // ATUALIZAR LISTA
    public void atualizarLista() {

        areaEventos.setText("");

        ArrayList<evento> eventos = service.listarEventos();

        for (evento evento : eventos) {

            areaEventos.append(
                "Evento: " + evento.getNome() +
                " | Cidade: " + evento.getCidade() +
                " | Data: " + evento.getData() +
                "\n"
            );
        }
    }
}