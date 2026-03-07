package com.pollorosa.forohub.domain.topico;

import com.pollorosa.forohub.domain.curso.DatosDetalleCurso;
import com.pollorosa.forohub.domain.usuario.DatosDetalleUsuario;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        DatosDetalleUsuario autor,
        DatosDetalleCurso curso) {

    public DatosListaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
                new DatosDetalleUsuario(topico.getAutor()), new DatosDetalleCurso(topico.getCurso()));
    }
}
