package io.github.stdinJ.apiReservas.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mesas")
public class Mesas {
    @Id
    private int id;
    private String num;
    private int capacidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", num='" + num + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}
