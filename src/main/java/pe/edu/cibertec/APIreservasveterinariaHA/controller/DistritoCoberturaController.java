package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.DistritoCobertura;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Sede;
import pe.edu.cibertec.APIreservasveterinariaHA.service.DistritoCoberturaService;
import pe.edu.cibertec.APIreservasveterinariaHA.service.SedeService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/cobertura")
@CrossOrigin(origins = "http://localhost:4200")
public class DistritoCoberturaController {

    private DistritoCoberturaService distritoCoberturaService;
    @GetMapping("")
    public ResponseEntity<List<DistritoCobertura>> listarDistritosCobertura(){
        List<DistritoCobertura> distritoCoberturaList = new ArrayList<>();
        distritoCoberturaService.listarDistritosCobertura()
                .forEach(distritoCoberturaList::add);
        if(distritoCoberturaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(distritoCoberturaList, HttpStatus.OK);
    }
}
