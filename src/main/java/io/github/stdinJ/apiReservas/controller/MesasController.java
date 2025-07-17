package io.github.stdinJ.apiReservas.controller;

import io.github.stdinJ.apiReservas.model.Mesas;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesasController {
    private List<Mesas> mesas = new ArrayList<>();

    @PostMapping("/cadastrarmesas")
    public String salvarMesas(@RequestBody Mesas mesa) {
        mesas.add(mesa);
        System.out.println("Mesa cadastrada: " + mesa);
        return "Mesa cadastrada com sucesso!";
    }

    @GetMapping
    public List<Mesas> listarMesas() {
        return mesas;
    }
}
