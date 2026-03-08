package com.pollorosa.forohub.domain.topico.validaciones;

import com.pollorosa.forohub.domain.ValidacionException;
import com.pollorosa.forohub.domain.topico.DatosRegistroTopico;
import com.pollorosa.forohub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDuplicidadTopicos implements ValidadorDeRegistro {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistroTopico datos) {
        var count = topicoRepository.countByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if(count > 0) {
            throw new ValidacionException("No se puede registrar tópico duplicado, debe cambiar título o mensaje.");
        }
    }
}
