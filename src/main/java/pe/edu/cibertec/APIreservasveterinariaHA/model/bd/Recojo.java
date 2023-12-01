package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recojo")
public class Recojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrecojo;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idservicio")
    private Servicio servicio;


    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private DistritoCobertura distrito;

    @ManyToOne
    @JoinColumn(name = "idmascota")
    private Mascota mascota;

}
