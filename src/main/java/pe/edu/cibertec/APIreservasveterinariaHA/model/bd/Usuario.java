package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "tipousuario")
    private String tipousuario;

    @Getter
    @Setter
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Mascota mascota;

}
