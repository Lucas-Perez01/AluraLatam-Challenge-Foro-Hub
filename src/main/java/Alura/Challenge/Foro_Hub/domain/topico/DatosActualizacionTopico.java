package Alura.Challenge.Foro_Hub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        String titulo,
        String mensaje,
        String autor,
        String curso
) {
}
