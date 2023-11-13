package pe.edu.cibertec.APIreservasveterinariaHA.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Veterinario;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.VeterinarioRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarioService {

    private VeterinarioRepository veterinarioRepository;

    public List<Veterinario> listarVeterinarios(){
        return veterinarioRepository.findAll();
    }
}
