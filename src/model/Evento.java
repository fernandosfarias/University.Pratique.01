package model;

public class Evento {

    private int id;
    private String nome;
    private String descricao;
    private String data;
    private String local;
    private int criadorId;

    // 🔹 Construtor vazio
    public Evento() {}

    // 🔹 Construtor completo (opcional, mas útil)
    public Evento(String nome, String descricao, String data, String local, int criadorId) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.criadorId = criadorId;
    }

    // 🔹 Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCriadorId() {
        return criadorId;
    }

    public void setCriadorId(int criadorId) {
        this.criadorId = criadorId;
    }
}