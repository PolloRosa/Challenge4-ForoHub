package com.pollorosa.forohub.domain.topico.validaciones;

import com.pollorosa.forohub.domain.topico.DatosListaTopico;
import com.pollorosa.forohub.domain.topico.DatosRegistroTopico;

import java.util.Optional;

public interface ValidadorDeBusqueda {
    void validar(Optional<String> nombreCurso, Optional<Integer> anioCreacion);
}
