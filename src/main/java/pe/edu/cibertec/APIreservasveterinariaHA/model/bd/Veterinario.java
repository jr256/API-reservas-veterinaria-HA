package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idveterinario;

    @Column(name = "nombrecompleto")
    private String nombrecompleto;

    @Column(name = "numerodocumento")
    private String numerodocumento;

    @Column(name = "correo")
    private String correo;


    @ManyToOne
    @JoinColumn(name ="idestado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name ="idespecialidad")
    private Especialidad especialidad;



}
