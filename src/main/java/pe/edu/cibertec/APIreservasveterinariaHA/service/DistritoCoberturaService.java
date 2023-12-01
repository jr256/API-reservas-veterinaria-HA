package pe.edu.cibertec.APIreservasveterinariaHA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.DistritoCobertura;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.DistritoCoberturaRepository;

import java.util.List;
@Service
public class DistritoCoberturaService {

    @Autowired
    private DistritoCoberturaRepository distritoCoberturaRepository;

    public List<DistritoCobertura> listarDistritosCobertura(){
        return distritoCoberturaRepository.findAll();
    }
}
