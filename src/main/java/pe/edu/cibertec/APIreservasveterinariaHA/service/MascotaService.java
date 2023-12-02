package pe.edu.cibertec.APIreservasveterinariaHA.service;

import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Mascota;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.MascotaDto;

public interface MascotaService {

    Mascota loadMascotaById(Integer id);

    MascotaDto loadMascotaByEmail(String email);

    MascotaDto createMascota(MascotaDto mascotaDto);

    MascotaDto updateMascota(MascotaDto mascotaDto);


}
