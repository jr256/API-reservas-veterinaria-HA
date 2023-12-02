package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idrecojo")
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
    @JsonIgnoreProperties("recojos")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "idestadoservicio")
    private EstadoServicio estadoservicio;

}
