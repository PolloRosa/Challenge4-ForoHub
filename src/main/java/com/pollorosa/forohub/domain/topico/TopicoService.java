package com.pollorosa.forohub.domain.topico;

import com.pollorosa.forohub.domain.ValidacionException;
import com.pollorosa.forohub.domain.curso.CursoRepository;
import com.pollorosa.forohub.domain.topico.validaciones.ValidadorDeRegistro;
import com.pollorosa.forohub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorDeRegistro> validadores;

    public DatosDetalleTopico registrar(@Valid DatosRegistroTopico datos) {
        if(!usuarioRepository.existsById(datos.idUsuario())) {
            throw new ValidacionException("No existe usuario con el id indicado.");
        }

        // validaciones
        // 1 usuario activo
        // 2 existe el curso y es activo
        // 3 duplicidad de topicos (titulo+mensaje unicos)
        validadores.forEach(v -> v.validar(datos));

        var autor = usuarioRepository.findById(datos.idUsuario()).get();
        var curso = cursoRepository.findByNombre(datos.nombreCurso()).get(0);
        var nuevoTopico = new Topico(datos, autor, curso);
        topicoRepository.save(nuevoTopico);

        return new DatosDetalleTopico(nuevoTopico.getId(), nuevoTopico.getTitulo(), nuevoTopico.getMensaje(), nuevoTopico.getFechaCreacion());
    }
}
