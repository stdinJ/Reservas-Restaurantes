package io.github.stdinJ.apiReservas.dto;

public class CriarMesa {
    private String nome;       // nome da mesa
    private int capacidade;    // capacidade de pessoas
    private String status;     // status da mesa (ex: "livre", "ocupada")

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
