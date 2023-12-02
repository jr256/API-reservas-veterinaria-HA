package pe.edu.cibertec.APIreservasveterinariaHA.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Recojo;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.RecojoDto;

@Service
public class RecojoMapper {

    public RecojoDto fromRecojo(Recojo recojo) {
        RecojoDto recojoDTO = new RecojoDto();
        BeanUtils.copyProperties(recojo, recojoDTO);
        return recojoDTO;
    }

    public Recojo fromRecojoDTO(RecojoDto recojoDTO) {
        Recojo recojo = new Recojo();
        BeanUtils.copyProperties(recojoDTO, recojo);
        return recojo;
    }
}
