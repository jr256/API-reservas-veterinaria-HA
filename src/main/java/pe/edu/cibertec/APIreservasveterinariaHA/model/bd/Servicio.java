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

    @Column(name = "servicio")
    private String servicio;


    @ManyToOne
    @JoinColumn(name ="idestado")
    private Estado estado;

}
