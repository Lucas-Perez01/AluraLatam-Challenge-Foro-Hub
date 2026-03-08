package Alura.Challenge.Foro_Hub.domain.topico;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        String autor,
        String curso
) {

    public DatosDetalleTopico(Topico topico) {

        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());

    }

}
