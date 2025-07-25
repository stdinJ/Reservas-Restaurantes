package io.github.stdinJ.apiReservas.model;
import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mesaId;
    private String num;
    private int capacidade;

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Mesas{" +
                "mesaId" + mesaId +
                ", num='" + num + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}
