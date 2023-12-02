package pe.edu.cibertec.APIreservasveterinariaHA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.APIreservasveterinariaHA.mapper.RecojoMapper;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Recojo;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.RecojoDto;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.RecojoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecojoService {

    @Autowired
    private RecojoRepository recojoRepository;

    private RecojoMapper recojoMapper;

    public Recojo programarRecojo(Recojo recojo){
        return recojoRepository.save(recojo);

    }



    public List<Recojo> listarRecojosReservados( String fecha) {
        return recojoRepository.buscarRecojosReservados(fecha);
    }

    public List<Recojo> buscarRecojosPorMascota(Integer idMascota){
        return recojoRepository.buscarRecojosPorMascota(idMascota);

    }

}
