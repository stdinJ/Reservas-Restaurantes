package io.github.stdinJ.apiReservas.model;
import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mesa_id")
    private int mesaId;

    private int capacidade;

    private String status;

    private String nome;

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Mesas{" +
                "mesaId=" + mesaId +
                ", capacidade=" + capacidade +
                ", status='" + status + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
