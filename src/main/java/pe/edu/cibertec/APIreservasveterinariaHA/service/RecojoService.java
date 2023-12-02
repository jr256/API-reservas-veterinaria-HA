package pe.edu.cibertec.APIreservasveterinariaHA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.APIreservasveterinariaHA.mapper.RecojoMapper;
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

    public List<Recojo> listarRecojos(){
        return recojoRepository.listarRecojos();
    }

    public List<RecojoDto> buscarRecojosPorMascota(Integer idMascota){
        List<Recojo>  recojoList = recojoRepository.buscarRecojosPorMascota(idMascota);
        return new ArrayList<>(recojoList.stream().map(recojo -> recojoMapper.fromRecojo(recojo)).collect(Collectors.toList()));
    }

}
