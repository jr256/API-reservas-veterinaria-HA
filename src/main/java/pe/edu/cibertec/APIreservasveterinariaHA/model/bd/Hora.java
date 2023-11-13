package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="hora")
public class Hora {

    @Id
    private Integer idhora;

    @Column(name = "hora")
    private String hora;
}
