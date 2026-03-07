package Alura.Challenge.Foro_Hub.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status_topico,
        String autor,
        String curso
) {

    public DatosListaTopico(Topico topico) {

        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus_topico(),
                topico.getAutor(),
                topico.getCurso()
        );

    }

}
