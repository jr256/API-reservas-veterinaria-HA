package pe.edu.cibertec.APIreservasveterinariaHA.mapper;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Servicio;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.ServicioDto;

@Service
public class ServicioMapper {

    //COPILOT Iplmenta las clases mapper para que se puedan convertir de un tipo a otro mis atributos de servicio dto son   private Integer idservicio;
    //    private String servicio;

    public ServicioDto fromServicio(Servicio servicio) {
        ServicioDto servicioDTO = new ServicioDto();
        servicioDTO.setIdservicio(servicio.getIdservicio());
        servicioDTO.setServicio(servicio.getServicio());
        return servicioDTO;
    }

    public Servicio fromServicioDTO(ServicioDto servicioDTO) {
        Servicio servicio = new Servicio();
        servicio.setIdservicio(servicioDTO.getIdservicio());
        servicio.setServicio(servicioDTO.getServicio());
        return servicio;
    }



}
