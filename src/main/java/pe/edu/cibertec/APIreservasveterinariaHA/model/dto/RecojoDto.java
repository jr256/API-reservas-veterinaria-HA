package pe.edu.cibertec.APIreservasveterinariaHA.model.dto;

import lombok.Data;

@Data
public class RecojoDto {


    private Integer idrecojo;
    private String fecha;
    private ServicioDto servicio;

    private MascotaDto mascota;


}
