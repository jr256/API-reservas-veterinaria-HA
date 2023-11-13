package pe.edu.cibertec.APIreservasveterinariaHA.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="estadoservicio")
public class EstadoServicio {

    @Id
    private Integer idestadoservicio;

    @Column(name = "estadoservicio")
    private String estadoservicio;

}
