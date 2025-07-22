package io.github.stdinJ.apiReservas.controller;

import io.github.stdinJ.apiReservas.model.Mesas;
import io.github.stdinJ.apiReservas.model.Usuario;
import io.github.stdinJ.apiReservas.repository.MesasRepository;
import io.github.stdinJ.apiReservas.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mesas")
public class MesasController {

    private final UsuarioRepository usuarioRepository;
    private final MesasRepository mesasRepository;

    // Injeção manual via construtor
    public MesasController(UsuarioRepository usuarioRepository, MesasRepository mesasRepository) {
        this.usuarioRepository = usuarioRepository;
        this.mesasRepository = mesasRepository;
    }

    @PostMapping("/criarmesa")
    public ResponseEntity<Mesas> criarMesa(@RequestBody Mesas mesa, @RequestHeader("userId") Long userId) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(userId);

        if (optionalUsuario.isEmpty() || !"ADMIN".equals(optionalUsuario.get().getRole())) {
            System.out.println("Ação não permitida");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Mesas novaMesa = mesasRepository.save(mesa);

        System.out.println("Nova mesa criada: " + novaMesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMesa);
    }


    @GetMapping
    public List<Mesas> listarMesas() {
        return mesasRepository.findAll();
    }
}
