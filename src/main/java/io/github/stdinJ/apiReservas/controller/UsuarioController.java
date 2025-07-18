package io.github.stdinJ.apiReservas.controller;

import io.github.stdinJ.apiReservas.model.Usuario;
import io.github.stdinJ.apiReservas.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    private int proximoId = 1;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    //LISTA TODOS OS USUARIOS CADASTRADOS NO BANCO
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    @GetMapping("/{id}/usuario")
    public ResponseEntity<Usuario> acharUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //INCREMENTA PARA CADA USUARIO CADASTRADO
    @PostMapping("/registrar")
    public ResponseEntity<List<Usuario>> salvarUsuarios(@RequestBody List<Usuario> usuarios) {
        List<Usuario> salvos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuario.setId(proximoId++);
            salvos.add(usuarioRepository.save(usuario));
        }
        System.out.println("Usuario cadastrado com sucesso: " + usuarios);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    //LOGIN USUARIO E CRIAÇÃO DO TOKEN JWT
    @PostMapping("/login")
    public void loginUsuario(@RequestBody Usuario usuario){

    }
}
