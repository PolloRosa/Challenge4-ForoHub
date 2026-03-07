package com.pollorosa.forohub.infra.exceptions;

import com.pollorosa.forohub.domain.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GestorDeExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity gestionarError404ConversionAEnteros(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.badRequest().body(new DatosErrorValidacion(ex.getName(), "Debe ser un número válido."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarError400(MethodArgumentNotValidException ex) {
        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(
                errores.stream()
                        .map(DatosErrorValidacion::new)
                        .toList());
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity gestionarErrorDeValidacion(ValidacionException ex) {
        return ResponseEntity.badRequest().body(new DatosRetornoValidacion("Error de validación", ex.getMessage()));
    }

    public record DatosErrorValidacion(
            String campo,
            String mensaje) {

        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    public record DatosRetornoValidacion(
            String error,
            String mensaje) {
    }

}
