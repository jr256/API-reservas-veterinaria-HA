package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Servicio;
import pe.edu.cibertec.APIreservasveterinariaHA.service.ServicioService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "servicio")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {

    private ServicioService servicioService;
    @GetMapping("")
    public ResponseEntity<List<Servicio>> listarServicios(){
        List<Servicio> servicioList = new ArrayList<>();
        servicioService.listarServicios()
                .forEach(servicioList::add);
        if(servicioList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(servicioList, HttpStatus.OK);
    }

}
