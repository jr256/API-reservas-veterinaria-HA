package pe.edu.cibertec.APIreservasveterinariaHA.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.DtoEntity;

@Component
public class DtoUtil {

    public DtoEntity convertirADto(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public static Object convertirAEntidad(Object obj, Object mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }
    public static Object convertirADominio(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }

}
