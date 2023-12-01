package pe.edu.cibertec.APIreservasveterinariaHA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Recojo;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.RecojoRepository;
@Service
public class RecojoService {

    @Autowired
    private RecojoRepository recojoRepository;

    public Recojo programarRecojo(Recojo recojo){
        return recojoRepository.save(recojo);

    }

}
