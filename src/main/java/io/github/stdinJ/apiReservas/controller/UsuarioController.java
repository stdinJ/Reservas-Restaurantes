package io.github.stdinJ.apiReservas.controller;

import io.github.stdinJ.apiReservas.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/cadastrarmesas")
    public String salvarUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario);
        return "Usuário cadastrado com sucesso!";
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}
