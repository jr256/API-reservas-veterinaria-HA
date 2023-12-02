package pe.edu.cibertec.APIreservasveterinariaHA.model.dto;

import lombok.Data;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.DistritoCobertura;

@Data
public class RecojoDto implements DtoEntity{


    private Integer idrecojo;
    private String fecha;
    private ServicioDto servicio;
    private MascotaDto mascota;
    private DistritoCoberturaDto distrito;


}
