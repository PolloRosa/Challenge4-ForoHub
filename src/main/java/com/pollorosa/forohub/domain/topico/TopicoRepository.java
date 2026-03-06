package com.pollorosa.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Long countByTituloAndMensaje(String titulo, String mensaje);
}
