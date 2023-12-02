package pe.edu.cibertec.APIreservasveterinariaHA.service;

import org.springframework.data.domain.Page;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Mascota;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.MascotaDto;

public interface MascotaService {

    Mascota loadMascotaById(Integer id);

    MascotaDto loadMascotaByEmail(String email);

    MascotaDto createMascota(MascotaDto mascotaDto);

    MascotaDto updateMascota(MascotaDto mascotaDto);

    Page<MascotaDto> loadMascotasByName(String name, int page, int size);


}
