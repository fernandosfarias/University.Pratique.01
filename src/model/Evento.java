package model;

public class evento {

    private String nome;
    private String cidade;
    private String data;

    public evento(String nome, String cidade, String data) {

        this.nome = nome;
        this.cidade = cidade;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getData() {
        return data;
    }
}