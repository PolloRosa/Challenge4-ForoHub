package com.pollorosa.forohub.domain.topico.validaciones;

import com.pollorosa.forohub.domain.ValidacionException;
import com.pollorosa.forohub.domain.curso.Curso;
import com.pollorosa.forohub.domain.curso.CursoRepository;
import com.pollorosa.forohub.domain.topico.DatosRegistroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ValidadorCursoExisteActivoParaBuscar implements ValidadorDeBusqueda {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(Optional<String> nombreCurso, Optional<Integer> anioCreacion) {
        if(nombreCurso.isEmpty()) {
            return;
        }
        List<Curso> cursos = cursoRepository.findByActivoAndNombre(true, nombreCurso.get());
        if(cursos.isEmpty()) {
            throw new ValidacionException("Curso no registrado o inactivo.");
        }
    }
}
