package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmascota;

     @Column(name = "nombrepropietario")
    private String nombrepropietario;

    @Column(name = "nombremascota")
    private String nombremascota;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;



}
