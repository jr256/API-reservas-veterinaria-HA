package pe.edu.cibertec.APIreservasveterinariaHA.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Mascota;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.MascotaDto;

@Service
public class MascotaMapper {

    public MascotaDto fromMascota(Mascota mascota) {
        MascotaDto mascotaDTO = new MascotaDto();
        BeanUtils.copyProperties(mascota, mascotaDTO);
        return mascotaDTO;
    }

    public Mascota fromMascotaDTO(MascotaDto mascotaDTO) {
        Mascota mascota = new Mascota();
        BeanUtils.copyProperties(mascotaDTO, mascota);
        return mascota;
    }

}
