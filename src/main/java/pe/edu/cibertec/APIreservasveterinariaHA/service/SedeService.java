package pe.edu.cibertec.APIreservasveterinariaHA.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Sede;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.SedeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SedeService {

    private SedeRepository sedeRepository;

    public List<Sede> listarSedes(){
        return sedeRepository.findAll();
    }

}
