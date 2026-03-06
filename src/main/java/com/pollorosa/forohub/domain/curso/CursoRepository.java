package com.pollorosa.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByNombre(String nombre);

    /*@Query("SELECT c FROM Curso c WHERE c.activo = TRUE AND c.nombre = :nombre ORDER BY c.id ASC LIMIT 1")
    Curso encontrarActivoPorNombre(String nombre);*/
    List<Curso> findByActivoAndNombre(boolean activo, String nombre);
}
