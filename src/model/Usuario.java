package model;

public class usuario {

    private String login;
    private String senha;
    private String nomeCompleto;
    private String email;
    private String cpf;

    public usuario(
        String login,
        String senha,
        String nomeCompleto,
        String email,
        String cpf
    ) {

        this.login = login;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.cpf = cpf;
      
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}