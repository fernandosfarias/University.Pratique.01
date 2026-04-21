package model;

public class Presenca {

    private int id;
    private int usuarioId;
    private int eventoId;
    private String status; // CONFIRMADO / RECUSADO

    public Presenca() {}

    public Presenca(int usuarioId, int eventoId, String status) {
        this.usuarioId = usuarioId;
        this.eventoId = eventoId;
        this.status = status;
    }

    // 🔹 Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}