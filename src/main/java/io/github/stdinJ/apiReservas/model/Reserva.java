package io.github.stdinJ.apiReservas.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {

    @Id
    private int id;
    private int usuarioId;
    private int mesaId;
    private LocalDateTime horarioReserva;
    private String status;

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

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }

    public LocalDateTime getHorarioReserva() {
        return horarioReserva;
    }

    public void setHorarioReserva(LocalDateTime horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", mesaId=" + mesaId +
                ", horarioReserva=" + horarioReserva +
                ", status='" + status + '\'' +
                '}';
    }
}
