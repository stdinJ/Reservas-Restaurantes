package io.github.stdinJ.apiReservas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.stdinJ.apiReservas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNome(String nome);
}
