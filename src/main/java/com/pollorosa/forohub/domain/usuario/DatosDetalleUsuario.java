package com.pollorosa.forohub.domain.usuario;

public record DatosDetalleUsuario(
        String nombre,
        String correoElectronico) {

    public DatosDetalleUsuario(Usuario autor) {
        this(autor.getNombre(), autor.getCorreoElectronico());
    }
}
