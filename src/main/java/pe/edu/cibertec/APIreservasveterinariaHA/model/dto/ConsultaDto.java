package pe.edu.cibertec.APIreservasveterinariaHA.model.dto;

import lombok.Data;


@Data
public class ConsultaDto implements DtoEntity {

    private Integer idconsulta;
    private String fecha;
    private HoraDto hora;
    private MascotaDto mascota;
    private EspecialidadDto especialidad;
    private SedeDto sede;
    private VeterinarioDto veterinario;
    private EstadoServicioDto estadoservicio;
}
