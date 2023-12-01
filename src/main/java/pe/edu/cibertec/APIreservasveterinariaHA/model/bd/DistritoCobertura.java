package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="distritocobertura")
public class DistritoCobertura {

    @Id
    private Integer iddistrito;

    @Column(name = "distrito")
    private String distrito;
}
