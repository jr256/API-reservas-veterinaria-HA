package pe.edu.cibertec.APIreservasveterinariaHA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Sede;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Servicio;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.SedeRepository;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.ServicioRepository;

import java.util.List;
@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarServicios(){
        return servicioRepository.findAll();
    }
}
