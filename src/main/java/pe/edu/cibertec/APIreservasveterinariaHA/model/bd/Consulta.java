package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idconsulta;

    @Column(name = "fecha")
    private String fecha;


    @ManyToOne
    @JoinColumn(name = "idsede")
    private Sede sede;


    @ManyToOne
    @JoinColumn(name = "idespecialidad")
    private Especialidad especialidad;


    @ManyToOne
    @JoinColumn(name = "idhora")
    private Hora hora;


    @ManyToOne
    @JoinColumn(name = "idveterinario")
    private Veterinario veterinario;


    @ManyToOne
    @JoinColumn(name = "idestadoservicio")
    private EstadoServicio estadoservicio;


    @ManyToOne
    @JoinColumn(name = "idmascota")
    private Mascota mascota;



}
