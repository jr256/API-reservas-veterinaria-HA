package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idservicio;

    @Column(name = "nombreservicio")
    private String nombreservicio;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name ="idestado")
    private Estado estado;

}
