package dao;

import java.io.*;
import java.util.ArrayList;

import model.usuario;

public class usuariodao {

    private final String ARQUIVO = "usuarios.txt";

    // SALVAR
    public void salvar(usuario usuario) {

        try {

            FileWriter fw =
                new FileWriter(ARQUIVO, true);

            BufferedWriter bw =
                new BufferedWriter(fw);

             bw.write(

                usuario.getLogin() + ";" +

                usuario.getSenha() + ";" +

                usuario.getNomeCompleto() + ";" +

                usuario.getEmail() + ";" +

                usuario.getCpf()
             );

             bw.newLine();

             bw.close();

             System.out.println(
                "Usuário salvo em: " +
                new File(ARQUIVO).getAbsolutePath()
             );

             } catch (Exception e) {

             e.printStackTrace();
             }
        }
    

    // LISTAR USUÁRIOS
    public ArrayList<usuario> listar() {

        ArrayList<usuario> usuarios =
            new ArrayList<>();

        try {

            File arquivo =
                new File(ARQUIVO);

            if (!arquivo.exists()) {

                arquivo.createNewFile();
            }

            BufferedReader br =
                new BufferedReader(
                    new FileReader(arquivo)
                );

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados =
                    linha.split(";");

                usuario usuario =
                    new usuario(

                        dados[0],
                        dados[1],
                        dados[2],
                        dados[3],
                        dados[4]
                    );

                usuarios.add(usuario);
            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return usuarios;
    }

    // LOGIN
    public usuario buscar(
        String login,
        String senha
    ) {

        ArrayList<usuario> usuarios =
            listar();

        for (usuario usuario : usuarios) {

            if (

                usuario.getLogin().equalsIgnoreCase(login)

                &&

                usuario.getSenha().equals(senha)

            ) {

                return usuario;
            }
        }

        return null;
    }

    // VALIDAR LOGIN EXISTENTE
    public boolean existeLogin(String login) {

        ArrayList<usuario> usuarios =
            listar();

        for (usuario usuario : usuarios) {

            if (
                usuario.getLogin().equals(login)
            ) {

                return true;
            }
        }

        return false;
    }

    public boolean existeEmail(String email) {

    ArrayList<usuario> usuarios =
        listar();

    for (usuario usuario : usuarios) {

        if (
            usuario.getEmail().equals(email)
        ) {

            return true;
        }
    }

    return false;
    }
    public boolean existeCpf(String cpf) {

    ArrayList<usuario> usuarios =
        listar();

    for (usuario usuario : usuarios) {

        if (
            usuario.getCpf().equals(cpf)
        ) {

            return true;
        }
    }

    return false;
    }
}