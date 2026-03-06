package com.pollorosa.forohub.controller;

import com.pollorosa.forohub.domain.topico.DatosRegistroTopico;
import com.pollorosa.forohub.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var nuevoTopico = topicoService.registrar(datos);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(nuevoTopico.id()).toUri();

        return ResponseEntity.created(uri).body(nuevoTopico);
    }
}
