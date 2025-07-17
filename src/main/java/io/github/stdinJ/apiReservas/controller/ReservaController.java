package io.github.stdinJ.apiReservas.controller;

import io.github.stdinJ.apiReservas.model.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private List<Reserva> reserva = new ArrayList<>();

    @PostMapping("/mesasreservadas")
    public String salvarReserva(@RequestBody Reserva reservaMesa) {
        reserva.add(reservaMesa);
        System.out.println("Usuário cadastrado: " + reserva);
        return "Usuário cadastrado com sucesso!";
    }

    @GetMapping
    public List<Reserva> reservasFeitas() {
        return reserva;
    }
}
