package Alura.Challenge.Foro_Hub.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status_topico,
        @NotBlank String autor,
        @NotBlank String curso
        ) {
}
