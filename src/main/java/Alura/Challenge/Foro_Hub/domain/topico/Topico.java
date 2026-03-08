package Alura.Challenge.Foro_Hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "topico")
@Entity (name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private StatusTopico status_topico;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {

        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.status_topico = datosRegistroTopico.status_topico();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }

    public void actualizarInfoTopico(@Valid DatosActualizacionTopico datosActualizacionTopico) {
        if (datosActualizacionTopico.titulo() != null) {
            this.titulo = datosActualizacionTopico.titulo();
        }
        if (datosActualizacionTopico.mensaje() != null) {
            this.mensaje = datosActualizacionTopico.mensaje();
        }
        if (datosActualizacionTopico.autor() != null) {
            this.autor = datosActualizacionTopico.autor();
        }
        if (datosActualizacionTopico.curso() != null) {
            this.curso = datosActualizacionTopico.curso();
        }
    }

    public void eliminar() {
        this.status_topico = StatusTopico.INACTIVO;
    }

    @PrePersist
    private void asignacionDeFecha() {

        if (fechaCreacion == null) {
            fechaCreacion = LocalDateTime.now();
        }

        if (status_topico == null) {
            status_topico = StatusTopico.ACTIVO;
        }
    }
}
