package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Sede;
import pe.edu.cibertec.APIreservasveterinariaHA.service.SedeService;
import pe.edu.cibertec.APIreservasveterinariaHA.service.ServicioService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "sede")
@CrossOrigin(origins = "http://localhost:4200")
public class SedeController {

    private SedeService sedeService;
    @GetMapping("")
    public ResponseEntity<List<Sede>> listarSedes(){
        List<Sede> sedeList = new ArrayList<>();
        sedeService.listarSedes()
                .forEach(sedeList::add);
        if(sedeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sedeList, HttpStatus.OK);
    }

}
