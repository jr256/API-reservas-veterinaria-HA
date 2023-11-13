package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmascota;

    @Column(name = "correopropietario")
    private String correopropietario;

    @Column(name = "nombrepropietario")
    private String nombrepropietario;

    @Column(name = "nombremascota")
    private String nombremascota;

    @Column(name = "fechanacimiento")
    private String fechanacimiento;

    @Column(name = "raza")
    private String raza;

    @ManyToOne
    @JoinColumn(name ="idestado")
    private Estado estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

}
