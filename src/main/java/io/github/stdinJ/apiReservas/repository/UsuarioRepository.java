package io.github.stdinJ.apiReservas.repository;

import io.github.stdinJ.apiReservas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
