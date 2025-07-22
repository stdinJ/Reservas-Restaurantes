package io.github.stdinJ.apiReservas.controller;

import io.github.stdinJ.apiReservas.model.Mesas;
import io.github.stdinJ.apiReservas.model.Usuario;
import io.github.stdinJ.apiReservas.repository.MesasRepository;
import io.github.stdinJ.apiReservas.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMesa(@PathVariable Long id, @RequestHeader("userId") Long userId) {
        Optional<Usuario> Usuario = usuarioRepository.findById(userId);
        Optional<Mesas> mesa = mesasRepository.findById(id);


        if (Usuario.isEmpty() || !"ADMIN".equals(Usuario.get().getRole())) {
            System.out.println("Ação não permitida");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        if (mesa.isPresent()) {
            mesasRepository.deleteById(id);
            System.out.println("Mesa apagada com sucesso");
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            System.out.println("Mesa não encontrada");
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesas> buscarMesaPorId(@PathVariable Long id) {
        Optional<Mesas> mesa = mesasRepository.findById(id);
        return mesa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Mesas> listarMesas() {
        return mesasRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesas> atualizarMesa(@PathVariable Long id, @RequestBody Mesas mesaAtualizada, @RequestHeader("userId") Long userId) {
        Optional<Usuario> usuario = usuarioRepository.findById(userId);
        if (usuario.isEmpty() || !"ADMIN".equals(usuario.get().getRole())) {
            System.out.println("Ação não permitida");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return mesasRepository.findById(id)
                .map(mesaExistente -> {
                    mesaExistente.setNum(mesaAtualizada.getNum());
                    mesaExistente.setCapacidade(mesaAtualizada.getCapacidade());

                    Mesas mesaSalva = mesasRepository.save(mesaExistente);
                    return ResponseEntity.ok(mesaSalva);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
/*
        | Operação  | HTTP Method | URL              | Proteção Admin? |
        | --------- | ----------- | ---------------- | --------------- |
        | Criar     | POST        | /mesas/criarmesa | Sim             |
        | Listar    | GET         | /mesas           | Não             |
        | Buscar 1  | GET         | /mesas/{id}      | Não             |
        | Atualizar | PUT         | /mesas/{id}      | Sim             |
        | Deletar   | DELETE      | /mesas/{id}      | Sim             |
*/