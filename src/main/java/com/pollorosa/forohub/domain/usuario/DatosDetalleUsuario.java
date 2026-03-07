package com.pollorosa.forohub.domain.usuario;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String correoElectronico) {

    public DatosDetalleUsuario(Usuario autor) {
        this(autor.getId(), autor.getNombre(), autor.getCorreoElectronico());
    }
}
